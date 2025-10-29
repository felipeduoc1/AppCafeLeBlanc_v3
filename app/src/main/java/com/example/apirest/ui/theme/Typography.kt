package com.example.apirest.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Define la tipografía para todo el proyecto usando Material 3.
// Por defecto, se usa la fuente predeterminada (Default) de Android.
val Typography = Typography(

    // Títulos grandes, usados a menudo para encabezados de pantalla.
    headlineLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        lineHeight = 40.sp,
        letterSpacing = 0.sp
    ),

    // Títulos medianos, como el título principal de una card o lista.
    titleMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.15.sp
    ),

    // Cuerpo del texto, para la mayoría del contenido de la UI.
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),

    // Etiquetas (labels) para botones o textos pequeños.
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )

    /* Puedes definir más estilos si es necesario:
    titleLarge, bodyMedium, labelLarge, etc.
    Consulta la documentación de Material 3 para ver todos los estilos.
    */
)