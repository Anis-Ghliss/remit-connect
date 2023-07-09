package com.example.remitconnect.presentation.confirmSendMoney.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.remitconnect.R
import com.example.remitconnect.presentation.confirmSendMoney.ConfirmSendMoneyViewModel

@Composable
fun FeesSection(viewModel: ConfirmSendMoneyViewModel) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Fees breakdown",
// Body/md/med
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 24.sp,
                fontFamily = FontFamily(Font(R.font.outfit_regular)),
                fontWeight = FontWeight(500),
                color = Color(0xFF00122C),
            )
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            FeesRow("Moneco fees", viewModel.MONECO_FEE, "EUR")
            FeesRow("Transfer fees", viewModel.TRANSFER_FEE_EURO, "EUR")
            FeesRow("Conversion rate", viewModel.CONVERTION_RATE, "XOF")
            FeesRow("You’ll spend in total", viewModel.totalAmount(), "EUR")
        }

        DashedDivider(
            color = Color(0xff7F8895),
            thickness = 1.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp)
        )
        FeesRow("Recipient gets", viewModel.convertEuroToXOF(), "XOF", result = true)


    }
}


@Composable
private fun FeesRow(feeLabel: String, ammount: Double, unit: String, result: Boolean? = false) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = feeLabel, style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 21.sp,
                fontFamily = FontFamily(Font(R.font.outfit_regular)),
                fontWeight = FontWeight(400),
                color = Color(0xFF7F8895),
            )
        )

        Text(
            text = "$ammount $unit", style = TextStyle(
                fontSize = if (result == true) 18.sp else 14.sp,
                lineHeight = 21.sp,
                fontFamily = FontFamily(Font(R.font.outfit_regular)),
                fontWeight = if (result == true) FontWeight(600) else FontWeight(400),
                color = Color(0xFF00122C),
                textAlign = TextAlign.Right,
            )
        )


    }
}

