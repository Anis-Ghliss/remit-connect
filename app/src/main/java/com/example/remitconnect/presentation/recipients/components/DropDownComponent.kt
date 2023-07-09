package com.example.remitconnect.presentation.recipients.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import com.example.remitconnect.R
import com.example.remitconnect.domain.model.Country
import com.example.remitconnect.presentation.theme.ui.theme.SecondaryGreen

@Composable
fun DropDownComponent(listOfCountries: List<Country>) {
    var mExpanded by remember { mutableStateOf(false) }
    var mSelectedText by remember { mutableStateOf(listOfCountries[0].name) }
    var mTextFieldSize by remember { mutableStateOf(Size.Zero) }

    val icon = if (mExpanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown


    Column() {

        OutlinedTextField(
            value = "$mSelectedText ( +334 )",
            onValueChange = { mSelectedText = it },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    mTextFieldSize = coordinates.size.toSize()
                },
            enabled = false,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = SecondaryGreen,
                unfocusedBorderColor = Color(0xffBFC3CA),
                textColor = Color.Black,
                placeholderColor = Color.Black
            ),
            leadingIcon = {
                Icon(
                    modifier = Modifier.size(15.dp),
                    painter = painterResource(id = R.drawable.ic_drapeau_alt),

                    tint = SecondaryGreen,
                    contentDescription = "leading icon"
                )
            },
            trailingIcon = {
                Icon(
                    icon, "contentDescription",
                    Modifier.clickable { mExpanded = !mExpanded },
                    tint = SecondaryGreen,
                )
            }
        )

        DropdownMenu(
            expanded = mExpanded,
            onDismissRequest = { mExpanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current) { mTextFieldSize.width.toDp() })
        ) {
            listOfCountries.forEach { country ->
                DropdownMenuItem(onClick = {
                    mSelectedText = country.name
                    mExpanded = false
                }) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 12.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_drapeau_alt),
                                contentDescription = "flag",
                                modifier = Modifier.size(15.dp),
                                tint = SecondaryGreen
                            )
                            Text(text = country.name, style = MaterialTheme.typography.body2)
                        }

                        Text(text = "+334", style = MaterialTheme.typography.body2)
                    }

                }
            }
        }
    }
}