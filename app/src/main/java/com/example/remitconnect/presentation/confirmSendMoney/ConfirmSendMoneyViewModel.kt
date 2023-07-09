package com.example.remitconnect.presentation.confirmSendMoney

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import java.text.DecimalFormat
import javax.inject.Inject

class ConfirmSendMoneyViewModel : ViewModel() {

    val CONVERTION_RATE: Double = 655.94
    val TRANSFER_FEE_EURO: Double = 1.3
    val MONECO_FEE: Double = 0.0

    private val df = DecimalFormat("#.##")

    var mField by mutableStateOf("")
        private set

    fun updateAmoutValue(amount: String) {
        mField = amount
    }

    fun convertEuroToXOF(): Double {
        if (mField.isNotBlank())
            return df.format(mField.toDouble() * CONVERTION_RATE).toDouble()
        return 0.0
    }

    fun totalAmount(): Double {
        if (mField.isNotBlank())
            return mField.toDouble() + TRANSFER_FEE_EURO + MONECO_FEE
        return TRANSFER_FEE_EURO + MONECO_FEE
    }
}