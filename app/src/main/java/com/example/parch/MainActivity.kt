package com.example.parch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.example.parch.ui.theme.ParchTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val todoViewModel = ViewModelProvider(this)[ToDoViewModel::class.java]
        enableEdgeToEdge()
        setContent {
            ParchTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ListPage(todoViewModel)
                }
            }
        }
    }
}
