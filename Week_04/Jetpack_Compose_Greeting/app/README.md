Title: Exercise 1.05 - Building a Jetpack Compose UI to display a bespoke greeting to the user  
Author: Alex Forrester  
Date: 12/12/2025  
Description: Learning Jetpack Compose.  

---

1. Create a new Android Studio project.  

2. Create the labels and text you are going to use in your app by adding entries to `app | src | main | res | values | strings.xml` 

3. Next, add the required imports to the `MainActivity.kt` 

4. Create three properties to store the first/last/full name at the top of the Scaffold composable. 

5. Add the string resources. In Compose, in order to access a string resource, you use the `stringResource` composable, passing in the ID of the string you want to retrieve from the `strings.xml` file.

6. Next, add a layout composable to arrange how we add the content. Add a Column layout composable to display the content in a column.

7. Add two `OutlinedTextField` composables for the first/last name in the `Column` layout.

8. Now, add the interaction to display a welcome message with validation of the text input. Add a button with behavior to display the user's full name and welcome them to the app, show an error if either of the field composables are empty.


