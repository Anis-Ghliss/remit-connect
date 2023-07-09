package com.example.remitconnect.presentation.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.remitconnect.R
import com.example.remitconnect.presentation.common.ScreenHeader


@Composable
fun Greeting(
   name: String
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()

    ) {
        ScreenHeader(
            text = "Hey, $name",
            modifier = Modifier
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_bell),
            contentDescription = "bell icon",
            tint = Color.Unspecified,
        )

    }

}