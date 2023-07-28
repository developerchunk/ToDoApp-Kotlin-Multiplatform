package com.example.android

import com.example.common.App
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.platform.LocalContext
import com.example.common.di.AppModule

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                 App(
                     appModule = AppModule(LocalContext.current.applicationContext)
                 )
            }
        }
    }
}