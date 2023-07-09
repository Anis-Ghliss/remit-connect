package com.example.remitconnect.domain.use_case.recipient

import com.example.moneco.common.Ressource
import com.example.remitconnect.domain.model.Recipient
import com.example.remitconnect.data.remote.dto.toRecipient
import com.example.remitconnect.domain.repo.RecipientRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetRecipientsUseCase @Inject constructor(
    private val repository: RecipientRepository
) {
    operator fun invoke(): Flow<Ressource<List<Recipient>>> = flow {
        try {
            emit(Ressource.Loading())
            val recipients = repository.getRecipients().map { it -> it.toRecipient() }
            emit(Ressource.Success(recipients))
        }catch (e: HttpException) {
            emit(Ressource.Error(e.localizedMessage?: "Unexpected error occured" ))
        }catch (e: IOException) {
            emit(Ressource.Error("Couldn't reach server, Check your internet connection" ))

        }
    }
}