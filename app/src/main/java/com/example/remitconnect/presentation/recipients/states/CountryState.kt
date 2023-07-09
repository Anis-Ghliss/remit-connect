package com.example.remitconnect.presentation.recipients.states

import com.example.remitconnect.domain.model.Country

data class CountryState(
    val isLoading: Boolean = false,
    val countries: List<Country> = emptyList(),
    val error: String = ""
)
