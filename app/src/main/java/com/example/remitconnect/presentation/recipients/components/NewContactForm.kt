package com.example.remitconnect.presentation.recipients.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import androidx.compose.ui.unit.toSize
import com.example.remitconnect.presentation.theme.ui.theme.SecondaryGreen

@Preview(showSystemUi = true)
@Composable
fun NewContactForm() {
    Column(
        verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.CenterVertically),
        modifier = Modifier.fillMaxWidth()
    ) {
        FormItem("Phone number")
        FormItem("First Name")
        FormItem("Last Name")
    }
}

@Composable
private fun FormItem(inputLabel: String) {
    var mField by remember { mutableStateOf("") }
    var mTextFieldSize by remember { mutableStateOf(Size.Zero) }
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Text(
            text = inputLabel,
            style = MaterialTheme.typography.body1,
            color = Color(0xFF00122C)
        )
        OutlinedTextField(
            shape = RoundedCornerShape(8.dp),
            value = mField,
            onValueChange = { mField = it },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    mTextFieldSize = coordinates.size.toSize()
                },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = SecondaryGreen,
                unfocusedBorderColor = Color(0xffBFC3CA)
            ),
            enabled = true,
        )
    }

}