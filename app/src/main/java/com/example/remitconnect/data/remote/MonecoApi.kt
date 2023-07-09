package com.example.remitconnect.data.remote

import com.example.remitconnect.data.remote.dto.CountryDto
import com.example.remitconnect.data.remote.dto.RecipientDto
import com.example.remitconnect.data.remote.dto.WalletDto
import retrofit2.http.GET

interface RemitConnectApi {

    @GET("wallets")
    suspend fun getWallets(): List<WalletDto>

    @GET("countries")
    suspend fun getContries(): List<CountryDto>

    @GET("recipients")
    suspend fun getRecipients(): List<RecipientDto>
}