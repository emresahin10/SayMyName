plugins {
    id("saymyname.android.library")
    id("saymyname.android.library.jacoco")
    id("saymyname.android.hilt")

}

android {
    namespace = "com.emresahin.saymyname.core.common"

}

dependencies {
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.androidx.startup)
    implementation(libs.androidx.work.ktx)
    api(libs.skydoves.only)
}