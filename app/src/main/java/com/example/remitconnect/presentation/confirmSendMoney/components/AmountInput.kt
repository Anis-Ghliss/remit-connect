package com.example.remitconnect.presentation.confirmSendMoney.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.remitconnect.R
import com.example.remitconnect.presentation.confirmSendMoney.ConfirmSendMoneyViewModel
import com.example.remitconnect.presentation.theme.ui.theme.SecondaryGreen

@Composable
fun AmountInput(viewModel: ConfirmSendMoneyViewModel) {

    Column(
        modifier = Modifier
            .padding(vertical = 12.dp)
            .border(
                width = 1.dp,
                color = if (viewModel.mField.isBlank()) Color(0xff7F8895) else Color(0xff007554),
                shape = RoundedCornerShape(size = 8.dp)
            )
    ) {
        Row(
            Modifier
                .padding(8.dp)
                .background(color = Color.Transparent)
        ) {
            OutlinedTextField(
                shape = RoundedCornerShape(8.dp),
                value = viewModel.mField,
                onValueChange = { viewModel.updateAmoutValue(it) },
                modifier = Modifier
                    .fillMaxWidth(),
                textStyle = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 27.sp,
                    fontFamily = FontFamily(Font(R.font.outfit_regular)),
                    fontWeight = FontWeight(600),
                    color = Color(0xFF00122C),
                ),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    cursorColor = SecondaryGreen,
                    textColor = Color(0xFF00122C),
                ),
                trailingIcon = {
                    Text(
                        text = "EUR", style = TextStyle(
                            fontSize = 18.sp,
                            lineHeight = 27.sp,
                            fontFamily = FontFamily(Font(R.font.outfit_regular)),
                            fontWeight = FontWeight(600),
                            color = Color(0xFF7F8895),
                            textAlign = TextAlign.Right,
                        )
                    )
                },
                enabled = true,
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = if (viewModel.mField.isBlank()) Color(0xFFF2F3F4) else Color(0xffEDF8F5),
                    shape = RoundedCornerShape(
                        topStart = 0.dp,
                        topEnd = 0.dp,
                        bottomEnd = 8.dp,
                        bottomStart = 8.dp
                    )
                )
                .padding(start = 8.dp, top = 8.dp, end = 8.dp, bottom = 8.dp)
        ) {
            Text(
                text = "Your current balance is  ",
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 18.sp,
                    fontFamily = FontFamily(Font(R.font.outfit_regular)),
                    fontWeight = FontWeight(400),
                    color = if (viewModel.mField.isBlank()) Color(0xFF00122C) else Color(0xFF007554),
                )
            )
            Text(
                text = "230 EUR", style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 18.sp,
                    fontFamily = FontFamily(Font(R.font.outfit_regular)),
                    fontWeight = FontWeight(600),
                    color = if (viewModel.mField.isBlank()) Color(0xFF00122C) else Color(0xFF007554),
                )
            )
        }
    }
}