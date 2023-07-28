package com.example.common.di

import com.example.common.database.DatabaseDriverFactory
import com.example.common.task.data.SqlDelightTaskDataSource
import com.example.common.task.domain.TaskDataSource
import com.example.mymultiplatformapp.database.todoDatabase

actual class AppModule {
    actual val taskDataSource: TaskDataSource by lazy {
        SqlDelightTaskDataSource(
            db = todoDatabase(
                driver = DatabaseDriverFactory().create()
            )
        )
    }
}