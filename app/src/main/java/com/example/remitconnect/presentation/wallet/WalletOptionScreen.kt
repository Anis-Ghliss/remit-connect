package com.example.remitconnect.presentation.wallet

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.remitconnect.presentation.common.ScreenHeader
import com.example.remitconnect.presentation.sendMoneyOptions.components.CustomAppBar
import com.example.remitconnect.presentation.theme.ui.theme.SecondaryGreen
import com.example.remitconnect.presentation.wallet.components.WalletItemContainer
import com.example.remitconnect.R
import com.example.remitconnect.presentation.nav.BottomBarScreen
import com.example.remitconnect.presentation.theme.ui.theme.PaleGreen
import java.util.*

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun WalletOptionScreen(
    navController: NavHostController,
    viewModel: WalletViewModel = hiltViewModel()
) {
    val walletList = viewModel.walletsState.value
    val selectedWallet = viewModel.selectedItem


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
                    .clickable { navController.navigate(BottomBarScreen.ConfirmSendMoney.route) }

            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 24.dp, top = 16.dp, end = 24.dp, bottom = 16.dp)
                        .background(color = SecondaryGreen, shape = RoundedCornerShape(16.dp))

                ) {
                    Text(
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        text = "Continue",
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight(600),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 12.dp)
                    )
                }
            }
        }
    ) {

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            ScreenHeader(
                text = "Choose a mobile wallet",
                modifier = Modifier.padding(horizontal = 24.dp)
            )

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxSize()
            ) {
                itemsIndexed(walletList.wallets) { index, wallet ->
                    WalletItemContainer(
                        index = index,
                        wallet = wallet,
                        selectedWalletIndex = selectedWallet,
                        onWalletSelected = { viewModel.onSelectWallet.invoke(index) },
                        Image = { GetWalletImage(wallet.name) }
                    )
                }
            }

        }
    }
}


@Composable
private fun GetWalletImage(walletType: String): Unit {
    return when (walletType) {
        "Wave" -> Image(painter = painterResource(id = R.drawable.wave), contentDescription = "")
        "Orange Money" -> Image(
            painter = painterResource(id = R.drawable.oraneg),
            contentDescription = ""
        )
        "CashPlus" -> Image(painter = painterResource(id = R.drawable.mtn), contentDescription = "")
        else ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp)
                    .background(
                        color = PaleGreen,
                        shape = RoundedCornerShape(size = 12.dp)
                    )
                    .padding(start = 12.dp, top = 12.dp, end = 12.dp, bottom = 12.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_nav_credit_card),
                    contentDescription = "",
                    tint = SecondaryGreen
                )
            }


    }
}