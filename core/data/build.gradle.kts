plugins {
    id("saymyname.android.library")
    id("saymyname.android.hilt")
    id("saymyname.android.library.jacoco")
    id("kotlinx-serialization")
}

android {
    namespace = "com.emresahin.saymyname.core.data"
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:model"))
    implementation(project(":core:network"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.kotlinx.datetime)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.serialization.json)

}