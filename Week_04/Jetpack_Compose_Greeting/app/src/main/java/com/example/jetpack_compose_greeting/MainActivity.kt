package com.example.jetpack_compose_greeting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
// import androidx.compose.foundation.layout.fillMaxSize
// import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpack_compose_greeting.ui.theme.Jetpack_Compose_GreetingTheme

// Step 3. add required imports
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

// fix
import android.widget.Toast
import android.view.Gravity




class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Jetpack_Compose_GreetingTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->


                    // Step 4. Create properties to store first/last/full name.
                    var firstName by remember { mutableStateOf("") }
                    var lastName by remember { mutableStateOf("") }
                    var fullName by remember { mutableStateOf("") }


                    // Step 5. Add the two string resources.
                    var welcomeMessage =
                        stringResource(id = R.string.welcome_to_the_app)
                    var enterNameError =
                        stringResource(id = R.string.please_enter_a_name)


                    // Step 6. Add a Column layout composable to display the content in a column.
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .padding(12.dp),
                        horizontalAlignment =
                            Alignment.CenterHorizontally,
                        verticalArrangement =
                            Arrangement.spacedBy(16.dp)
                    ) {

                        // Step 7. Add two OutlinedTextField composables for first/last name.
                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = firstName,
                            onValueChange = { firstName = it },
                            label = {
                                Text(
                                    text = stringResource(
                                        id = R.string.first_name
                                    )
                                )
                            },
                        )
                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = lastName,
                            onValueChange = { lastName = it },
                            label = {
                                Text(
                                    text = stringResource(
                                        id = R.string.last_name
                                    )
                                )
                            }
                        )

                        // Step 8. Add the interaction to display a welcome message with validation.
                        val context = LocalContext.current
                        Button(
                            modifier = Modifier.fillMaxWidth(),
                            onClick = {
                                if (
                                    firstName.isNotBlank() &&
                                    lastName.isNotBlank())
                                    fullName = "$firstName $lastName"
                            else {
                                fullName = ""
                                    val toast = Toast.makeText(
                                        context,
                                        enterNameError,
                                        Toast.LENGTH_LONG
                                    )
                                    toast.setGravity(Gravity.CENTER, 0,0)
                                    toast.show()
                                }
                            }
                        ) {
                            Text("Enter")
                        }
                        if (fullName.isNotBlank()) {
                            Text(text = "$welcomeMessage $fullName!")
                        }



                    }


                }
            }
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
    Jetpack_Compose_GreetingTheme {
        Greeting("Android")
    }
}