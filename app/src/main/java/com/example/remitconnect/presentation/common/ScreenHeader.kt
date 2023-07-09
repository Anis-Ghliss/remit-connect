package com.example.remitconnect.presentation.common

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ScreenHeader(text: String, modifier: Modifier) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.h1
    )
}