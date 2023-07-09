package com.example.remitconnect.data.repo


import com.example.remitconnect.data.remote.RemitConnectApi
import com.example.remitconnect.data.remote.dto.RecipientDto
import com.example.remitconnect.domain.repo.RecipientRepository
import javax.inject.Inject

class RecipientRepositoryImpl @Inject constructor(
    private val api: RemitConnectApi
): RecipientRepository {
    override suspend fun getRecipients(): List<RecipientDto> {
        return api.getRecipients()
    }
}