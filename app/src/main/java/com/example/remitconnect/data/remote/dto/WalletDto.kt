package com.example.remitconnect.data.remote.dto

import com.example.remitconnect.domain.model.Wallet

data class WalletDto(
    val id: String,
    val name: String
)

fun WalletDto.toWallet(): Wallet {
    return Wallet(
        name = this.name
    )
}