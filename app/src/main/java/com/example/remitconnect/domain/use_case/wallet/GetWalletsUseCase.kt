package com.example.remitconnect.domain.use_case.wallet


import com.example.moneco.common.Ressource
import com.example.remitconnect.domain.model.Wallet
import com.example.remitconnect.data.remote.dto.toWallet
import com.example.remitconnect.domain.repo.WalletRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetWalletsUseCase @Inject constructor(
    private val repository: WalletRepository
) {
    operator fun invoke(): Flow<Ressource<List<Wallet>>> = flow {
        try {
            emit(Ressource.Loading())
            val wallets = repository.getWallets().map { it -> it.toWallet() }
            emit(Ressource.Success(wallets))
        } catch (e: HttpException) {
            emit(Ressource.Error(e.localizedMessage ?: "Unexpected error occured"))
        } catch (e: IOException) {
            emit(Ressource.Error("Couldn't reach server, Check your internet connection"))

        }
    }
}