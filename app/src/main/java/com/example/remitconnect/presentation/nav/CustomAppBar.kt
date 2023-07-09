package com.example.remitconnect.presentation.sendMoneyOptions.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.remitconnect.R

@Composable
fun CustomAppBar(
    onClick: () -> Unit,
    showBackArrow: Boolean,
    showActions: Boolean,
    color: Color = Color.White
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = if (showBackArrow) Arrangement.Start else Arrangement.End,
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
            .height(48.dp)
            .background(color = color)

    ) {
        if (showActions)
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .height(32.dp)
                    .width(32.dp)
                    .background(
                        color = Color(0xffF2F3F4),
                        shape = RoundedCornerShape(size = 10.dp)
                    )
                    .padding(start = 6.dp, top = 6.dp, end = 6.dp, bottom = 6.dp)
                    .clickable { onClick() }
            ) {

                Icon(
                    painter = painterResource(id = if (showBackArrow) R.drawable.ic_arrow_left else R.drawable.ic_close),
                    "close icon",
                    tint = Color(0xff00122C),
                    modifier = Modifier
                        .width(20.dp)
                        .height(20.dp),
                )

            }
    }


}