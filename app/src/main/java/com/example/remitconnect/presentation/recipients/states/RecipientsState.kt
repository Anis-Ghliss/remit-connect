package com.example.remitconnect.presentation.recipients.states

import com.example.remitconnect.domain.model.Recipient

data class RecipientsState(
    val isLoading: Boolean = false,
    val recipients: List<Recipient> = emptyList(),
    val error: String = ""
)