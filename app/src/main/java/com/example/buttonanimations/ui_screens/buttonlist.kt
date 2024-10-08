package com.example.buttonanimations.ui_screens

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import nl.dionsegijn.konfetti.compose.KonfettiView
import nl.dionsegijn.konfetti.core.Party
import nl.dionsegijn.konfetti.core.Position
import nl.dionsegijn.konfetti.core.emitter.Emitter
import java.util.concurrent.TimeUnit


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

@Composable
fun AnimatedButtonWithCircularReveal(index: Int) {
    var isRevealed by remember { mutableStateOf(false) }

    // Animate the radius of the circle from 0 to a maximum value
    val radius by animateFloatAsState(
        targetValue = if (isRevealed) 10000f else 0f, // Adjust 1000f to your desired max radius
        animationSpec = tween(durationMillis = 600)
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

        // Button with Circular Reveal Effect
        Box(
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp)
                .background(Color.Green)
                .clickable {
                    isRevealed = !isRevealed // Toggle the circular reveal state
                }
                .padding(vertical = 12.dp),
            contentAlignment = Alignment.Center
        ) {
            Canvas(modifier = Modifier.fillMaxWidth()) {
                drawCircle(
                    color = Color.Black,
                    radius = radius,
                    center = center
                )
            }
            Text(
                text = "Button $index",
                color = Color.White // Adjust text color for visibility
            )
        }
    }
}

@Composable
fun AnimatedButtonWithKonfetti(index: Int) {
    var showConfetti by remember { mutableStateOf(false) }

    // Party configuration for Konfetti
    val party = remember {
        Party(
            speed = 0f,
            maxSpeed = 30f,
            damping = 0.9f,
            spread = 360,
            colors = listOf(0xfce18a, 0xff726d, 0xf4306d, 0xb48def),
            emitter = Emitter(duration = 100, TimeUnit.MILLISECONDS).max(100),
            position = Position.Relative(0.5, 0.1)
        )
    }

    // Reset confetti state after a delay to allow re-triggering
    LaunchedEffect(showConfetti) {
        if (showConfetti) {
            delay(500) // Duration of the confetti effect
            showConfetti = false // Reset the confetti state after the effect is done
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        // KonfettiView composable to show confetti across the entire screen
        if (showConfetti) {
            KonfettiView(
                modifier = Modifier.fillMaxSize(),
                parties = listOf(party)
            )
        }

        // Button with Konfetti Effect
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

            // Button to trigger confetti
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp)
                    .background(Color.Red, shape = MaterialTheme.shapes.medium)
                    .clickable {
                        showConfetti = true // Trigger confetti animation on click
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
}

@Composable
fun AnimatedButtonWithBounce(index: Int) {
    var isBouncing by remember { mutableStateOf(false) }

    // Animate scale with spring physics for bounce effect
    val scale by animateFloatAsState(
        targetValue = if (isBouncing) 1.2f else 1f,
        animationSpec = tween(
            durationMillis = 300,
            easing = { OvershootInterpolator(2f).getInterpolation(it) } // Overshoot for bounce
        )
    )

    // Reset bounce state after animation completes
    LaunchedEffect(isBouncing) {
        if (isBouncing) {
            delay(300)
            isBouncing = false
        }
    }

    // Use a Box to align and make the button visible
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

        // Button with Bounce Effect
        Box(
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp)
                .scale(scale) // Apply bounce scale animation
                .background(Color(0xFF4CAF50), shape = MaterialTheme.shapes.medium)
                .clickable {
                    isBouncing = true // Trigger bounce
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