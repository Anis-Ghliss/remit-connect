package com.example.remitconnect.presentation.success

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.remitconnect.R
import com.example.remitconnect.presentation.nav.BottomBarScreen
import com.example.remitconnect.presentation.theme.ui.theme.PrimaryGreen
import com.example.remitconnect.presentation.theme.ui.theme.SecondaryGreen

@Composable
fun SuccessScreen(navController: NavController) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = PrimaryGreen)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_success_illustration),
                contentDescription = ""
            )
            Text(
                text = "Your money is on the way. Get excited! " , modifier = Modifier.padding(horizontal = 50.dp), style = TextStyle(
                    fontSize = 28.sp,
                    lineHeight = 36.4.sp,
                    fontFamily = FontFamily(Font(R.font.outfit_regular)),
                    fontWeight = FontWeight(700),
                    color = Color(0xFFFFFFFF),
                    textAlign = TextAlign.Center,
                )
            )
            Button(
                onClick = { navController.navigate(BottomBarScreen.Home.route) },
                shape = RoundedCornerShape(size = 16.dp),
                colors = ButtonDefaults.outlinedButtonColors(backgroundColor = SecondaryGreen),
                modifier = Modifier.fillMaxWidth().padding(horizontal = 50.dp)
            ) {
                Text(
                    text = "Got it!",
                    modifier = Modifier.padding(horizontal = 20.dp),
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        fontFamily = FontFamily(Font(R.font.outfit_regular)),
                        fontWeight = FontWeight(600),
                        color = Color(0xFFFFFFFF),
                        textAlign = TextAlign.Center,
                    )
                )
            }
        }
    }


}