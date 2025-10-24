package com.example.appcafeleblanc.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appcafeleblanc.viewmodels.UsuarioViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResumenScreen(
    // Reutilizamos el mismo ViewModel (gracias al NavHost) para acceder al estado
    viewModel: UsuarioViewModel = viewModel()
) {
    // 1. Observar el estado de la UI (contiene los datos del registro)
    val estado by viewModel.estado.collectAsState()

    Column(Modifier.padding(16.dp)) {

        // Título del resumen
        Text(
            text = "Resumen del registro",
            style = MaterialTheme.typography.headlineMedium
        )

        // 2. Mostrar los datos inmutables del estado

        // Nombre
        Text("Nombre: ${estado.nombre}")

        // Correo
        Text("Correo: ${estado.correo}")

        // Dirección
        Text("Dirección: ${estado.direccion}")

        // Contraseña (Ocultada con asteriscos)
        // La expresión String.repeat(length) crea una cadena de *s.
        Text("Contraseña: ${"*".repeat(estado.clave.length)}")

        // Términos Aceptados (Lógica condicional)
        Text(
            text = "¿Términos Aceptados? ${
                if (estado.aceptaTerminos) "Aceptados" else "Declinados"
            }"
        )
    }
}