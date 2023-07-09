package com.example.remitconnect.presentation.confirmSendMoney.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.remitconnect.R

@Composable
fun DescriptionSection() {
    Column {
        Text(
            text = "Yearly free remittances",
// Body/md/med
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 24.sp,
                fontFamily = FontFamily(Font(R.font.outfit_regular)),
                fontWeight = FontWeight(500),
                color = Color(0xFF00122C),
            )
        )
        Text(
            text = "Remittances are free with Moneco until you reach your limit, which resets every year.",
// Body/sm/reg
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 21.sp,
                fontFamily = FontFamily(Font(R.font.outfit_regular)),
                fontWeight = FontWeight(400),
                color = Color(0xFF7F8895),
            )
        )
        Text(
            text = "Check number of free remittance remaining",
// Body/sm/bold
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 21.sp,
                fontFamily = FontFamily(Font(R.font.outfit_regular)),
                fontWeight = FontWeight(600),
                color = Color(0xFF1B98E0),
            )
        )
    }
}