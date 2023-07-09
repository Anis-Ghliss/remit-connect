package com.example.remitconnect.presentation.nav

import com.example.remitconnect.R

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: Int
) {
    object Home: BottomBarScreen(
        route = "home",
        title = "Home",
        icon = R.drawable.ic_nav_home
    )
    object Cards: BottomBarScreen(
        route = "cards",
        title = "Cards",
        icon = R.drawable.ic_nav_credit_card
    )
    object Send: BottomBarScreen(
        route = "send",
        title = "",
        icon = R.drawable.ic_nav_paper_plane
    )
    object Coins: BottomBarScreen(
        route = "tontines",
        title = "Tontines",
        icon = R.drawable.ic_nav_coin
    )
    object Settings: BottomBarScreen(
        route = "settings",
        title = "Settings",
        icon = R.drawable.ic_nav_cog
    )

    object SentToAfrica: BottomBarScreen(
        route = "sent-to-affrica",
        title = "Send to africa",
        icon = R.drawable.ic_nav_cog
    )

    object Recipients: BottomBarScreen(
        route = "recipients",
        title = "Recipients",
        icon = R.drawable.ic_nav_cog
    )

    object WalletOptions: BottomBarScreen(
        route = "wallet",
        title = "Wallets",
        icon = R.drawable.ic_nav_cog
    )

    object ConfirmSendMoney: BottomBarScreen(
        route = "confirm-send-money",
        title = "ConfirmSendMoney",
        icon = R.drawable.ic_nav_cog
    )

    object SuccessScreen: BottomBarScreen(
        route = "success",
        title = "Success",
        icon = R.drawable.ic_nav_cog
    )
}
