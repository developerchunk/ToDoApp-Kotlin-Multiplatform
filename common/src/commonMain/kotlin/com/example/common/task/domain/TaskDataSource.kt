package com.example.common.task.domain

import com.example.common.task.TaskModel
import kotlinx.coroutines.flow.Flow

// the interface from which we will call all the queries using the ViewModel
interface TaskDataSource {

    fun getTasks(): Flow<List<TaskModel>>
    suspend fun insertTask(taskModel: TaskModel)
    suspend fun deleteTask(id: Long)

}