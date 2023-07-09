package com.example.remitconnect.data.repo


import com.example.remitconnect.data.remote.RemitConnectApi
import com.example.remitconnect.data.remote.dto.CountryDto
import com.example.remitconnect.domain.repo.CountriesRepository
import javax.inject.Inject

class CountriesRepositoryImpl @Inject constructor(
    private val api: RemitConnectApi
) : CountriesRepository {
    override suspend fun getCountries(): List<CountryDto> {
        return api.getContries()
    }

}