// Contenido FINAL y CORREGIDO para: screens/LoginScreen.kt

package com.example.appcafeleblanc.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.appcafeleblanc.viewmodels.UsuarioViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: UsuarioViewModel
) {
    // 1. Obtiene el estado de la UI desde el ViewModel.
    val uiState by viewModel.estado.collectAsState()

    // 2. Efecto para manejar la navegación UNA SOLA VEZ cuando el login es exitoso.
    LaunchedEffect(uiState.isLoginSuccessful) {
        if (uiState.isLoginSuccessful) {
            // Navega a la pantalla principal.
            navController.navigate("home") {
                // Limpia la pila de navegación para que el usuario no pueda
                // volver a la pantalla de login con el botón de "atrás".
                popUpTo("login") { inclusive = true }
            }
            // NOTA: Para una app más robusta, aquí llamarías a una función
            // en el ViewModel para "consumir" el evento de login exitoso
            // y evitar re-navegaciones accidentales.
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Iniciar Sesión") })
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Bienvenido a Café Le Blanc ☕",
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(modifier = Modifier.height(24.dp))

            // --- Campo de Correo ---
            OutlinedTextField(
                value = uiState.correo,
                onValueChange = { viewModel.onCorreoChange(it) }, // Llama a la función del ViewModel
                label = { Text("Correo electrónico") },
                modifier = Modifier.fillMaxWidth(),
                enabled = !uiState.isLoading, // Se deshabilita durante la carga
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            // --- Campo de Contraseña ---
            OutlinedTextField(
                value = uiState.clave,
                onValueChange = { viewModel.onClaveChange(it) }, // Llama a la función del ViewModel
                label = { Text("Contraseña") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
                enabled = !uiState.isLoading, // Se deshabilita durante la carga
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            // --- Muestra de Errores ---
            uiState.loginError?.let { error ->
                Text(
                    text = error,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall
                )
                Spacer(modifier = Modifier.height(8.dp))
            }

            // --- Botón de Ingreso ---
            Button(
                onClick = {
                    // CORRECCIÓN: Llamar a la función correcta del ViewModel
                    viewModel.iniciarSesion()
                },
                modifier = Modifier.fillMaxWidth(),
                // Se habilita solo si no está cargando y los campos no están vacíos
                enabled = !uiState.isLoading && uiState.correo.isNotBlank() && uiState.clave.isNotBlank()
            ) {
                if (uiState.isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(24.dp),
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                } else {
                    Text("Ingresar")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // --- Botón para ir a Registro ---
            TextButton(
                onClick = {
                    // Navega a la ruta "registro" definida en tu NavGraph
                    navController.navigate("registro")
                }
            ) {
                Text("¿No tienes cuenta? Regístrate aquí")
            }
        }
    }
}
