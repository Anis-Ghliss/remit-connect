package com.example.remitconnect.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.remitconnect.presentation.nav.BottomNavGraph

@Preview
@Composable
fun NavigationView() {
    val navController = rememberNavController()
    BottomNavGraph(navController = navController)
}

