package com.example.remitconnect.presentation.home


import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.remitconnect.R
import com.example.remitconnect.presentation.home.components.*
import com.example.remitconnect.presentation.nav.BottomBar
import com.example.remitconnect.presentation.sendMoneyOptions.components.CustomAppBar
import com.example.remitconnect.presentation.theme.ui.theme.BackgroundColor

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavHostController) {

    Scaffold(
        topBar = {
            CustomAppBar(
                showActions = false,
                showBackArrow = false,
                onClick = { },
                color = BackgroundColor,
            )
        },
        bottomBar = { BottomBar(navController = navController) },
        backgroundColor = BackgroundColor
    ) {
        //HomeScreenContent()
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = BackgroundColor)

        ) {
            HomeScreenContent()
        }
    }
}

@Composable
private fun HomeScreenContent() {
    LazyColumn(
        Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .width(327.dp)
            .padding(24.dp)
    ) {
        item {
            Greeting("John Doe")
            Spacer(modifier = Modifier.size(20.dp))
            BalanceCard()
            Spacer(modifier = Modifier.size(24.dp))
            ActionsContainer()
        }

        item {
            Spacer(modifier = Modifier.size(24.dp))
            Text(
                text = "Transactions",
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.outfit_regular)),
                fontWeight = FontWeight(600),
                color = Color(0xFF00122C)
            )
            Spacer(modifier = Modifier.size(16.dp))
            TransactionsSection()
        }
    }
}



