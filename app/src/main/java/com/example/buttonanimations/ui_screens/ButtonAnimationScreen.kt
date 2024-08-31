package com.example.buttonanimations.ui_screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun ButtonAnimationScreen() {
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

        // Fourth button with gradient background
        AnimatedButtonWithGradient(index = 4)

        // Fifth button with circular reveal effect
        AnimatedButtonWithCircularReveal(index = 5)

        // Sixth button with particle burst effect
        AnimatedButtonWithKonfetti(index = 6)

        // Seventh button with bounce effect
        AnimatedButtonWithBounce(index = 7)
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewButtonAnimationScreen() {
    ButtonAnimationScreen()
}