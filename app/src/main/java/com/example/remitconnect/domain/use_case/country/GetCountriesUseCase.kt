package com.example.remitconnect.domain.use_case.country

import com.example.moneco.common.Ressource
import com.example.remitconnect.domain.model.Country
import com.example.remitconnect.data.remote.dto.toCountry
import com.example.remitconnect.domain.repo.CountriesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class GetCountriesUseCase @Inject constructor(
    private val repository: CountriesRepository
) {
    operator fun invoke(): Flow<Ressource<List<Country>>> = flow {
        try {
            emit(Ressource.Loading())
            val countries = repository.getCountries().map { it -> it.toCountry() }
            emit(Ressource.Success(countries))
        } catch (e: HttpException) {
            emit(Ressource.Error(e.localizedMessage ?: "Unexpected error occured"))
        } catch (e: IOException) {
            emit(Ressource.Error("Couldn't reach server, Check your internet connection"))

        }
    }
}