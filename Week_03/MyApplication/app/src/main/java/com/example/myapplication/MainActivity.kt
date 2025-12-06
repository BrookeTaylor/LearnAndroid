/*

Title: How to Build Android Applications with Kotlin
Authors: Alex Forrester | Eran Boudjnah | Alexandru Dumbravani | Jomar Tigcal
Date: 12/05/2025
Description: Following along w/ book to help learn Android/Kotlin.

 */

package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

// Chapter 1, pg 21; adding imports
import android.webkit.WebView
import androidx.compose.ui.viewinterop.AndroidView


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val webView = WebView(this)
            webView.settings.javaScriptEnabled = true
            webView.loadUrl("https://www.google.com")

            AndroidView(
                modifier = Modifier.fillMaxSize(),
                factory = { context ->
                    webView
                }
            )

        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}