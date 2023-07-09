package com.example.remitconnect.presentation.sendMoneyOptions

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.remitconnect.R
import com.example.remitconnect.presentation.common.ScreenHeader
import com.example.remitconnect.presentation.nav.BottomBarScreen
import com.example.remitconnect.presentation.sendMoneyOptions.components.CustomAppBar
import com.example.remitconnect.presentation.sendMoneyOptions.components.ListItem
import com.example.remitconnect.presentation.theme.ui.theme.SecondaryGreen

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SendToAfticaScreen(navController: NavHostController) {
    Scaffold(
        backgroundColor = Color.White,

        topBar = {
            CustomAppBar(
                showActions = true,
                showBackArrow = true,
                onClick = { navController.popBackStack() },
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .fillMaxHeight()

            ) {
                ScreenHeader(
                    text = "Send to Africa",
                    modifier = Modifier
                        .width(327.dp)
                        .padding(horizontal = 24.dp),
                )
                Column(
                    modifier = Modifier.padding(top = 24.dp)
                ) {
                    ListItem(
                        text = "Mobile wallets",
                        onClick = { navController.navigate(BottomBarScreen.Recipients.route) }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_arrow_square_right),
                            contentDescription = "",
                            tint = SecondaryGreen
                        )

                    }
                    ListItem(
                        text = "Bank Transfer",
                        onClick = { navController.navigate(BottomBarScreen.Recipients.route) }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_arrow_square_right),
                            contentDescription = "",
                            tint = SecondaryGreen
                        )
                    }

                }

            }
        }
    }
}