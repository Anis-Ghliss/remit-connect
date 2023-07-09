package com.example.remitconnect.domain.repo

import com.example.remitconnect.data.remote.dto.RecipientDto


interface RecipientRepository {
    suspend fun getRecipients(): List<RecipientDto>
}