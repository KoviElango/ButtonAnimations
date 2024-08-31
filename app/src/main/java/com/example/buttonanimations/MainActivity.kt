package com.example.buttonanimations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buttonanimations.ui.theme.ButtonAnimationsTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ButtonAnimationScreen()
            }
        }
    }


@Composable
fun ButtonAnimationScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
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
    }
}

@Composable
fun AnimatedButtonWithRipple(index: Int) {
    var isClicked by remember { mutableStateOf(false) }

    if (isClicked) {
        LaunchedEffect(Unit) {
            delay(500) // Delay for 500 milliseconds
            isClicked = false // Reset after delay
        }
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Dot indicator
        Box(
            modifier = Modifier
                .size(8.dp)
                .background(if (isClicked) Color.Green else Color.Gray, shape = CircleShape)
        )

        // Button with Custom Ripple Effect
        Box(
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp)
                .background(Color.Blue, shape = MaterialTheme.shapes.medium)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = rememberRipple(color = Color.Red)
                ) {
                    isClicked = true
                }
                .padding(vertical = 12.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Button $index",
                color = Color.White
            )
        }
    }
}

@Composable
fun AnimatedButtonWithScale(index: Int) {
    var scale by remember { mutableStateOf(01f) } // Initial scale is 1 (no scaling)

    // Animate scale change when the button is clicked
    val animatedScale by animateFloatAsState(
        targetValue = scale,
        animationSpec = tween(durationMillis = 300)
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Dot indicator
        Box(
            modifier = Modifier
                .size(8.dp)
                .background(Color.Gray, shape = CircleShape)
        )

        // Button with Scaling Effect
        Box(
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp)
                .scale(animatedScale) // Apply scale animation
                .background(Color.Magenta, shape = MaterialTheme.shapes.medium)
                .clickable {
                    scale = if (scale == 1f) 1.2f else 1f // Toggle between normal and scaled size
                }
                .padding(vertical = 12.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Button $index",
                color = Color.White
            )
        }
    }
}

@Composable
fun AnimatedButtonWithRotation(index: Int) {
    var isRotated by remember { mutableStateOf(false) }

    // Animate rotation angle from 0 to 360 degrees
    val rotationAngle by animateFloatAsState(
        targetValue = if (isRotated) 360f else 0f,
        animationSpec = tween(durationMillis = 500) // Rotation duration
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Dot indicator
        Box(
            modifier = Modifier
                .size(8.dp)
                .background(Color.Gray, shape = CircleShape)
        )

        // Button with Rotation Effect
        Box(
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp)
                .graphicsLayer(rotationZ = rotationAngle) // Apply rotation effect
                .background(Color.Cyan, shape = MaterialTheme.shapes.medium)
                .clickable {
                    isRotated = !isRotated // Toggle rotation state
                }
                .padding(vertical = 12.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Button $index",
                color = Color.White
            )
        }
    }
}

@Composable
fun AnimatedButtonWithGradient(index: Int) {
    var isClicked by remember { mutableStateOf(false) }

    // Animate color transition between two gradients
    val gradientColors by animateColorAsState(
        targetValue = if (isClicked) Color(0xFF42A5F5) else Color(0xFFFF7043),
        animationSpec = tween(durationMillis = 600) // Duration of the gradient transition
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Dot indicator
        Box(
            modifier = Modifier
                .size(8.dp)
                .background(Color.Gray, shape = CircleShape)
        )

        // Button with Gradient Background Effect
        Box(
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(gradientColors, Color.Yellow)
                    ),
                    shape = MaterialTheme.shapes.medium
                )
                .clickable {
                    isClicked = !isClicked // Toggle the gradient state on click
                }
                .padding(vertical = 12.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Button $index",
                color = Color.Black
            )
        }
    }
}
