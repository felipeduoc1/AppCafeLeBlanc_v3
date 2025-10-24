package com.example.appcafeleblanc.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect // <-- Importación necesaria
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.appcafeleblanc.viewmodels.UsuarioViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistroScreen(
    navController: NavController,
    viewModel: UsuarioViewModel = viewModel()
) {
    // 1. Observar el estado de la UI
    val estado by viewModel.estado.collectAsState()

    // =======================================================
    // NUEVO: Reacciona cuando el registro en el ViewModel es exitoso
    // =======================================================
    LaunchedEffect(estado.isRegisteredSuccessful) {
        if (estado.isRegisteredSuccessful) {
            // Limpia el estado de éxito y los inputs para la próxima vez
            viewModel.clearLoginState()

            // Navega al login
            navController.navigate("login") {
                // Esto es crucial: previene que el usuario vuelva al formulario de registro con 'Back'
                popUpTo("registro") { inclusive = true }
            }
        }
    }
    // =======================================================

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        // ... (Tu código de Text y OutlinedTextFields se mantiene sin cambios) ...

        // --- Título del Formulario ---
        Text(
            text = "Registro de Usuario",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // --- Campo Nombre ---
        OutlinedTextField(
            value = estado.nombre,
            onValueChange = viewModel::onNombreChange,
            label = { Text("Nombre") },
            isError = estado.errores.nombre != null,
            supportingText = {
                estado.errores.nombre?.let {
                    Text(it, color = MaterialTheme.colorScheme.error)
                }
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = !estado.isLoading // Deshabilitar mientras carga
        )

        // --- Campo Correo ---
        OutlinedTextField(
            value = estado.correo,
            onValueChange = viewModel::onCorreoChange,
            label = { Text("Correo") },
            isError = estado.errores.correo != null,
            supportingText = {
                estado.errores.correo?.let {
                    Text(it, color = MaterialTheme.colorScheme.error)
                }
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = !estado.isLoading // Deshabilitar mientras carga
        )

        // --- Campo Clave ---
        OutlinedTextField(
            value = estado.clave,
            onValueChange = viewModel::onClaveChange,
            label = { Text("Clave") },
            visualTransformation = PasswordVisualTransformation(),
            isError = estado.errores.clave != null,
            supportingText = {
                estado.errores.clave?.let {
                    Text(it, color = MaterialTheme.colorScheme.error)
                }
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = !estado.isLoading // Deshabilitar mientras carga
        )

        // --- Campo Dirección ---
        OutlinedTextField(
            value = estado.direccion,
            onValueChange = viewModel::onDireccionChange,
            label = { Text("Dirección") },
            isError = estado.errores.direccion != null,
            supportingText = {
                estado.errores.direccion?.let {
                    Text(it, color = MaterialTheme.colorScheme.error)
                }
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = !estado.isLoading // Deshabilitar mientras carga
        )

        // --- Checkbox de Términos y Condiciones ---
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = estado.aceptaTerminos,
                onCheckedChange = viewModel::onAceptarTerminosChange,
                enabled = !estado.isLoading // Deshabilitar mientras carga
            )
            Spacer(Modifier.width(8.dp))
            Text("Acepto los términos y condiciones")
        }

        // --- Botón de Envío (MODIFICADO) ---
        Button(
            // =======================================================
            onClick = {
                // Llama al método del ViewModel que valida y luego simula el registro.
                viewModel.registrarUsuarioSimulado()
            },
            // =======================================================
            modifier = Modifier.fillMaxWidth(),
            // Deshabilitar si está cargando O si no acepta términos
            enabled = !estado.isLoading && estado.aceptaTerminos
        ) {
            // =======================================================
            // Mostrar un indicador de carga si está procesando
            if (estado.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(24.dp),
                    color = MaterialTheme.colorScheme.onPrimary
                )
            } else {
                Text("Registrar")
            }
            // =======================================================
        }
    }
}