package com.example.remitconnect.presentation.recipients

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.remitconnect.R
import com.example.remitconnect.presentation.common.ScreenHeader
import com.example.remitconnect.presentation.nav.BottomBarScreen
import com.example.remitconnect.presentation.recipients.components.NewContacts
import com.example.remitconnect.presentation.recipients.components.OldRecipiantContainer
import com.example.remitconnect.presentation.recipients.components.SwitchButton
import com.example.remitconnect.presentation.sendMoneyOptions.components.CustomAppBar
import com.example.remitconnect.presentation.theme.ui.theme.SecondaryGreen


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun RecipientsScreen(
    navHostController: NavHostController,
    viewModel: RecipientsViewModel = hiltViewModel()
) {

    val oldRecipientsButtonIsActive = viewModel.oldParticipantButtonIsActive
    val newRecipientButtonIsActive = viewModel.newParticipantButtonIsActive

    val recipientsState = viewModel.recipientsState.value
    val countriesState = viewModel.countriesState.value
    println(countriesState.countries)

    val searchText by viewModel.searchText.collectAsState()
    val recipient by viewModel.recipients.collectAsState()
    val isSearching by viewModel.isSearching.collectAsState()

    val listState = rememberLazyListState()

    Scaffold(
        backgroundColor = Color.White,
        topBar = {
            CustomAppBar(
                onClick = { navHostController.popBackStack() },
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
                    .clickable { navHostController.navigate(BottomBarScreen.WalletOptions.route) }

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
            verticalArrangement = Arrangement.Center,
        ) {

            ScreenHeader(
                text = "Who are you sending to?",
                modifier = Modifier.padding(horizontal = 24.dp)
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth(),
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(
                        0.dp,
                        Alignment.CenterHorizontally
                    ),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .background(
                            color = Color(0xFFEDF8F5),
                            shape = RoundedCornerShape(size = 8.dp)
                        )

                ) {
                    SwitchButton(
                        title = "Previous recipients",
                        oldRecipientsButtonIsActive,
                        onClick = { viewModel.updateParticipantToOld() })
                    SwitchButton(
                        title = "New recipient",
                        newRecipientButtonIsActive,
                        onClick = { viewModel.updateParticipantToNew() })
                }
                OutlinedTextField(
                    shape = RoundedCornerShape(12.dp),
                    value = searchText,
                    onValueChange = viewModel::onSearchTextChange,
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = SecondaryGreen,
                        unfocusedBorderColor = Color(0xffBFC3CA),
                        cursorColor = SecondaryGreen
                    ),
                    enabled = oldRecipientsButtonIsActive,
                    placeholder = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                modifier = Modifier.padding(top = 3.dp),
                                text = "Search ...",
                                style = MaterialTheme.typography.body2,
                                color = Color(0xFF7F8895),
                            )
                        }

                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_search),
                            contentDescription = "search icon",
                            tint = Color(0xFF7F8895)
                        )
                    }
                )

            }
            LazyColumn(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,

                ) {

                if (oldRecipientsButtonIsActive) {
                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(24.dp),
                        ) {
                            Text(
                                text = "Contacts on your phone",
                                style = MaterialTheme.typography.h3,
                            )
                        }
                    }
                    if (recipientsState.isLoading) {
                        item {
                            CircularProgressIndicator(color = SecondaryGreen)
                        }
                    }
                    if (recipientsState.error.isNotBlank()) {
                        item {
                            Text(text = recipientsState.error)
                        }
                    }
                    items(recipient) { recipient ->
                        OldRecipiantContainer(
                            name = recipient.name,
                            onClick = { navHostController.navigate(BottomBarScreen.WalletOptions.route) }
                        )
                    }

                    if (isSearching && searchText.isNotBlank() && recipient.isEmpty()) {
                        item {
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_not_found),
                                    contentDescription = "",
                                    tint = SecondaryGreen
                                )
                            }
                            Text(
                                text = "No matching results found !",
                                fontSize = 18.sp,
                                lineHeight = 27.sp,
                                fontWeight = FontWeight(500),
                                fontFamily = FontFamily(Font(R.font.outfit_regular)),
                                textAlign = TextAlign.Center,
                                color = Color(0xFF404D61),
                            )
                        }
                    }
                } else {
                    item {
                        LazyColumn(
                            modifier = Modifier
                                .height(700.dp)
                                .padding(20.dp)
                        ) {
                            item { NewContacts(countriesState.countries) }
                        }
                    }
                }
            }

        }
    }

}



