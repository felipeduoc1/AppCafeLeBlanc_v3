package com.example.appcafeleblanc.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// --- FUENTES ---
// Se recomienda usar fuentes personalizadas como Noto Sans Japanese,
// o M PLUS Rounded para una estética más auténtica.
// Por ahora, usaremos las familias por defecto:

// Fuente principal para cuerpos de texto y elementos de UI (limpia y legible)
val BodyFontFamily = FontFamily.SansSerif

// Fuente para títulos, buscando un toque de distinción y elegancia (simulando un toque Serif o display)
val DisplayFontFamily = FontFamily.Serif


// --- ESTILOS DE TIPOGRAFÍA PERSONALIZADOS ---
val Typography = Typography(

    // Títulos grandes y llamativos (Branding, cabeceras principales)
    displayLarge = TextStyle(
        fontFamily = DisplayFontFamily,
        fontWeight = FontWeight.Bold, // Fuerte impacto
        fontSize = 57.sp,
        lineHeight = 64.sp,
        letterSpacing = (-0.25).sp
    ),

    // Títulos de secciones o elementos prominentes
    titleLarge = TextStyle(
        fontFamily = DisplayFontFamily,
        fontWeight = FontWeight.SemiBold, // Elegancia y peso
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),

    // Títulos secundarios o nombres de elementos en listas
    titleMedium = TextStyle(
        fontFamily = DisplayFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.15.sp
    ),

    // Cuerpo de texto principal (Legibilidad)
    bodyLarge = TextStyle(
        fontFamily = BodyFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),

    // Cuerpo de texto secundario (Descripciones pequeñas)
    bodyMedium = TextStyle(
        fontFamily = BodyFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.25.sp
    ),

    // Etiquetas y texto en botones (Enfocado y legible)
    labelLarge = TextStyle(
        fontFamily = BodyFontFamily,
        fontWeight = FontWeight.Medium, // Un poco más de peso
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    )
)