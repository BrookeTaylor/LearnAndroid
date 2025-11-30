package com.example.clickcounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClickCounterApp()
        }
    }
}

@Composable
fun ClickCounterApp() {
    var count by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Count: $count", fontSize = 32.sp)

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = { count++ }) {
            Text("Add")
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(onClick = { count = 0 }) {
            Text("Reset")
        }
    }
}
