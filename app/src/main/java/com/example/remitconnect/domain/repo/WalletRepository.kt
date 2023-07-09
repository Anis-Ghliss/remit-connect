package com.example.remitconnect.domain.repo

import com.example.remitconnect.data.remote.dto.WalletDto

interface WalletRepository {
    suspend fun getWallets() : List<WalletDto>
}