package com.example.rgbapp

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
import com.example.rgbapp.ui.theme.RGBAppTheme

import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.material3.Button

import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
import androidx.core.graphics.toColorInt





class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RGBAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->


                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(horizontal = 16.dp)
                    ) {

                        // step 2. add a title Text composable
                        Text(
                            // step 3. Add a brief desc telling user how to complete form.
                            text = "Add two hexadecimal characters between 0-9, A-F or a-f without the '#' for each channel"
                        )


                        /*
                        step 4.

                        Add 3 MutableState properties for each of the tree colors and
                        another for a default color.
                         */
                        var RedChannel by remember { mutableStateOf("") }
                        var GreenChannel by remember { mutableStateOf("") }
                        var BlueChannel by remember { mutableStateOf("") }
                        var colorToDisplay by remember { mutableStateOf(Color.White) }



                        /*
                        step 5.

                        Add 3 material OutlinedTextField composables with lables of
                        RedChannel, GreenChannel, BlueChannel, initialized with
                        an empty string.
                         */
                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = RedChannel,
                            onValueChange = { RedChannel = it },
                            label = { Text("Red Channel") }
                        )
                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = GreenChannel,
                            onValueChange = { GreenChannel = it },
                            label = { Text("Green Channel") }
                        )
                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = BlueChannel,
                            onValueChange = { BlueChannel = it },
                            label = { Text("Blue Channel") }
                        )

                        // step 7. Add a button that takes the inputs from the color fields.
                        Button(
                            modifier = Modifier.fillMaxWidth(),
                            onClick = {
                                if (isValidHexInput(
                                        RedChannel
                                    ) && isValidHexInput(
                                        GreenChannel
                                    ) && isValidHexInput(
                                        BlueChannel
                                    )
                                ) {
                                    val colorString =
                                        "#$RedChannel$GreenChannel$BlueChannel"
                                    colorToDisplay =
                                        Color(colorString.toColorInt())
                                }
                            }) {
                            Text("CREATE COLOR")
                        }
                        Text(
                            modifier = Modifier.background(colorToDisplay).padding(24.dp),
                            text = "Created color display panel"
                        )





                    }




                }

            }
        }
    }
}

/*
step 6.

Add a restriction function to each field to allow entry of only two hexadecimal characters.
 */
fun isValidHexInput(input: String): Boolean {
    return input.filter {
        it in '0'..'9' ||
        it in 'A'..'F' ||
        it in 'a'..'f'
    }.length == 2
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
    RGBAppTheme {
        Greeting("Android")
    }
}