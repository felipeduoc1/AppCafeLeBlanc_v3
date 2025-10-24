package com.example.appcafeleblanc.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

// --- ESQUEMA DE COLOR OSCURO (DarkColorScheme) ---
// Base: Negro Tinta (Sumi) con acentos de Matcha y Sakura
private val DarkColorScheme = darkColorScheme(
    // Colores Principales del Tema Oscuro
    primary = VerdeMatcha,             // Color principal (botones, iconos activos)
    secondary = MarronTostado,        // Color secundario (acentos, elementos menos prominentes)
    tertiary = RosaSakura,            // Color terciario (destacados, notificaciones)

    // Fondo y Superficie
    background = NegroTinta,          // Fondo de la pantalla
    surface = CafeEspresso,           // Superficie de cards, diálogos, etc.

    // Colores "On" (Texto e Iconos)
    onPrimary = BlancoWashi,          // Texto sobre VerdeMatcha
    onSecondary = BlancoWashi,        // Texto sobre MarronTostado
    onTertiary = NegroTinta,          // Texto sobre RosaSakura
    onBackground = BlancoWashi,       // Texto sobre NegroTinta
    onSurface = BlancoWashi,          // Texto sobre CafeEspresso
)

// --- ESQUEMA DE COLOR CLARO (LightColorScheme) ---
// Base: Blanco Washi con acentos de Matcha y Marrón
private val LightColorScheme = lightColorScheme(
    // Colores Principales del Tema Claro
    primary = VerdeMatcha,            // Color principal (botones, iconos activos)
    secondary = MarronTostado,        // Color secundario (acentos, elementos menos prominentes)
    tertiary = RosaSakura,            // Color terciario (destacados, notificaciones)

    // Fondo y Superficie
    background = BlancoWashi,         // Fondo de la pantalla
    surface = BeigeCrema,             // Superficie de cards, diálogos, etc.

    // Colores "On" (Texto e Iconos)
    onPrimary = NegroTinta,           // Texto sobre VerdeMatcha
    onSecondary = BlancoWashi,        // Texto sobre MarronTostado
    onTertiary = NegroTinta,          // Texto sobre RosaSakura
    onBackground = NegroTinta,        // Texto sobre BlancoWashi
    onSurface = NegroTinta,           // Texto sobre BeigeCrema
)

@Composable
fun AppCafeLeBlancTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Desactivamos el color dinámico por defecto para asegurar que se usen nuestros colores
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        // Opción para mantener el color dinámico si es necesario, aunque generalmente se desactiva con un tema de marca.
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    // --- Configuración de la Barra de Estado y Navegación (Opcional pero recomendado) ---
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            // Configura el color de la barra de estado y el color del contenido (claro u oscuro)
            window.statusBarColor = colorScheme.surface.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    // --- Aplicación del Tema Material 3 ---
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography, // Asume que tienes un archivo Typography.kt
        content = content
    )
}