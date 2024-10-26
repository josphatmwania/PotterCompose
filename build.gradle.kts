
//Project level
plugins {
    alias(libs.plugins.androidApplication).apply(false)
    alias(libs.plugins.kotlinAndroid).apply(false)
    alias(libs.plugins.kotlinKapt).apply(false)
    alias(libs.plugins.hiltAndroid).apply(false)
    id("com.google.devtools.ksp") version "1.9.0-1.0.13" apply false


}



