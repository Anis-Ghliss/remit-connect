package com.example.remitconnect.presentation.nav

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.remitconnect.R
import com.example.remitconnect.presentation.theme.ui.theme.BottomBarGray
import com.example.remitconnect.presentation.theme.ui.theme.PrimaryGreen

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Cards,
        BottomBarScreen.Send,
        BottomBarScreen.Coins,
        BottomBarScreen.Settings
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination
    Row(
        modifier = Modifier
            .padding(top = 8.dp)
            .background(Color.White)
            .fillMaxWidth()
            .height(80.dp),

        horizontalArrangement = Arrangement.spacedBy(
            25.dp, Alignment.CenterHorizontally
        ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        screens.forEach { screen ->
            NavigationBarItem(
                screen = screen,
                currentDestination = currentRoute,
                navController = navController
            )
        }
    }
}

@Composable
private fun NavigationBarItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController,
) {
    val selected = currentDestination?.route == screen.route

    println("this is the screen route 2: ${screen.route}")


    val contentColor =
        if (selected) PrimaryGreen else BottomBarGray

    Box(
        modifier = Modifier
            .background(Color.Transparent)
            .height(70.dp)
            .clickable {
                println(screen.route)
                println(selected)
                navController.navigate(screen.route)
            }
    ) {
        if (screen.route !== "send")
            Column(
                Modifier.padding(top = 10.dp),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painter = painterResource(id = if (selected) screen.icon else screen.icon),
                    tint = contentColor,
                    contentDescription = "icon",
                )

                Text(
                    text = screen.title,
                    color = contentColor,
                    fontFamily = FontFamily(Font(R.font.outfit_regular))
                )
            } else {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .width(56.dp)
                    .height(56.dp)

                    .background(color = Color(0xFFFFCF00), shape = RoundedCornerShape(size = 56.dp))
            ) {
                Icon(
                    painter = painterResource(id = screen.icon),
                    contentDescription = "icon",
                )
            }
        }
    }
}

