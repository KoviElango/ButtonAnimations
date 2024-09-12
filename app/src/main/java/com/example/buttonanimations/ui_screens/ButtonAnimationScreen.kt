package com.example.buttonanimations.ui_screens

import androidx.compose.foundation.layout.*
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
import androidx.compose.foundation.lazy.LazyColumn

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "page_1") {
        composable("page_1") { ButtonAnimationScreen_1(navController) }
        composable("page_2") { ButtonAnimationScreen_2(navController) }
        composable("page_3") { ButtonAnimationScreen_3(navController) }
    }
}

@Composable
fun ButtonAnimationScreen_1(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, top = 40.dp)
    )
    {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, top = 40.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Replace `items` usage with `item` for each composable button
        item {
            AnimatedButtonWithRipple(index = 1)
        }
        item {
            AnimatedButtonWithScale(index = 2)
        }
        item {
            AnimatedButtonWithRotation(index = 3)
        }
    }
    Button(onClick = { navController.navigate("page_2") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)) {
        Text(text = "Go to page_2")
    }
    }
}


@Composable
fun ButtonAnimationScreen_2(navController: NavHostController) {
    Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp, top = 40.dp)
            ) {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp, top = 40.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                AnimatedButtonWithGradient(index = 4)
            }
            item {
                AnimatedButtonWithCircularReveal(index = 5)
            }
            item {
                AnimatedButtonWithKonfetti(index = 6)
            }
            item {

            }
        }
        Row(){
            Button(onClick = { navController.navigate("page_3") }) {
                Text(text = "Go to page_3")
            }
            Button(onClick = { navController.navigate("page_3") }) {
                Text(text = "Go to page_3")
            }
        }
    }
}


@Composable
fun ButtonAnimationScreen_3(navController: NavHostController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, top = 40.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            AnimatedButtonWithBounce(index = 7)
        }
        item {
            Button(onClick = { navController.navigate("page_2") }) {
                Text(text = "Go to page_2")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewButtonAnimationScreen() {
    AppNavigation()
}
