plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.javeria.newsinshort"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.javeria.newsinshort"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}
kapt {
    correctErrorTypes = true
}
dependencies {

    implementation(Dependencies.coreKtx)
    implementation(Dependencies.lifecycle)
    implementation(Dependencies.activityCompose)
    implementation(platform(Dependencies.compose))
    implementation(Dependencies.compose)
    implementation(Dependencies.composeGraphics)
    implementation(Dependencies.composeUiToolingPreview)
    implementation(Dependencies.material)
    implementation(Dependencies.navigationCompose)
    implementation(Dependencies.composeUi)
    implementation(Dependencies.multidex)

    testImplementation(Dependencies.junit)
    androidTestImplementation(Dependencies.junitExt)
    androidTestImplementation(Dependencies.espresso)
    androidTestImplementation(platform(Dependencies.compose))
    androidTestImplementation(Dependencies.composeUiTest)
    debugImplementation(Dependencies.composeUiTooling)
    debugImplementation(Dependencies.composeTestManifest)

    implementation(project(Modules.utilities))
    //hilt
    implementation(Dependencies.hiltAndroid)
    kapt(Dependencies.hiltAndroidCompiler)
    implementation(Dependencies.hiltNavigationCompose)
// network call dependencies
    implementation (Dependencies.retrofit)
    implementation (Dependencies.moshi)
    implementation (Dependencies.moshiConverter)
    implementation(platform(Dependencies.okhttpBom))
    // define any required OkHttp artifacts without version
    implementation(Dependencies.okhttp)
    implementation(Dependencies.okhttpLoggingInterceptor)
    //coroutines
    implementation(Dependencies.coroutines)
    implementation(Dependencies.coroutinesAndroid)
    //Splash Screen
    implementation(Dependencies.splashScreen)
    //Coil
    implementation(Dependencies.coil)
}