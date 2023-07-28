# ToDoApp-Kotlin-Multiplatform

## Description
ToDoApp is a simple cross-platform To-Do List application built using ```Compose Multiplatform```. It demonstrates the ```MVVM architecture``` with custom navigation and utilizes `SQLDelight` for local database storage.  The project showcases how to build a cross-platform application for `Android` and `Desktop` Platforms using a shared codebase written in Kotlin

## Features
- **Create Tasks:** Add new tasks to your to-do list with custom descriptions and due dates.
- **Update Tasks:** Update existing tasks from the list.
- **Delete Tasks:** Remove completed or unwanted tasks from the list.
- **Persistent Storage:** All your tasks are stored locally using SQLDelight.
- **Cross-Platform Compatibility:** The codebase is designed to be shared between Android and Desktop platforms.


## Installation

- Clone the repository to your local machine using the following command:
    <pre><code>https://github.com/developerchunk/ToDoApp-Kotlin-Multiplatform.git</code></pre>
- Open the project in Android Studio or IntelliJ IDEA, and make sure you have all necessary tools and [Compose Multiplatform IDE support plugin](https://plugins.jetbrains.com/plugin/16541-compose-multiplatform-ide-support) installed
- For the set-up of Compose Multiplatform, you can refer to one of my videos about it: https://youtu.be/ZQGBkbmtUKA

## Project Structure
```
  -ToDoApp-Kotlin-Multiplatform[MyMultiplatformApp]
    -android
    -common
      -android
        -database ...Android DatabaseDriverFactory
        -di ...Android AppModule
      -common
        -kotlin
          -database ...shared DatabaseDriverFactory
          -di ...dependency injection(shared AppModule)
          -navigation ... navigation files ex: NavRoute, NavGraphs.
            -navcontroller ... custom navigation
          -presentation ... presentation layer
          -screen ...mainscreen
          -task ...data source and entity
            -data
            -domain
        -sqldelight ...database files and queries
      -desktop
        -database ...Desktop DatabaseDriverFactory
        -di ...Desktop AppModule
      -build.gradle.kts ...main(common) Gradle build file in the project
    -desktop
```

## Libraries Used
- [**SQLDelight 1.5.5**](https://cashapp.github.io/sqldelight/1.5.4/multiplatform_sqlite): A database library for Kotlin Multiplatform, providing a type-safe API for database interactions.
- [**Moko-MVVM**](https://github.com/icerockdev/moko-mvvm): A Kotlin Multiplatform library that provides architecture components of Model-View-ViewModel for UI applications. Components are lifecycle-aware on Android.

## Contribution
We welcome contributions to improve and enhance this project! Whether you find a bug, have a feature request, or want to add something new, your help is appreciated. To contribute, follow these steps:

- Fork the repository to your GitHub account.
- Create a new branch with a descriptive name.
- Make your changes and improvements.
- Test your changes thoroughly.
- Commit your changes:
  <pre><code>git commit -m "Add: Your brief commit message here"</code></pre>
- Push the changes to your forked repository:
  <pre><code>git push origin feature/your-feature-name</code></pre>
- Open a pull request (PR) from your branch to the main branch of this repository.
- Provide a clear title and detailed description for your PR, explaining the changes you made and why they are valuable.
- Wait for the maintainers to review your PR. Be open to feedback and make any necessary adjustments.
- Once your PR is approved, it will be merged into the main branch, and your contributions will become part of the project.

Thank you for your interest in contributing to this project! Your involvement helps make this project better for everyone. If you have any questions or need assistance with the contribution process, feel free to reach out to us via GitHub issues or contact us at [adityashinde5033@gmail.com].

Happy development!
