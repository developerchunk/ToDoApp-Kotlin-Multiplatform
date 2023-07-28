package com.example.common.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.onClick
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.common.navigation.NavRoute
import com.example.common.navigation.navcontroller.NavController
import com.example.common.presentation.TaskViewModel
import com.example.common.presentation.TaskState
import com.example.common.task.TaskModel

/*
 *
 * The code is similar to what we do in Android,
 * so I think you can understand it better if you have worked with android and Jetpack Compose
 *
 * You can always contact me if you have any issue or problem
 * related to issues in Android and Kotlin Multiplatform on my email: adityashinde5033@gmail.com
 *
 */
@Composable
fun MainScreen(
    navController: NavController,
    taskViewModel: TaskViewModel
) {

    taskViewModel.getAllTasks()

    val list by taskViewModel.allTasks.collectAsState()

    val mainTaskState by taskViewModel.mainTaskState
    if (mainTaskState!= TaskState.NONE) {
        taskViewModel.conductOperationsOnTask()
        taskViewModel.getAllTasks()
    }

    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Todo Tasks", color = Color.White) },
                backgroundColor = Color.Blue,
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    // navigate to Add Task Screen
                    taskViewModel.taskState.value = TaskState.ADD_TASK
                    navController.navigate(NavRoute.AddTaskScreen.route)
                }
            ) {
                // back arrow
                Icon(
                    imageVector = Icons.Rounded.Add,
                    contentDescription = "Add Task",
                    tint = Color.White
                )
            }
        }
    ) { paddingValues ->

        Column(modifier = Modifier.fillMaxSize().padding(paddingValues).padding(30.dp)) {
            TaskItems(
                tasks = list,
                onCLick = { task ->
                    taskViewModel.taskId.value = task.id?:0
                    taskViewModel.task.value = task
                    taskViewModel.taskState.value = TaskState.UPDATE_TASK
                    navController.navigate(NavRoute.AddTaskScreen.route)
                }
            )
        }

    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TaskItems(
    tasks: List<TaskModel>,
    onCLick: (id: TaskModel) -> Unit
) {

    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2)
    ) {

        items(tasks) {

            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .background(
                        color = Color.White,
                    )
                    .border(width = 1.5.dp, color = Color.Gray, shape = RoundedCornerShape(size = 20.dp))
                    .padding(20.dp)
                    .onClick {
                        it.id?.let { id -> onCLick(it) }
                    }

            ) {

                Text(
                    it.title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text(it.message, modifier = Modifier.padding(top = 10.dp), fontSize = 14.sp)

            }

        }

    }

}