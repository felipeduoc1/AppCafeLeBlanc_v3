package com.example.appcafeleblanc.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

// =================================================================
// 1. ESQUEMA DE COLOR OSCURO: Estilo "LeBlanc"
// =================================================================
private val DarkColorScheme = darkColorScheme(
    // Colores Primarios
    primary = RojoLeBlanc,       // Rojo Vino (Botones principales, acento fuerte)
    onPrimary = BlancoLeBlanc,   // Texto blanco sobre el Rojo Vino
    primaryContainer = VinoOscuro, // Versión más oscura del primario
    onPrimaryContainer = BlancoLeBlanc,

    // Colores Secundarios
    secondary = VinoOscuro,      // Marrón/Vino Oscuro (Botones secundarios, divisor)
    onSecondary = BlancoLeBlanc,
    secondaryContainer = Color(0xFF333333), // Gris oscuro para contenedores sutiles
    onSecondaryContainer = GrisLeBlanc,

    // Colores Terciarios (Acento de alta visibilidad)
    tertiary = AzulLeBlanc,      // Azul Eléctrico (Enlaces, login/registro)
    onTertiary = BlancoLeBlanc,

    // Colores de Superficie y Fondo (Para el look oscuro general)
    background = NegroLeBlanc,   // Negro Carbón (Fondo principal, muy oscuro)
    onBackground = BlancoLeBlanc,// Texto principal blanco

    surface = NegroLeBlanc,      // Contenedores/Superficies (igual al fondo para uniformidad)
    onSurface = GrisLeBlanc,     // Texto en superficies
    surfaceVariant = Color(0xFF2C2C2C), // Superficie variante, ligeramente más clara
    onSurfaceVariant = GrisLeBlanc,

    // Otros colores de utilidad
    error = Color(0xFFCF6679), // Rojo de error estándar
    onError = Color.Black,
    outline = GrisPiedra         // Borde o divisor suave
)

// =================================================================
// 2. ESQUEMA DE COLOR CLARO: Estilo "Café Tradicional"
// =================================================================
private val LightColorScheme = lightColorScheme(
    // Colores Primarios
    primary = VerdeMatcha,       // Verde Matcha (Acento principal)
    onPrimary = BlancoWashi,
    primaryContainer = CarameloClaro,
    onPrimaryContainer = NegroTinta,

    // Colores Secundarios
    secondary = MarronTostado,   // Marrón Tostado
    onSecondary = BlancoWashi,
    secondaryContainer = BeigeCrema,
    onSecondaryContainer = NegroTinta,

    // Colores Terciarios
    tertiary = RosaSakura,       // Rosa Sakura
    onTertiary = NegroTinta,

    // Colores de Superficie y Fondo
    background = GrisClaroFondo, // Gris claro para fondo
    onBackground = NegroTinta,   // Texto negro principal

    surface = BlancoWashi,       // Superficie principal
    onSurface = NegroTinta,      // Texto en superficie
    surfaceVariant = BordeSuave,
    onSurfaceVariant = NegroTinta,

    // Otros
    error = Color(0xFFB00020),
    onError = BlancoWashi
)

// =================================================================
// 3. COMPOSABLE DEL TEMA
// =================================================================
@Composable
fun AppCafeLeBlancTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Deshabilita el color dinámico por defecto para forzar el uso de la paleta LeBlanc
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    // Seleccionamos el esquema de color basándonos en el modo del sistema
    val colorScheme = when {
        // Opción 1: Color Dinámico (Solo en Android S+)
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        // Opción 2: Usar el tema Oscuro "LeBlanc" (Recomendado para el look moderno)
        darkTheme -> DarkColorScheme
        // Opción 3: Usar el tema Claro "Café Tradicional"
        else -> LightColorScheme
    }

    // Usamos el tema de Material 3
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography, // Asumo que tienes un archivo Typography.kt
        content = content
    )
}