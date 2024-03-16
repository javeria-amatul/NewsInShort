object Dependencies {

    val compose by lazy { "androidx.compose:compose-bom:${Versions.compose}" }

    val coreKtx by lazy { "androidx.core:core-ktx:${Versions.coreKtx}" }
    val lifecycle by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.ktxRuntime}" }
    val activityCompose by lazy { "androidx.activity:activity-compose:${Versions.composeActivity}" }
    val composeUi by lazy { "androidx.compose.ui:ui" }
    val composeGraphics by lazy { "androidx.compose.ui:ui-graphics" }
    val composeUiToolingPreview by lazy { "androidx.compose.ui:ui-tooling-preview" }
    val material by lazy { "androidx.compose.material3:material3" }
    val navigationCompose by lazy { "androidx.navigation:navigation-compose:${Versions.navVersion}" }
    val junit by lazy { "junit:junit:${Versions.junit}" }
    val junitExt by lazy { "androidx.test.ext:junit:${Versions.junitExt}" }
    val espresso by lazy { "androidx.test.espresso:espresso-core:${Versions.espresso}" }
    val composeUiTest by lazy { "androidx.compose.ui:ui-test-junit4" }
    val composeUiTooling by lazy { "androidx.compose.ui:ui-tooling" }
    val composeTestManifest by lazy { "androidx.compose.ui:ui-test-manifest" }
    val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompat}" }
    val googleMaterial by lazy { "com.google.android.material:material:${Versions.material}" }
    val hiltAndroid by lazy { "com.google.dagger:hilt-android:${Versions.hilt}" }
    val hiltAndroidCompiler by lazy { "com.google.dagger:hilt-compiler:${Versions.hilt}" }
    val hiltCompiler by lazy { "androidx.hilt:hilt-compiler:${Versions.hiltCompiler}" }
    val hiltNavigationCompose by lazy {"androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigationCompose}"}
    val multidex by lazy {"androidx.multidex:multidex:${Versions.multidex}"}

    //network dependency
    val retrofit by lazy {"com.squareup.retrofit2:retrofit:${Versions.retrofit}"}
    val gsonConverter by lazy {"com.squareup.retrofit2:converter-gson:${Versions.gsonConverter}"}
    val moshi by lazy {"com.squareup.moshi:moshi-kotlin:${Versions.moshi}"}
    val moshiConverter by lazy {"com.squareup.retrofit2:converter-moshi:${Versions.moshiConverter}"}
    val okhttpBom by lazy {"com.squareup.okhttp3:okhttp-bom:${Versions.okhttp}"}
    val okhttp by lazy {"com.squareup.okhttp3:okhttp"}
    val okhttpLoggingInterceptor by lazy {"com.squareup.okhttp3:logging-interceptor"}
    val coroutinesAndroid by lazy {"org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"}
    val coroutines by lazy {"org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"}
    val splashScreen by lazy { "androidx.core:core-splashscreen:${Versions.splashScreen}" }
    val coil by lazy { "io.coil-kt:coil-compose:${Versions.coil}" }
}


object Modules{
    const val utilities = ":utilities"
}
