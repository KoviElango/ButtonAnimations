package com.example.buttonanimations.ui_screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    // Corrected NavHost setup
    NavHost(navController = navController, startDestination = "page_1") {
        composable("page_1") { ButtonAnimationScreen_1(navController) }
        composable("page_2") { ButtonAnimationScreen_2(navController) }
    }
}

@Composable
fun ButtonAnimationScreen_1(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, top = 40.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp) // Space between buttons
    ) {
        // First button with ripple effect and delay
        AnimatedButtonWithRipple(index = 1)

        // Second button with scaling effect
        AnimatedButtonWithScale(index = 2)

        // Third button with rotation effect
        AnimatedButtonWithRotation(index = 3)

        // Button to navigate to the second screen
        Button(onClick = {
            navController.navigate("page_2")
        }) {
            Text(text = "Go to page_2")
        }
    }
}

@Composable
fun ButtonAnimationScreen_2(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, top = 40.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp) // Space between buttons
    ) {
        // Fourth button with gradient background
        AnimatedButtonWithGradient(index = 4)

        // Fifth button with circular reveal effect
        AnimatedButtonWithCircularReveal(index = 5)

        // Sixth button with particle burst effect
        AnimatedButtonWithKonfetti(index = 6)

        // Seventh button with bounce effect
        AnimatedButtonWithBounce(index = 7)

        // Button to navigate back to the first screen
        Button(onClick = {
            navController.navigate("page_1")
        }) {
            Text(text = "Go to page_1")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewButtonAnimationScreen() {
    AppNavigation()
}
