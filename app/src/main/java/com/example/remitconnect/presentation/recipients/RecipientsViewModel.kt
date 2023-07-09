package com.example.remitconnect.presentation.recipients

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moneco.common.Ressource
import com.example.remitconnect.domain.model.Recipient
import com.example.remitconnect.domain.use_case.country.GetCountriesUseCase
import com.example.remitconnect.domain.use_case.recipient.GetRecipientsUseCase
import com.example.remitconnect.presentation.recipients.states.CountryState
import com.example.remitconnect.presentation.recipients.states.RecipientsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class RecipientsViewModel @Inject constructor(
    private val getRecipientsUseCase: GetRecipientsUseCase,
    private val getCountriesUseCase: GetCountriesUseCase
) : ViewModel() {

    var newParticipantButtonIsActive by mutableStateOf(false)
        private set
    var oldParticipantButtonIsActive by mutableStateOf(!newParticipantButtonIsActive)
        private set

    private val _recipientsState = mutableStateOf(RecipientsState())
    val recipientsState: State<RecipientsState> = _recipientsState

    private val _countriesState = mutableStateOf(CountryState())
    val countriesState: State<CountryState> = _countriesState

    //Searching logic
    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    private val _recipientsList = MutableStateFlow(listOf<Recipient>())

    @OptIn(FlowPreview::class)
    val recipients = _searchText
        .debounce(500L)
        .onEach { _isSearching.update { true } }
        .combine(_recipientsList) { text, recipients ->
            println(_recipientsList.value)
            if (text.isBlank()) {
                recipients
            } else {
                recipients.filter {
                    it.doesMatchSearchQuery(text)
                }
            }
        }.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            _recipientsList.value
        )

    fun onSearchTextChange(text: String) {
        _searchText.value = text
    }

    fun updateParticipantToNew() {
        newParticipantButtonIsActive = true
        oldParticipantButtonIsActive = false
    }

    fun updateParticipantToOld() {
        newParticipantButtonIsActive = false
        oldParticipantButtonIsActive = true
    }

    init {
        getRecipientList()
        getCountriesList()
    }

    private fun getRecipientList() {
        getRecipientsUseCase().onEach { result ->
            when (result) {
                is Ressource.Success -> {
                    _recipientsState.value =
                        RecipientsState(recipients = result.data ?: emptyList())
                    _recipientsList.value = result.data ?: emptyList()
                }
                is Ressource.Error -> {
                    _recipientsState.value =
                        RecipientsState(error = result.message ?: "An unexpected error ocured")
                }
                is Ressource.Loading -> {
                    _recipientsState.value = RecipientsState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getCountriesList() {
        getCountriesUseCase().onEach { result ->

            when (result) {
                is Ressource.Success -> {
                    println(result.data)
                    _countriesState.value = CountryState(countries = result.data ?: emptyList())
                }
                is Ressource.Error -> {
                    println(result.message)
                    _countriesState.value =
                        CountryState(error = result.message ?: "An unexpected error ocured")
                }
                is Ressource.Loading -> {
                    println("loading")
                    _countriesState.value = CountryState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }


}