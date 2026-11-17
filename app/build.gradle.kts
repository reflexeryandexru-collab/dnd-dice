plugins {
    id("com.android.application")
}

android {
    namespace = "ru.dnddice"
    compileSdk = 34

    defaultConfig {
        applicationId = "ru.dnddice"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    // Постоянный ключ подписи, чтобы новые версии ставились поверх старых
    signingConfigs {
        create("fixed") {
            storeFile = file("app.keystore")
            storePassword = "dnddice"
            keyAlias = "dnddice"
            keyPassword = "dnddice"
        }
    }

    buildTypes {
        getByName("debug") {
            signingConfig = signingConfigs.getByName("fixed")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}
