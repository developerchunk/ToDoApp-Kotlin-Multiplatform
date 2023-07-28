package com.example.common.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.common.navigation.navcontroller.NavController
import com.example.common.presentation.TaskViewModel
import com.example.common.presentation.TaskState
import com.example.common.task.TaskModel

@Composable
fun AddTaskScreen(navController: NavController, taskViewModel: TaskViewModel) {

    var title by remember {
        mutableStateOf("")
    }

    var message by remember {
        mutableStateOf("")
    }

    val taskModel by taskViewModel.task
    val id by taskViewModel.taskId
    val taskState by taskViewModel.taskState
    var updateTask by remember {
        mutableStateOf(false)
    }

    val scrollState = rememberScrollState()

    updateTask = taskState == TaskState.UPDATE_TASK

    LaunchedEffect(taskState) {
        if (updateTask) {
            title = taskModel.title
            message = taskModel.message
        }
    }

    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Add Task", color = Color.White) },
                backgroundColor = Color.Blue,
                navigationIcon = {
                    // back button
                    IconButton(
                        onClick = {
                            // navigate to previous screen
                            navController.navigateBack()
                        }
                    ) {
                        // back arrow
                        Icon(
                            imageVector = Icons.Rounded.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },
                actions = {
                    if (updateTask) {
                        // delete button
                        IconButton(
                            onClick = {
                                taskViewModel.mainTaskState.value = TaskState.DELETE_TASK
                                taskViewModel.taskId.value = taskModel.id ?: 0
                                navController.navigateBack()
                            }
                        ) {
                            // delete icon
                            Icon(
                                imageVector = Icons.Rounded.Delete,
                                contentDescription = "Delete",
                                tint = Color.White
                            )
                        }
                    }
                }
            )
        }
    ) {


        // main layout composable
        Column(
            modifier = Modifier.padding(it).fillMaxSize().padding(30.dp).verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(id.toString())

            // text fields
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                // title text box
                OutlinedTextField(
                    label = { Text("Title") },
                    modifier = Modifier.fillMaxWidth(),
                    value = title,
                    onValueChange = { value ->
                        title = value
                    },
                )

                // message text box
                OutlinedTextField(
                    label = { Text("Message") },
                    modifier = Modifier.fillMaxWidth().heightIn(min = 140.dp),
                    value = message,
                    onValueChange = { value ->
                        message = value
                    },
                )
            }

            Button(
                modifier = Modifier.padding(top = 50.dp).width(200.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
                onClick = {
                    taskViewModel.mainTaskState.value = if (updateTask) TaskState.UPDATE_TASK else TaskState.ADD_TASK
                    taskViewModel.task.value = TaskModel(
                        id = if (updateTask) taskModel.id else null,
                        title = title,
                        message = message
                    )
                    navController.navigateBack()
                    taskViewModel.getAllTasks()
                }) {
                Text("Save Task", color = Color.White)
            }

        }

    }

}