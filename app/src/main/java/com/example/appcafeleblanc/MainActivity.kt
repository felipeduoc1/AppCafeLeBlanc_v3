package com.example.apirest // ⚠️ Asegúrate de cambiar el nombre del paquete

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat // Para Edge-to-Edge manual
import androidx.lifecycle.viewmodel.compose.viewModel // Importación clave para obtener el ViewModel
import com.example.apirest.ui.screens.PostScreen // Tu pantalla de Compose
import com.example.apirest.ui.theme.ApiRestTheme // Tu tema de Compose
import com.example.apirest.viewmodel.PostViewModel // Tu ViewModel

/**
 * Actividad principal que inicializa la aplicación.
 * Muestra la PostScreen y maneja la inyección del ViewModel.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. Configuración Edge-to-Edge: Permite dibujar contenido bajo las barras del sistema
        // Reemplaza a 'enableEdgeToEdge()' usado en versiones anteriores o proyectos sin Compose.
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            // 2. Aplicamos el tema de tu proyecto
            ApiRestTheme {
                // 3. Obtenemos (o creamos) el PostViewModel, que sobrevivirá a los cambios de configuración.
                val postViewModel: PostViewModel = viewModel()

                // 4. Llamamos a la pantalla principal, pasándole el ViewModel.
                PostScreen(viewModel = postViewModel)
            }
        }
    }
}