package com.example.appcafeleblanc.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val BodyFontFamily = FontFamily.SansSerif
val DisplayFontFamily = FontFamily.Serif

val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = DisplayFontFamily,
        fontWeight = FontWeight.Black, // AGREGADO: más fuerte para coincidir con el logo
        fontSize = 57.sp,
        lineHeight = 64.sp,
        letterSpacing = (-0.25).sp
    ),
    titleLarge = TextStyle(
        fontFamily = DisplayFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        lineHeight = 30.sp
    ),
    titleMedium = TextStyle(
        fontFamily = DisplayFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = 22.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = BodyFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = BodyFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    labelLarge = TextStyle(
        fontFamily = BodyFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    )
)

// AGREGADO: Estilos extra
val PriceTextStyle = TextStyle(
    fontFamily = DisplayFontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 20.sp
)

val ButtonTextStyle = TextStyle(
    fontFamily = BodyFontFamily,
    fontWeight = FontWeight.SemiBold,
    fontSize = 16.sp
)

val SubtitleTextStyle = TextStyle(
    fontFamily = DisplayFontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 14.sp
)
