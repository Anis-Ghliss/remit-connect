package com.example.remitconnect.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.remitconnect.R

@Preview
@Composable
fun BalanceCard() {
    val brush = Brush.horizontalGradient(listOf(Color(0xff00A85A), Color(0xff055C00)))
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(161.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(brush)
            .padding(24.dp)
    ) {

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxHeight()
            ) {
                Text(
                    text = "Your balance",
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.outfit_regular)),
                    color = Color.White
                )
                Column(
                ) {
                    Text(
                        text = "320,000",
                        fontSize = 24.sp,
                        fontWeight = FontWeight(600),
                        fontFamily = FontFamily(Font(R.font.outfit_regular)),
                        color = Color.White,
                        textAlign = TextAlign.End
                    )
                    Text(
                        text = "US Dollars",
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.outfit_light)),
                        color = Color.White,
                    )
                }

            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,

                modifier = Modifier
                    .width(56.dp)
                    .height(56.dp)
                    .background(
                        color = Color(0x33FFFFFF),
                        shape = RoundedCornerShape(size = 16.8.dp)
                    )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_bulk),
                    contentDescription = "monkeys",
                    tint = Color.White
                )
            }


        }


    }
}

