plugins {
    id("saymyname.android.library")
    id("saymyname.android.hilt")
    id("saymyname.android.library.jacoco")
    id("kotlinx-serialization")

}

android {
    namespace = "com.emresahin.saymyname.core.network"
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:model"))

    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.kotlinx.datetime)
    implementation(libs.okhttp.logging)
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.kotlin.serialization)
    implementation(libs.coil.kt)
}