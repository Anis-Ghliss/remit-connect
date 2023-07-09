package com.example.remitconnect.data.remote.dto

import com.example.remitconnect.domain.model.Country

data class CountryDto(
    val currency_code: String,
    val id: String,
    val name: String
)

fun CountryDto.toCountry() : Country {
    return Country(
        currency_code = this.currency_code,
        name = this.name
    )
}