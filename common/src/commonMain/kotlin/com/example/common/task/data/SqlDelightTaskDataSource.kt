package com.example.common.task.data

import com.example.common.task.TaskModel
import com.example.common.task.domain.TaskDataSource
import com.example.mymultiplatformapp.database.todoDatabase
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import com.squareup.sqldelight.runtime.coroutines.mapToOne
import com.squareup.sqldelight.runtime.coroutines.mapToOneOrDefault
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SqlDelightTaskDataSource(
    db: todoDatabase
) : TaskDataSource {

    private val queries = db.taskQueries

    override fun getTasks(): Flow<List<TaskModel>> {
        return queries.getTasks()
            .asFlow()
            .mapToList()
            .map { taskEntities ->
                taskEntities.map {
                    it.toTaskModel()
                }
            }
    }

    override suspend fun insertTask(taskModel: TaskModel) {
        queries.insertTask(
            id = taskModel.id,
            title = taskModel.title,
            message = taskModel.message
        )
    }

    override suspend fun deleteTask(id: Long) {
        queries.deleteTask(id = id)
    }
}