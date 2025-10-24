package com.example.appcafeleblanc.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.lifecycle.viewmodel.compose.viewModel // <-- IMPORTANTE
import com.example.appcafeleblanc.viewmodels.UsuarioViewModel // <-- IMPORTANTE

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navController: NavController,
    // CAMBIO CLAVE: Quita '= viewModel()' para forzar la inyección del NavGraph
    viewModel: UsuarioViewModel
) {
    // 1. OBTENER EL ESTADO DESDE EL VIEWMODEL
    val uiState by viewModel.estado.collectAsState()

    // 2. EFECTO PARA NAVEGACIÓN EXITOSA
    LaunchedEffect(uiState.isLoginSuccessful) {
        if (uiState.isLoginSuccessful) {
            // Limpiar el estado de éxito para evitar re-navegación
            viewModel.clearLoginState()
            // Navegar a la pantalla principal
            navController.navigate("home") {
                // Limpia la pila para que no se pueda volver al login con el botón de atrás
                popUpTo("login") { inclusive = true }
            }
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

            // =================================================
            // Usar el estado y las funciones del ViewModel
            // =================================================
            OutlinedTextField(
                value = uiState.correo,
                onValueChange = { viewModel.onCorreoChange(it) }, // Usar onCorreoChange
                label = { Text("Correo electrónico") },
                modifier = Modifier.fillMaxWidth(),
                enabled = !uiState.isLoading // Deshabilitar si está cargando
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = uiState.clave,
                onValueChange = { viewModel.onClaveChange(it) }, // Usar onClaveChange
                label = { Text("Contraseña") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
                enabled = !uiState.isLoading // Deshabilitar si está cargando
            )
            // =================================================

            Spacer(modifier = Modifier.height(16.dp))

            // MOSTRAR ERROR DE LOGIN
            uiState.loginError?.let { error ->
                Text(
                    text = error,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall
                )
                Spacer(modifier = Modifier.height(8.dp))
            }

            Button(
                onClick = {
                    viewModel.login() // Llamar a la función de login del ViewModel
                },
                modifier = Modifier.fillMaxWidth(),
                // Deshabilitar si está cargando o si los campos están vacíos
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

            TextButton(
                onClick = {
                    // Asegúrate de que "registro" es la ruta correcta en tu NavGraph.kt
                    navController.navigate("registro")
                }
            ) {
                Text("¿No tienes cuenta? Regístrate aquí")
            }
        }
    }
}