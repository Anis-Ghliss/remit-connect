package com.example.remitconnect.presentation.wallet.state

import com.example.remitconnect.domain.model.Recipient
import com.example.remitconnect.domain.model.Wallet

data class WalletState(
    val isLoading: Boolean = false,
    val wallets: List<Wallet> = emptyList(),
    val error: String = ""
)

