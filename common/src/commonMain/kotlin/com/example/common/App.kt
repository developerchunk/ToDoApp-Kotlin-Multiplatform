package com.example.common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.example.common.navigation.NavGraph
import com.example.common.navigation.NavRoute
import com.example.common.navigation.navcontroller.rememberNavController
import com.example.common.di.AppModule
import com.example.common.presentation.TaskViewModel
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory

@Composable
fun App(
    appModule: AppModule
) {

    /*
    * Tip: to understand the project and the code better please go in depth of each function and class
    * which is created or used in the project.
    *
    * To find the location of the function or class which is created or is in use created just use
    * for mac/linux: cmd+B in windows: control+B.
    *
    * For a better understanding of concepts please watch the video related to Database and MVVM in KMM on YouTube by Philipp Lackner: https://www.youtube.com/watch?v=XWSzbMnpAgI&t=5289s
    *
    * The project uses :
    * SqlDelight version 1.5.5
    * MVVM architecture using https://github.com/icerockdev
    *
    * The Home Screen and the actual implementation are in screen/MainScreen.kt
    *
    * */

    /* it might show error on 'viewModelFactory' about 'Cannot inline bytecode built with JVM target 11 into bytecode...'
    * but ignore it and run the App it will run without error
    * */
    val viewModel = getViewModel(
        key = "app-screen",
        factory = viewModelFactory {
            TaskViewModel(appModule.taskDataSource)
        }
    )

    viewModel.getAllTasks()

    val navHostController by rememberNavController(NavRoute.MainScreen.route)

    /* I have coded a Custom Navigation for the Project which is similar to Navigation in Jetpack Compose it runs on Desktop and Android
    *GitHub Repo for the Navigation: https://github.com/itheamc/navigation-for-compose-for-desktop/
    *
    * If you are it in Android then make sure to add this in your Manifest activity:
    * <activity android:name=".MainActivity"
    * android:exported="true" android:configChanges="orientation|screenSize"> ... your code... </activity>
    *
    * */
    NavGraph(navHostController, taskViewModel = viewModel)
}
