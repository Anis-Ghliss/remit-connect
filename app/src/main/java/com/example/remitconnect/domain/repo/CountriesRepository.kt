package com.example.remitconnect.domain.repo

import com.example.remitconnect.data.remote.dto.CountryDto


interface CountriesRepository {
    suspend fun getCountries(): List<CountryDto>

}