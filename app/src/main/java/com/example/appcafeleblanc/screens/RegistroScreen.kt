// Contenido corregido y simplificado para: /screens/RegistroScreen.kt

package com.example.appcafeleblanc.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField // Usando el TextField básico
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.appcafeleblanc.viewmodels.UsuarioViewModel

@Composable
fun RegistroScreen(
    navController: NavHostController,
    usuarioViewModel: UsuarioViewModel
) {
    // Observamos el estado desde el ViewModel
    val uiState by usuarioViewModel.estado.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Crear una Cuenta")
        Spacer(modifier = Modifier.height(24.dp))

        // --- Campo de Texto para el Nombre ---
        TextField(
            value = uiState.nombre,
            onValueChange = { usuarioViewModel.onNombreChange(it) },
            label = { Text("Nombre Completo") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(8.dp))

        // --- Campo de Texto para el Correo ---
        TextField(
            value = uiState.correo,
            onValueChange = { usuarioViewModel.onCorreoChange(it) },
            label = { Text("Correo Electrónico") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            // Marca el campo si hay error (sin requerir UsuarioErrores)
            isError = uiState.loginError?.contains("correo", ignoreCase = true) == true
        )
        Spacer(modifier = Modifier.height(8.dp))

        // --- Campo de Texto para la Contraseña ---
        TextField(
            value = uiState.clave,
            onValueChange = { usuarioViewModel.onClaveChange(it) },
            label = { Text("Contraseña") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            // Marca el campo si hay error (sin requerir UsuarioErrores)
            isError = uiState.loginError?.contains("credenciales", ignoreCase = true) == true
        )
        Spacer(modifier = Modifier.height(16.dp))

        // --- Botón de Registro ---
        Button(
            onClick = {
                usuarioViewModel.registrarUsuarioSimulado()
            },
            enabled = !uiState.isLoading, // Se deshabilita mientras carga
            modifier = Modifier.fillMaxWidth()
        ) {
            if (uiState.isLoading) {
                CircularProgressIndicator(modifier = Modifier.size(24.dp))
            } else {
                Text("Registrarse")
            }
        }

        // --- Mensaje de Error General ---
        uiState.loginError?.let { error ->
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = error,
                color = Color.Red
            )
        }

        // --- Mensaje de Éxito ---
        if (uiState.isRegisteredSuccessful) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "¡Registro exitoso! Ahora puedes iniciar sesión.",
                color = Color(0xFF008000) // Verde
            )
        }
    }
}
