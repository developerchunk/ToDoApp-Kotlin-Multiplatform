package com.example.common.navigation

import androidx.compose.runtime.Composable
import com.example.common.di.AppModule
import com.example.common.navigation.navcontroller.NavController
import com.example.common.navigation.navcontroller.NavigationHost
import com.example.common.navigation.navcontroller.composable
import com.example.common.presentation.TaskViewModel
import com.example.common.screen.AddTaskScreen
import com.example.common.screen.MainScreen

@Composable
fun NavGraph(
    navController: NavController,
    taskViewModel: TaskViewModel
) {
    NavigationHost(navController) {

        // Navigation

        composable(NavRoute.MainScreen.route) {
            MainScreen(navController, taskViewModel)
        }

        composable(NavRoute.AddTaskScreen.route) {
            AddTaskScreen(navController, taskViewModel)
        }

    }.build()
}