package com.example.remitconnect.presentation.wallet

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moneco.common.Ressource
import com.example.remitconnect.domain.use_case.wallet.GetWalletsUseCase
import com.example.remitconnect.presentation.wallet.state.WalletState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class WalletViewModel @Inject constructor(
    private val getWalletUseCase: GetWalletsUseCase,
) : ViewModel() {

    private val _walletsState = mutableStateOf(WalletState())
    val walletsState: State<WalletState> = _walletsState

    var selectedItem by mutableStateOf(-1)
        private set

    val onSelectWallet = { index: Int ->
        println(index)
        selectedItem = index
    }


    private fun getWalletsList() {
        getWalletUseCase().onEach { result ->
            when (result) {
                is Ressource.Success -> {
                    _walletsState.value =
                        WalletState(wallets = result.data ?: emptyList())
                }
                is Ressource.Error -> {
                    _walletsState.value =
                        WalletState(error = result.message ?: "An unexpected error ocured")
                }
                is Ressource.Loading -> {
                    _walletsState.value = WalletState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    init {
        getWalletsList()
    }
}