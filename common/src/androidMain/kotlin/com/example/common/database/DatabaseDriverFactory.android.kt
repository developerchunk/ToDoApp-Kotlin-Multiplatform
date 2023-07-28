package com.example.common.database

import android.content.Context
import com.example.mymultiplatformapp.database.todoDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DatabaseDriverFactory(
    private val context: Context
) {
    actual fun create(): SqlDriver {
        return AndroidSqliteDriver(todoDatabase.Schema, context, "task.db")
    }

}