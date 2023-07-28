# ToDoApp-Kotlin-Multiplatform

<h2>Description</h2>
<p>ToDoApp is a simple cross-platform To-Do List application built using Compose Multiplatform. It demonstrates the MVVM architecture with custom navigation and utilizes `SQLDelight` for local database storage.  The project showcases how to build a cross-platform application for `Android` and `Desktop` Platforms using a shared codebase written in Kotlin.</p>

<h2>Features</h2>
<ul>
  <li><b>Create Tasks:</b> Add new tasks to your to-do list with custom descriptions and due dates.</li>
  <li><b>Update Tasks:</b> Update existing task from the list.</li>
  <li><b>Delete Tasks:</b> Remove completed or unwanted tasks from the list.</li>
  <li><b>Persistent Storage:</b> All your tasks are stored locally using SQLDelight.</li>
  <li><b>Cross-Platform Compatibility:</b> The codebase is designed to be shared between Android and Desktop platforms.</li>
</ul>

<h2>Installation</h2>
<ul>
  <li>Clone the repository to your local machine using the following command: <be>
    <pre><code>https://github.com/developerchunk/ToDoApp-Kotlin-Multiplatform.git</code></pre>
  </li>
  <li>Open the project in Android Studio or IntelliJ IDEA, and make sure you have all necessary tools and <a href="https://plugins.jetbrains.com/plugin/16541-compose-multiplatform-ide-support">Compose Multiplatform IDE support plugin</a> installed</li>
  <li>For the set-up of Compose Multiplatform, you can refer to one of my videos about it: https://www.youtube.com/embed/ZQGBkbmtUKA
  </li>
</ul>

<h2>Project Structure</h2>
<pre><code>
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
</code></pre>

<h2>Libraries Used</h2>
<ul>
  <li><b><a href="https://cashapp.github.io/sqldelight/1.5.4/multiplatform_sqlite/">SQLDelight 1.5.5</a>A database library for Kotlin Multiplatform, providing a type-safe API for database interactions.</b></li>
  <li><b><a href="https://github.com/icerockdev/moko-mvvm">Moko-MVVM</a>A database library for Kotlin Multiplatform, providing a type-safe API for database interactions.</b></li>
</ul>

