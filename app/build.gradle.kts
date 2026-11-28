import com.android.build.api.dsl.ApplicationExtension

plugins {
  alias(libs.plugins.android.application)
  alias(libs.plugins.kotlin.compose)
  alias(libs.plugins.ksp)
  alias(libs.plugins.hilt)
  alias(libs.plugins.kotlin.android)
}

configure<ApplicationExtension> {
  namespace = "com.example.mobilecomputingplayground"
  compileSdk {
    version = release(37)
  }

  defaultConfig {
    applicationId = "com.example.mobilecomputingplayground"
    minSdk = 24
    targetSdk = 37
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  buildTypes {
    release {
      optimization {
        enable = false
      }
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_25
    targetCompatibility = JavaVersion.VERSION_25
  }
  buildFeatures {
    compose = true
  }
}

dependencies {
  androidTestImplementation(libs.androidx.compose.ui.test.junit4)
  androidTestImplementation(libs.androidx.espresso.core)
  androidTestImplementation(libs.androidx.junit)

  debugImplementation(libs.androidx.compose.ui.test.manifest)
  debugImplementation(libs.androidx.compose.ui.tooling)

  implementation(libs.androidx.activity.compose)
  implementation(libs.androidx.compose.material3)
  implementation(libs.androidx.compose.ui)
  implementation(libs.androidx.compose.ui.graphics)
  implementation(libs.androidx.compose.ui.tooling.preview)
  implementation(libs.androidx.core.ktx)
  implementation(libs.androidx.datastore)
  implementation(libs.androidx.datastore.core.android)
  implementation(libs.androidx.datastore.preferences)
  implementation(libs.androidx.lifecycle.runtime.compose)
  implementation(libs.androidx.lifecycle.runtime.ktx)
  implementation(libs.androidx.room3.runtime)
  implementation(libs.coil.compose)
  implementation(libs.coil.network.okhttp)
  implementation(libs.compose.material.icons)
  implementation(libs.gson)
  implementation(libs.hilt)
  implementation(platform(libs.androidx.compose.bom))

  ksp(libs.androidx.room3.compiler)
  ksp(libs.hilt.compiler)

  testImplementation(libs.junit)
}
