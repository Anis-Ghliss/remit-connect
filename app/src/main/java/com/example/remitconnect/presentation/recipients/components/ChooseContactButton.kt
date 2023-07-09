package com.example.remitconnect.presentation.recipients.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.remitconnect.R
import com.example.remitconnect.presentation.theme.ui.theme.PaleGreen
import com.example.remitconnect.presentation.theme.ui.theme.SecondaryGreen

@Composable
fun ChooseContactButton() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .background(color = PaleGreen, shape = RoundedCornerShape(8.dp))
    ) {
        Icon(
            painter = painterResource(id = R.drawable.document),
            contentDescription = "document",
            tint = SecondaryGreen
        )
        Text(
            text = "Choose a contact",
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(R.font.outfit_regular)),
            fontWeight = FontWeight(600),
            color = SecondaryGreen
        )
    }
}