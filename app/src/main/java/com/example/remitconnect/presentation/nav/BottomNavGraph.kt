package com.example.remitconnect.presentation.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.remitconnect.presentation.confirmSendMoney.SendMoneyAmountScreen
import com.example.remitconnect.presentation.home.HomeScreen
import com.example.remitconnect.presentation.recipients.RecipientsScreen
import com.example.remitconnect.presentation.sendMoneyOptions.SendMoneyScreen
import com.example.remitconnect.presentation.sendMoneyOptions.SendToAfticaScreen
import com.example.remitconnect.presentation.success.SuccessScreen
import com.example.remitconnect.presentation.wallet.WalletOptionScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomBarScreen.Home.route) {

        composable(route = BottomBarScreen.Home.route) {
            HomeScreen(navController)
        }
        composable(route = BottomBarScreen.Send.route) {
            SendMoneyScreen(navController)
        }

        composable(route = BottomBarScreen.Cards.route) {
            HomeScreen(navController)
        }

        composable(route = BottomBarScreen.Coins.route) {
            HomeScreen(navController)
        }

        composable(route = BottomBarScreen.Settings.route) {
            HomeScreen(navController)
        }

        composable(route = BottomBarScreen.SentToAfrica.route) {
            SendToAfticaScreen(navController)
        }

        composable(route = BottomBarScreen.Recipients.route) {
            RecipientsScreen(navController)
        }

        composable(route = BottomBarScreen.WalletOptions.route) {
            WalletOptionScreen(navController)
        }

        composable(route = BottomBarScreen.ConfirmSendMoney.route) {
            SendMoneyAmountScreen(navController, )
        }

        composable(route = BottomBarScreen.SuccessScreen.route) {
            SuccessScreen(navController, )
        }
    }
}