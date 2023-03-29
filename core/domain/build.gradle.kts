plugins {
    id("saymyname.android.library")
    id("saymyname.android.library.jacoco")
}

android {
    namespace = "com.emresahin.saymyname.core.domain"
}

dependencies {
    implementation(project(":core:data"))
    implementation(project(":core:model"))

    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.datetime)
}