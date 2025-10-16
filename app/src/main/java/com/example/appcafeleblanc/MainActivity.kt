package com.example.appcafeleblanc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.appcafeleblanc.ui.navigation.AppNavGraph
import com.example.appcafeleblanc.ui.theme.AppCafeLeBlancTheme

/**
 * Actividad principal que inicializa la aplicación.
 * Usa Jetpack Compose y Navigation para moverse entre pantallas.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            AppCafeLeBlancTheme {
                MainApp()
            }
        }
    }
}

/**
 * Punto central de la app donde se inicializa el controlador de navegación.
 */
@Composable
fun MainApp() {
    val navController = rememberNavController()
    AppNavGraph(navController = navController)
}
