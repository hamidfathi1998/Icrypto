buildscript {
val compose_version by extra("1.1.1")
    //    ext {
       val compose_ui_version = "1.1.1"
//    }
    repositories {
        mavenCentral()
        maven("https://jitpack.io")
    }
}// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "7.3.1" apply false
    id("com.android.library") version "7.3.1" apply false
    id("org.jetbrains.kotlin.android") version "1.6.10" apply false
    id("org.jetbrains.kotlin.jvm") version "1.6.10" apply false
}
