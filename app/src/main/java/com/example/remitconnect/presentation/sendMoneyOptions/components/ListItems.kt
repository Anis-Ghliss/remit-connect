package com.example.remitconnect.presentation.sendMoneyOptions.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.remitconnect.R
import com.example.remitconnect.presentation.theme.ui.theme.PaleGreen
import androidx.compose.material.Icon

@Composable
fun ListItem(
    text: String,
    onClick: () -> Unit?,
    Icon: @Composable() () -> Unit,

) {
    Divider(color = Color(0xFFF2F3F4))
    Row(

        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .height(72.dp)
            .fillMaxWidth()
            .padding(start = 24.dp, top = 16.dp, end = 24.dp, bottom = 16.dp)
            .clickable {
                onClick()!!
            }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp)
                    .background(color = PaleGreen, shape = RoundedCornerShape(size = 12.dp))
                    .padding(start = 12.dp, top = 12.dp, end = 12.dp, bottom = 12.dp)
            ) {
                Icon()
            }
            Text(
                text = text,
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.outfit_regular)),
                fontWeight = FontWeight(500),
                color = Color(0xFF00122C),

                )

        }

        Icon(
            painter = painterResource(id = R.drawable.ic_chevron_right),
            contentDescription = "Chevron right"
        )
    }
    Divider(color = Color(0xFFF2F3F4))

}