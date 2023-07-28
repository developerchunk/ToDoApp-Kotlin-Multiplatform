package com.example.common.di

import android.content.Context
import com.example.common.database.DatabaseDriverFactory
import com.example.common.task.data.SqlDelightTaskDataSource
import com.example.common.task.domain.TaskDataSource
import com.example.mymultiplatformapp.database.todoDatabase

actual class AppModule(
    private val context: Context
) {
    actual val taskDataSource: TaskDataSource by lazy {
        SqlDelightTaskDataSource(
            db = todoDatabase(
                driver = DatabaseDriverFactory(context).create()
            )
        )
    }
}