package com.example.common.di

import com.example.common.task.domain.TaskDataSource

expect class AppModule {
    val taskDataSource: TaskDataSource
}