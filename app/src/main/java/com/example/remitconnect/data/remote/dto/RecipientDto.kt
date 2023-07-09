package com.example.remitconnect.data.remote.dto

import com.example.remitconnect.domain.model.Recipient

data class RecipientDto(
    val country: String,
    val id: String,
    val mobile_wallet: String,
    val name: String
)

fun RecipientDto.toRecipient(): Recipient {
    return Recipient(
        country = this.country,
        mobile_wallet = this.mobile_wallet,
        name = this.name
    )
}