package com.example.remitconnect.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.remitconnect.R
import com.example.remitconnect.presentation.theme.ui.theme.PaleGreen

@Preview
@Composable
fun ActionsContainer() {

        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
            ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.Start),
                verticalAlignment = Alignment.Top,
            ) {
                ActionContainerItem(actionTitle = "Top up balance") {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_empty_wallet_add),
                        contentDescription = "bell icon",
                        tint = Color.Unspecified,
                    )
                }

                ActionContainerItem(actionTitle = "Withdraw money") {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_wallet_minus),
                        contentDescription = "bell icon",
                        tint = Color.Unspecified,
                    )
                }
            }
            Spacer(modifier = Modifier.size(16.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.Start),
                verticalAlignment = Alignment.Top,
            ) {
                ActionContainerItem(actionTitle = "Get IBAN") {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_card),
                        contentDescription = "bell icon",
                        tint = Color.Unspecified,
                    )
                }

                ActionContainerItem(actionTitle = "View analytics") {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_percentage_square),
                        contentDescription = "bell icon",
                        tint = Color.Unspecified,
                    )
                }
            }
        }
    }




@Composable
private fun ActionContainerItem(
    actionTitle: String,
    ActionIcon: @Composable() () -> Unit
) {
    Box(
        modifier = Modifier
            .shadow(
                elevation = 20.dp,
            )
            .width(180.dp)
            .height(101.dp)
            .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 16.dp))
            .padding(16.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp)
                    .background(color = PaleGreen, shape = RoundedCornerShape(size = 12.dp))
            ) {
                ActionIcon()
            }

            Text(
                text = actionTitle,
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.outfit_regular)),
                fontWeight = FontWeight(500),
                color = Color(0xFF007554)
            )

        }
    }
}