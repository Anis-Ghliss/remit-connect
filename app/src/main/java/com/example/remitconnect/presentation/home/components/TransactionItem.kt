package com.example.remitconnect.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.remitconnect.R

@Composable
fun TransactionItem(
    transactionType: TxType,
    name: String,
    Icon: @Composable() () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)

        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,

                modifier = Modifier
                    .width(56.dp)
                    .height(56.dp)
                    .background(
                        color = when (transactionType) {
                            TxType.SEND -> Color(0xFFEAF6FC)
                            TxType.CREDIT -> Color(0xFFFFFBE8)
                            TxType.RECEIVE -> Color(0xFFEDF8F5)
                        },
                        shape = RoundedCornerShape(size = 16.8.dp)
                    )
            ) {

                Icon()
            }

            Column() {
                Text(
                    text = when (transactionType) {
                        TxType.SEND -> "Sent to"
                        TxType.CREDIT -> "Received from"
                        TxType.RECEIVE -> "Spent at"
                    },
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.outfit_regular)),
                    color = Color(0xFF7F8895)
                )
                Text(
                    text = name,
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.outfit_regular)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFF00122C)
                )

            }
        }
        Text(
            text = "€ 150",
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.outfit_regular)),
            fontWeight = FontWeight(500),
            color = Color(0xFF00122C),
        )
    }
}