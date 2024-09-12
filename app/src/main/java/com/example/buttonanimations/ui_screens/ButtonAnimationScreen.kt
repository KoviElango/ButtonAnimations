package com.example.buttonanimations.ui_screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Scaffold
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = "page_1",
            modifier = Modifier.padding(it)
        ) {
            composable("page_1") { ButtonAnimationScreen_1(navController) }
            composable("page_2") { ButtonAnimationScreen_2(navController) }
            composable("page_3") { ButtonAnimationScreen_3(navController) }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    BottomAppBar(
        modifier = Modifier.fillMaxWidth(),
        content = {
            IconButton(onClick = { navController.navigate("page_1") }) {
                Icon(Icons.Filled.Home, contentDescription = "Page 1")
            }
            IconButton(onClick = { navController.navigate("page_2") }) {
                Icon(Icons.Filled.Home, contentDescription = "Page 2")
            }
            IconButton(onClick = { navController.navigate("page_3") }) {
                Icon(Icons.Filled.Home, contentDescription = "Page 3")
            }
        }
    )
}

@Composable
fun ButtonAnimationScreen_1(navController: NavHostController) {
    Scaffold(
        content = {innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                AnimatedButtonWithRipple(index = 1)
                AnimatedButtonWithScale(index = 2)
                AnimatedButtonWithRotation(index = 3)
            }
        }
    )
}

@Composable
fun ButtonAnimationScreen_2(navController: NavHostController) {
    Scaffold(
        content = {innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                AnimatedButtonWithGradient(index = 4)
                AnimatedButtonWithKonfetti(index = 6)
            }
        }
    )
}

@Composable
fun ButtonAnimationScreen_3(navController: NavHostController) {
    Scaffold(
        content = {innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                AnimatedButtonWithBounce(index = 7)
                AnimatedButtonWithCircularReveal(index = 5)
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewButtonAnimationScreen() {
    AppNavigation()
}
