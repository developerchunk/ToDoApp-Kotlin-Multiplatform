package com.example.common.task.data

import com.example.common.task.TaskModel
import database.Task

fun Task.toTaskModel(): TaskModel {
    return TaskModel(
        id, title, message
    )
}