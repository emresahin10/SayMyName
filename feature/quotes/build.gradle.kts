plugins {
    id("saymyname.android.feature")
    id("saymyname.android.library.compose")
    id("saymyname.android.library.jacoco")
}

android {
    namespace = "com.emresahin.saymyname.feature.quotes"
}

dependencies {
    implementation(project(":core:data"))
    implementation(project(":core:ui"))
}
