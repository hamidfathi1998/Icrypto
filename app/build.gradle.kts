plugins {
    id(Dependencies.Plugins.application)
    id(Dependencies.Plugins.kotlinAndroid)
}

android {
    namespace = AppConfig.applicationId
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.androidTestInstrumentation
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = AppConfig.javaCompatibility
        targetCompatibility = AppConfig.javaCompatibility
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Dependencies.Android.Version.compose
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
// Android
    implementation(Dependencies.Android.coreKts)
    implementation(Dependencies.Android.appCompat)
    implementation(Dependencies.Android.activityCompose)
    implementation(Dependencies.Android.navigationCompose)

    implementation(Dependencies.Android.composeUi)
    implementation(Dependencies.Android.composeMaterial)
    implementation(Dependencies.Android.composeUiTooling)
    implementation(Dependencies.Android.composeUiToolingPreview)

    implementation(Dependencies.Android.lifecycleRuntimeKtx)
    implementation(Dependencies.Android.lifecycleViewModelKtx)
    implementation(Dependencies.Android.lifecycleExtensions)
    implementation(Dependencies.Android.lifecycleViewModelCompose)

    // Third Party
    implementation(Dependencies.ThirdParty.coilCompose)
    implementation(Dependencies.ThirdParty.androidMaterial)

    implementation(Dependencies.ThirdParty.kotlinxCoroutinesCore)
    implementation(Dependencies.ThirdParty.kotlinxCoroutinesAndroid)

    implementation(Dependencies.ThirdParty.retrofit)
    implementation(Dependencies.ThirdParty.retrofitConverterGson)
    implementation(Dependencies.ThirdParty.okhttp)

    implementation(Dependencies.ThirdParty.koinAndroid)
    implementation(Dependencies.ThirdParty.koinAndroidxCompose)

    implementation(Dependencies.ThirdParty.mPAndroidChart)

    implementation(Dependencies.ThirdParty.swiperefresh)

    implementation(Dependencies.ThirdParty.webSocket)
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
    implementation("androidx.activity:activity-compose:1.3.1")
    implementation("androidx.compose.ui:ui:${rootProject.extra["compose_version"]}")
    implementation("androidx.compose.ui:ui-tooling-preview:${rootProject.extra["compose_version"]}")
    implementation("androidx.compose.material3:material3:1.0.0-alpha02")
    implementation("androidx.core:core-splashscreen:1.0.0-beta02")
    // Test
    testImplementation(Dependencies.Test.junit)
    testImplementation(Dependencies.Test.kotlinxCoroutinesTest)
    testImplementation(Dependencies.Test.koinTest)

    // Android Test
    androidTestImplementation(Dependencies.AndroidTest.junit)
    androidTestImplementation(Dependencies.AndroidTest.espressoCore)
    androidTestImplementation(Dependencies.AndroidTest.composeJunit)
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:${rootProject.extra["compose_version"]}")
    debugImplementation(Dependencies.AndroidTest.composeUiTooling)
    debugImplementation(Dependencies.AndroidTest.composeUiTestManifest)
    debugImplementation("androidx.compose.ui:ui-tooling:${rootProject.extra["compose_version"]}")
    debugImplementation("androidx.compose.ui:ui-test-manifest:${rootProject.extra["compose_version"]}")
    implementation("androidx.compose.material3:material3:1.0.1")
//
//    // Compose dependencies
//    implementation "com.google.accompanist:accompanist-flowlayout:0.17.0"
//    implementation "androidx.constraintlayout:constraintlayout-compose:1.0.1"
//
//    // Accompanist insets UI
//    implementation "com.google.accompanist:accompanist-insets-ui:0.23.1"

//    //SweetToast
//    implementation "com.github.tfaki:ComposableSweetToast:1.0.1"

//    //lottie
//    implementation("com.airbnb.android:lottie-compose:5.2.0")
//
//    //data store
//    implementation "androidx.datastore:datastore-preferences:1.0.0"
//
//    // permission
//    implementation "com.github.hamidfathi1998:Digi-Permission:1.0.4"
//
//
//
//    implementation "org.java-websocket:Java-WebSocket:1.3.9"
//    implementation ("io.socket:socket.io-client:2.1.0") {
//        exclude(group = "org.json",) module = "json"
//    }
}