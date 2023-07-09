package com.example.remitconnect.presentation.sendMoneyOptions

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.remitconnect.R
import com.example.remitconnect.presentation.common.ScreenHeader
import com.example.remitconnect.presentation.nav.BottomBarScreen
import com.example.remitconnect.presentation.sendMoneyOptions.components.*
import com.example.remitconnect.presentation.theme.ui.theme.SecondaryGreen

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SendMoneyScreen(navController: NavHostController) {

    Scaffold(
        backgroundColor = Color.White,
                topBar = {
            CustomAppBar(
                showActions = true,
                showBackArrow = false,
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
                    modifier = Modifier
                        .width(327.dp)
                        .padding(horizontal = 24.dp),
                    text = "Send money",
                )

                Column(
                    modifier = Modifier.padding(top = 24.dp)
                ) {
                    ListItem(text = "To Moneco balance", onClick = {
                        navController.navigate(
                            BottomBarScreen.SentToAfrica.route
                        )
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_user_square),
                            contentDescription = "",
                            tint = SecondaryGreen
                        )
                    }
                    ListItem(
                        text = "Bank transfer",
                        onClick = { navController.navigate(BottomBarScreen.SentToAfrica.route) }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_store),
                            contentDescription = "",
                            tint = SecondaryGreen
                        )
                    }
                    ListItem(
                        text = "Send to Africa",
                        onClick = { navController.navigate(BottomBarScreen.SentToAfrica.route) }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_world),
                            contentDescription = "",
                            tint = SecondaryGreen
                        )
                    }
                }

            }
        }
    }
}

