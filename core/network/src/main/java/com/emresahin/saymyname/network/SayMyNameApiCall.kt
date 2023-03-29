package com.emresahin.saymyname.network

import com.emresahin.saymyname.Result
import com.emresahin.saymyname.common.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SayMyNameApiCall @Inject constructor(
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) {
    suspend operator fun <T> invoke(
        call: suspend () -> T,
    ): Result<T?> = withContext(ioDispatcher) {
        try {
            val response = call()
            Result.Success(response)
        } catch (exception: HttpException) {
            val errorBody = exception.response()?.errorBody()?.string()
                ?: return@withContext Result.Error(exception)
            return@withContext Result.Error(Exception(errorBody))
        } catch (exception: Exception) {
            Result.Error(exception)
        }
    }
}
