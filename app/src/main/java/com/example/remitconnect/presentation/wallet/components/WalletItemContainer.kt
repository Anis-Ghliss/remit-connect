package com.example.remitconnect.presentation.wallet.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.remitconnect.domain.model.Wallet
import com.example.remitconnect.presentation.theme.ui.theme.SecondaryGreen

@Composable
fun WalletItemContainer(
    index: Int,
    wallet: Wallet,
    selectedWalletIndex: Int,
    Image: @Composable() () -> Unit,
    onWalletSelected: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.Start),
        modifier = Modifier
            .clickable { onWalletSelected() }
            .fillMaxWidth()
            .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 12.dp))
            .border(
                width = 1.dp,
                color = if (selectedWalletIndex == index) SecondaryGreen else Color(0xFFE0E2E5),
                shape = RoundedCornerShape(size = 12.dp)
            )
            .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 16.dp)
    ) {
        Image()
        Text(text = wallet.name, style = MaterialTheme.typography.h3)
    }
}

