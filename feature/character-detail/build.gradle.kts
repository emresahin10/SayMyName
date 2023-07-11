plugins {
    id("saymyname.android.feature")
    id("saymyname.android.library.compose")
    id("saymyname.android.library.jacoco")
}

android {
    namespace = "com.emresahin.saymyname.feature.character_detail"
}

dependencies{
    implementation(project(":core:network"))
}
