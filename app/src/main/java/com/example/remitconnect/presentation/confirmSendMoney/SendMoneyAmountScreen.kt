package com.example.remitconnect.presentation.confirmSendMoney

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.remitconnect.presentation.common.ActionConfirmButton
import com.example.remitconnect.presentation.common.ScreenHeader
import com.example.remitconnect.presentation.sendMoneyOptions.components.CustomAppBar
import com.example.remitconnect.presentation.theme.ui.theme.SecondaryGreen
import com.example.remitconnect.presentation.confirmSendMoney.components.AmountInput
import com.example.remitconnect.presentation.confirmSendMoney.components.BottomSheetConfirmation
import com.example.remitconnect.presentation.confirmSendMoney.components.DescriptionSection
import com.example.remitconnect.presentation.confirmSendMoney.components.FeesSection
import com.example.remitconnect.presentation.nav.BottomBarScreen
import com.example.remitconnect.presentation.theme.ui.theme.PaleGreen
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.suspendCoroutine

@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SendMoneyAmountScreen(
    navController: NavController,
    viewModel: ConfirmSendMoneyViewModel = hiltViewModel()
) {
    val coroutineScope = rememberCoroutineScope()

    val sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden,
        confirmValueChange = { it != ModalBottomSheetValue.HalfExpanded }
    )

    val expandBottomSheet: () -> Unit = {
        coroutineScope.launch {
            sheetState.show()
        }
    }
    BackHandler(sheetState.isVisible) {
        coroutineScope.launch { sheetState.hide() }
    }
    BottomSheetConfirmation(
        viewModel,
        sheetState,
        onConfirm = { navController.navigate(BottomBarScreen.SuccessScreen.route) },
    ) {
        Scaffold(
            backgroundColor = Color.White,

            topBar = {
                CustomAppBar(
                    onClick = { navController.popBackStack() },
                    showBackArrow = true,
                    showActions = true
                )
            },
            bottomBar = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(104.dp)
                        .background(color = Color.White)
                        .shadow(
                            elevation = 20.dp,
                            spotColor = Color(0x1A000000),
                        )

                ) {
                    ActionConfirmButton(
                        text = "Send",
                        color = if (viewModel.mField.isBlank()) PaleGreen else SecondaryGreen,
                        onClick = { expandBottomSheet() }
                    )
                }
            }

        ) {
            Column() {
                ScreenHeader(text = "Send money", modifier = Modifier.padding(horizontal = 24.dp))
                Column(
                    modifier = Modifier.padding(24.dp)
                ) {
                    Text(
                        text = "How much are you sending ?",
                        style = MaterialTheme.typography.h2,
                        color = Color(0xFF00122C),
                    )
                    AmountInput(viewModel)
                    Spacer(modifier = Modifier.size(32.dp))
                    DescriptionSection()
                    Spacer(modifier = Modifier.size(32.dp))
                    FeesSection(viewModel)
                }

            }

        }
    }

}

