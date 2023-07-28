package com.example.common.navigation

sealed class NavRoute(
    val route: String
) {

    object MainScreen: NavRoute(route = "main_screen")
    object AddTaskScreen: NavRoute(route = "add_task_screen")

}
