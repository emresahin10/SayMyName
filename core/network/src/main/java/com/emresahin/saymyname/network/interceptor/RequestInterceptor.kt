package com.emresahin.saymyname.network.interceptor

import android.os.Build
import com.emresahin.saymyname.common.annotation.BuildTime
import com.emresahin.saymyname.common.annotation.BuildType
import com.emresahin.saymyname.common.annotation.BuildVersionCode
import com.emresahin.saymyname.common.annotation.BuildVersionName
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

class RequestInterceptor @Inject constructor(
    @BuildType private val buildType: String,
    @BuildTime private val buildTime: String,
    @BuildVersionCode private val buildVersionCode: String,
    @BuildVersionName private val buildVersionName: String,
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .applyDefaultHeaders()
            .build()

        return chain.proceed(request)
    }

    private fun Request.Builder.applyDefaultHeaders(): Request.Builder {
        addHeader("X-Build-Time", buildTime)
        addHeader("X-Build-Type", buildType)
        addHeader("X-Build-Version-Code", buildVersionCode)
        addHeader("X-Build-Version-Name", buildVersionName)
        addHeader("X-Device-Platform", "Android")
        addHeader("X-Device-Platform-Version", Build.VERSION.SDK_INT.toString())
        addHeader("X-Device-Model", Build.MODEL)
        return this
    }
}