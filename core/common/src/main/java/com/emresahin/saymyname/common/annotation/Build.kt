package com.emresahin.saymyname.common.annotation

import javax.inject.Qualifier

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class BuildTime

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class BuildType

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class BuildVersionName

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class BuildVersionCode
