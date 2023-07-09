package com.example.remitconnect.presentation.recipients.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showSystemUi = true)
@Composable
fun TextDivider() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxWidth()
    ) {
        Divider(thickness = 1.dp, modifier = Modifier.weight(0.2f))
        Text(
            modifier = Modifier.weight(0.3f),
            text = "Or add manually".uppercase(),
            color = Color(0xFF7F8895),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.subtitle2,

            )
        Divider(thickness = 1.dp, modifier = Modifier.weight(0.2f))

    }
}