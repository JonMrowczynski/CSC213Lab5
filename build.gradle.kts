plugins {
    id("java") // Let Gradle know that this is a Java project since we could have projects in other languages.
}

// Tell Gradle where to pull code from. Here we are pulling all of our dependencies from maven central. We can visit
// this repository ourselves if we wanted to by visiting: https://mvnrepository.com/repos/central. This is where I
// was able to get the code that I placed in the "dependencies" declaration found below.
repositories {
    mavenCentral()
}

// Declare all the dependencies that you will use in the project and how you will be using them. Here we only have
// external dependencies or 3rd party dependencies.

// Since we are only using dependencies for testing, we are declaring that we are only using our testing framework
// dependencies for...well...testing.

// An implementation dependency is a dependency that is used during compilation and during runtime.
// A runtime only dependency is a dependency that is used only during...well...runtime.
// For more information on these dependency configurations: https://docs.gradle.org/current/userguide/dependency_configurations.html
dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:6.0.2")
    testImplementation("org.junit.jupiter:junit-jupiter:6.0.2")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher:6.0.2")
}

tasks.test {
    useJUnitPlatform() // Tell Gradle that we are using the JUnit testing platform for our tests.
}