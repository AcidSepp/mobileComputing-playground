plugins {
  alias(libs.plugins.kotlin)
  application
}

application {
  mainClass = "HelloWorldKt"
}

// Apply a specific Java toolchain to ease working on different environments.
java {
  toolchain {
    languageVersion = JavaLanguageVersion.of(25)
  }
}
