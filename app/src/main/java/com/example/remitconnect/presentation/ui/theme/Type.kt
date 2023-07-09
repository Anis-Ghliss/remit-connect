package com.example.remitconnect.presentation.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.remitconnect.R

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    h1 = TextStyle(
        fontFamily = FontFamily(Font(R.font.outfit_regular)),
        fontWeight = FontWeight(600),
        fontSize = 24.sp,
        color = Color(0xFF00122C)
    ),

    button = TextStyle(
        fontFamily = FontFamily(Font(R.font.outfit_regular)),
        fontWeight = FontWeight(600),
        fontSize = 14.sp,
    ),

    body2 = TextStyle(
        fontFamily = FontFamily(Font(R.font.outfit_regular)),
        fontWeight = FontWeight(600),
        fontSize = 14.sp,
    ),

    h2 = TextStyle(
        fontFamily = FontFamily(Font(R.font.outfit_regular)),
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = FontFamily(Font(R.font.outfit_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    h3 = TextStyle(
        fontFamily = FontFamily(Font(R.font.outfit_regular)),
        fontSize = 16.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight(400),
        color = Color(0xFF00122C),

        ),


    )