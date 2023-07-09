package com.example.remitconnect.presentation.recipients.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.remitconnect.domain.model.Country

@Composable
fun NewContacts(listOfCountries: List<Country>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = "Country",
            style = MaterialTheme.typography.h3,
        )
    }
    DropDownComponent(listOfCountries)
    Spacer(modifier = Modifier.size(16.dp))
    ChooseContactButton()
    Spacer(modifier = Modifier.size(32.dp))
    TextDivider()
    Spacer(modifier = Modifier.size(24.dp))
    NewContactForm()
}




