package com.emresahin.saymyname.network.di

import android.content.Context
import coil.ImageLoader
import com.emresahin.saymyname.network.api.SayMyNameApi
import com.emresahin.saymyname.network.interceptor.RequestInterceptor
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.Call
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoreNetworkModule {

    @Provides
    @Singleton
    internal fun provideOkHttpClient(
        requestInterceptor: RequestInterceptor,
    ): OkHttpClient {
        val okHttpBuilder = OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(requestInterceptor)
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        return okHttpBuilder.build()
    }

    @Provides
    @Singleton
    internal fun provideJson() = Json {
        ignoreUnknownKeys = true
        isLenient = true
        coerceInputValues = true
        allowSpecialFloatingPointValues = true
    }

    @Provides
    @Singleton
    fun imageLoader(
        okHttpCallFactory: Call.Factory,
        @ApplicationContext application: Context,
    ): ImageLoader = ImageLoader.Builder(application)
        .callFactory(okHttpCallFactory)
        .respectCacheHeaders(false)
        .build()

    @ExperimentalSerializationApi
    @Provides
    @Singleton
    internal fun provideRetrofit(
        okHttpClient: OkHttpClient,
        json: Json,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://lionfish-app-zk8sh.ondigitalocean.app/")
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    internal fun provideSayMyNameApi(retrofit: Retrofit): SayMyNameApi = retrofit.create()
}