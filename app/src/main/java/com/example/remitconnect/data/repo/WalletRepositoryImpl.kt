package com.example.remitconnect.data.repo

import com.example.remitconnect.data.remote.RemitConnectApi
import com.example.remitconnect.data.remote.dto.WalletDto
import com.example.remitconnect.domain.repo.WalletRepository




import javax.inject.Inject

data class WalletRepositoryImpl @Inject constructor(
    private val api: RemitConnectApi
) : WalletRepository {

    override suspend fun getWallets(): List<WalletDto> {
        return api.getWallets()
    }
}