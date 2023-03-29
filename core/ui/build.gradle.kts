plugins {
    id("saymyname.android.library")
    id("saymyname.android.library.compose")
    id("saymyname.android.library.jacoco")
}

android {
    namespace = "com.emresahin.saymyname.core.ui"
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:model"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.coil.kt)
    implementation(libs.coil.kt.compose)
    implementation(libs.kotlinx.datetime)
    implementation(libs.airbnb.lottie)


    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.androidx.window.manager)

    api(libs.androidx.compose.foundation)
    api(libs.androidx.compose.foundation.layout)
    api(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.material3.windowSizeClass)
    api(libs.androidx.compose.ui.util)
    api(libs.androidx.compose.runtime)
    implementation(libs.androidx.compose.runtime.livedata)
    api(libs.androidx.tracing.ktx)

    api(libs.kotlinx.collections)

}

