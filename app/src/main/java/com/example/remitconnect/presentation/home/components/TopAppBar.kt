package com.example.remitconnect.presentation.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun CustomTopBar() {
    Column(
        Modifier
            .fillMaxWidth()
    ) {
        TopAppBar(

            elevation = 0.dp,
            title = {
                Text("")
            },
            backgroundColor = Color(0xFFF8FCFB),
        )
    }
}
