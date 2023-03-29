package com.emresahin.saymyname.di

import com.emresahin.saymyname.BuildConfig
import com.emresahin.saymyname.common.annotation.BuildTime
import com.emresahin.saymyname.common.annotation.BuildType
import com.emresahin.saymyname.common.annotation.BuildVersionCode
import com.emresahin.saymyname.common.annotation.BuildVersionName
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @BuildType
    @Provides
    fun provideBuildType(): String = BuildConfig.BUILD_TYPE

    @BuildTime
    @Provides
    fun provideBuildTime(): String = BuildConfig.BUILD_TIME

    @BuildVersionCode
    @Provides
    fun provideBuildVersionCode(): String = BuildConfig.VERSION_CODE.toString()

    @BuildVersionName
    @Provides
    fun provideBuildVersionName(): String = BuildConfig.VERSION_NAME

}
