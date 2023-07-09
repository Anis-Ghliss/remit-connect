package com.example.remitconnect.presentation.confirmSendMoney.components

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.remitconnect.R
import com.example.remitconnect.presentation.common.ActionConfirmButton
import com.example.remitconnect.presentation.common.ScreenHeader
import com.example.remitconnect.presentation.confirmSendMoney.ConfirmSendMoneyViewModel
import com.example.remitconnect.presentation.theme.ui.theme.SecondaryGreen

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheetConfirmation(
    viewModel: ConfirmSendMoneyViewModel,
    scaffoldState: ModalBottomSheetState,
    onConfirm: () -> Unit,
    Content: @Composable() () -> Unit,
) {
    ModalBottomSheetLayout(
        sheetState = scaffoldState,
        sheetContent = {
            BottomSheetContent(
                viewModel.convertEuroToXOF(),
                to = "Esther Howard",
                via = "Wave",
                onConfirm = onConfirm
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White),
        sheetShape = RoundedCornerShape(
            topStart = 32.dp,
            topEnd = 32.dp,
            bottomEnd = 0.dp,
            bottomStart = 0.dp
        )
    )
    {
        Content()
    }
}


@Composable
private fun BottomSheetContent(
    amoutToSend: Double,
    to: String,
    via: String,
    onConfirm: () -> Unit
) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp, vertical = 24.dp)
            .background(color = Color.White)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_bottom_sheet_drag_bar),
                contentDescription = "",
                tint = Color(0xffE0E2E5)
            )
        }
        ScreenHeader(
            text = "Confirm transfer",
            modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(24.dp),
            modifier = Modifier.padding(bottom = 32.dp)
        ) {
            BottomSheetRowInformation(
                label = "You’re sending",
                value = "$amoutToSend XOF",
                isAmountToSend = true
            )
            BottomSheetRowInformation(label = "To", value = to)
            BottomSheetRowInformation(
                label = "Via",
                value = "$via : +229 98 767 289"
            )
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 0.dp)
        ) {
            ActionConfirmButton(
                text = "Confirm",
                color = SecondaryGreen,
                onClick = { onConfirm() }
            )
        }

    }
}

@Composable
private fun BottomSheetRowInformation(
    label: String,
    value: String,
    isAmountToSend: Boolean? = false
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = label, style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 21.sp,
                fontFamily = FontFamily(Font(R.font.outfit_regular)),
                fontWeight = FontWeight(400),
                color = Color(0xFF7F8895),
            )
        )
        Text(
            text = value, style = TextStyle(
                fontSize = if (isAmountToSend == true) 18.sp else 16.sp,
                lineHeight = 24.sp,
                fontFamily = FontFamily(Font(R.font.outfit_regular)),
                fontWeight = if (isAmountToSend == true) FontWeight(600) else FontWeight(500),
                color = Color(0xFF00122C),
            )
        )
    }
}