package com.example.remitconnect.presentation.recipients.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.remitconnect.presentation.theme.ui.theme.SecondaryGreen

@Composable
fun SwitchButton(
    title: String,
    isActive: Boolean,
    onClick: () -> Unit
) {

    Row(
        horizontalArrangement = Arrangement.spacedBy(0.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .width(175.5.dp)
            .height(44.dp)
            .background(
                color = if (isActive) Color(0xff08A075) else Color.Transparent,
                shape = RoundedCornerShape(size = 8.dp)
            )
            .clickable { onClick() }
    ) {
        Text(
            text = title,
            color = if (isActive) Color.White else SecondaryGreen,
            style = MaterialTheme.typography.button,
            textAlign = TextAlign.Center,
        )
    }
}
