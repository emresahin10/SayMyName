import java.text.SimpleDateFormat
import java.util.Date
import kotlin.math.pow

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("saymyname.android.application")
    id("saymyname.android.application.compose")
    id("saymyname.android.hilt")
    id("jacoco")

}
fun Int.pow(n: Int): Int = this.toFloat().pow(n).toInt()

android {
    namespace  = "com.emresahin.saymyname"

    defaultConfig {
        applicationId = "com.emresahin.saymyname"

        val major = 1
        val minor = 0
        val patch = 0
        val build = 0
        versionCode = major * 10.pow(6) + minor * 10.pow(4) + patch * 10.pow(2) + build
        versionName = "$major.$minor.$patch"

        vectorDrawables {
            useSupportLibrary = true
        }

        buildConfigField(
            "String",
            "BUILD_TIME",
            "\"${SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").format(Date())}\""
        )
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        compose =  true
        buildConfig = true
    }


    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}
dependencies {

    implementation(project(":core:common"))
    implementation(project(":core:data"))
    implementation(project(":core:domain"))
    implementation(project(":core:model"))
    implementation(project(":core:ui"))
    implementation(project(":feature:characters"))

    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.androidx.compose.runtime.tracing)
    implementation(libs.androidx.compose.material3.windowSizeClass)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.window.manager)
    implementation(libs.coil.kt)
}