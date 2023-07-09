package com.example.remitconnect.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.remitconnect.R

@Composable
fun TransactionsSection() {
    Column(
        modifier = Modifier
            .shadow(elevation = 20.dp)
            .height(470.dp)
            .background(Color.White, shape = RoundedCornerShape(8, 8))
    ) {
        TransactionItem(
            TxType.SEND,
            "Ralph Doe"
        )
        {
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_up_right),
                contentDescription = "up arrow",
                        tint = Color(0xff1B98E0)
            )
        }

        Divider(color = Color(0xFFF2F3F4))
        TransactionItem(
            TxType.SEND,
            "Jessic Jones"
        )
        {
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_up_right),
                contentDescription = "",
                tint = Color(0xff1B98E0)

            )
        }

        Divider(color = Color(0xFFF2F3F4))
        TransactionItem(
            TxType.RECEIVE, "Leslie Alexander"
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_down_left),
                contentDescription = "",
                tint = Color(0xff007554)
            )
        }

        Divider(color = Color(0xFFF2F3F4))
        TransactionItem(
            TxType.CREDIT, "Burger King"
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_card),
                contentDescription = "",
                tint = Color(0xFFFFCF00)
            )
        }

        Divider(color = Color(0xFFF2F3F4))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)

        ) {
            Text(
                text = "Show all activities", color = Color(0xFF7F8895),
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.outfit_regular)),
                fontWeight = FontWeight(500),
                textAlign = TextAlign.Center
            )
        }
    }

}

