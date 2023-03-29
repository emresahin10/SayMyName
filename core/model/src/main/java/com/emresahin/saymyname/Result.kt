package com.emresahin.saymyname

import kotlin.reflect.KClass

sealed class Result<out T> {
    data class Success<T>(
        val data: T,
    ) : Result<T>()

    data class Error(
        val exception: Exception,
    ) : Result<Nothing>()

    companion object {
        fun success(): Success<Unit> = Success(Unit)
        fun error(message: Any): Error = Error(IllegalStateException(message.toString()))
    }
}

inline val <T> Result<T>.data: T?
    get() = (this as? Result.Success)?.data

inline val <T> Result<T>.exception: Exception?
    get() = (this as? Result.Error)?.exception

inline fun <T> Result<T>.onSuccess(block: (data: T) -> Unit): Result<T> = also {
    data?.let { block(it) }
}

inline fun <T> Result<T>.onError(block: (Exception) -> Unit): Result<T> = also {
    exception?.let { block(it) }
}

inline fun <T> tryForResult(block: () -> T): Result<T> {
    return try {
        Result.Success(block())
    } catch (e: Exception) {
        Result.Error(e)
    }
}

inline fun <T, R> Result<T>.mapData(transform: (value: T) -> R): Result<R> = when (this) {
    is Result.Success -> Result.Success(transform(data))
    is Result.Error -> this
}

fun <T, E : Exception> Result<T>.dropDialogOnException(exception: KClass<E>): Result<T> =
    when (this) {
        is Result.Success -> this
        is Result.Error -> when (exception == this.exception::class) {
            true -> this.copy()
            false -> this
        }
    }

inline fun <T, R> Result<List<T>>.mapIterableData(transform: (value: T) -> R): Result<List<R>> =
    when (this) {
        is Result.Success -> Result.Success(
            data.map(transform),

            )

        is Result.Error -> this
    }

inline fun <T> Result<T>.mapException(
    transform: (exception: Exception) -> Exception,
): Result<T> = when (this) {
    is Result.Error -> Result.Error(transform(exception))
    else -> this
}

fun <T> Result<T>.toUnit(): Result<Unit> = mapData { }

@Throws(KotlinNullPointerException::class)
fun <T> Result<T?>.requireNonNull(): Result<T> = mapData { it!! }

