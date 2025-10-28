package com.example.appcafeleblanc.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appcafeleblanc.viewmodels.UsuarioViewModel
import androidx.navigation.NavController // Añadir NavController si planeas un botón de "Volver"
// ... otras importaciones ...

// Importaciones necesarias para los iconos:
import androidx.compose.material.icons.filled.Email // Para el correo
import androidx.compose.material.icons.filled.LocationOn // Para la dirección
import androidx.compose.material.icons.filled.Lock // Para la contraseña (Lock)
import androidx.compose.material.icons.filled.Person // Si usaste el icono Person

// ... (El resto de tus imports) ...

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResumenScreen(
    navController: NavController, // Añadir NavController para navegación
    viewModel: UsuarioViewModel = viewModel()
) {
    val estado by viewModel.estado.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Resumen de Cuenta") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent,
                    titleContentColor = MaterialTheme.colorScheme.onBackground
                )
            )
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {

            // --- TÍTULO PRINCIPAL ---
            Text(
                text = "Registro Exitoso",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary, // Resaltado con el color primario
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // --- TARJETA DE RESUMEN DE DATOS ---
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.large,
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant // Color de superficie más claro
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    // Nombre
                    ResumenItem(
                        icon = Icons.Default.Person,
                        label = "Nombre de Usuario",
                        value = estado.nombre
                    )

                    Divider(color = MaterialTheme.colorScheme.outlineVariant)

                    // Correo
                    ResumenItem(
                        icon = Icons.Default.Email,
                        label = "Correo Electrónico",
                        value = estado.correo
                    )

                    // Dirección
                    ResumenItem(
                        icon = Icons.Default.LocationOn,
                        label = "Dirección de Envío",
                        value = estado.direccion
                    )

                    // Contraseña (Ocultada)
                    ResumenItem(
                        icon = Icons.Default.Lock, // Asumo que tienes el icono Lock
                        label = "Clave (Oculta)",
                        value = estado.clave.replace(Regex("."), "*") // Usa .replace para ocultar
                    )
                }
            }

            // --- ACEPTACIÓN DE TÉRMINOS (Destacado) ---
            AceptacionItem(estado.aceptaTerminos)

            Spacer(modifier = Modifier.height(16.dp))

            // --- BOTÓN DE NAVEGACIÓN ---
            Button(
                onClick = { navController.navigate("home") },
                modifier = Modifier.fillMaxWidth(0.8f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.tertiary, // Usar el acento eléctrico
                    contentColor = MaterialTheme.colorScheme.onTertiary
                )
            ) {
                Text("Ir a la Home")
            }
        }
    }
}

// Helper para mostrar cada campo del resumen
@Composable
fun ResumenItem(icon: ImageVector, label: String, value: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.secondary,
            modifier = Modifier.size(24.dp).padding(end = 8.dp)
        )
        Column {
            Text(
                text = label,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = value,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

// Helper para el estado de aceptación de términos
@Composable
fun AceptacionItem(acepta: Boolean) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (acepta) Color(0xFF1E88E5) else MaterialTheme.colorScheme.errorContainer // Azul o Rojo de error
        ),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = if (acepta) Icons.Default.CheckCircle else Icons.Default.Close,
                contentDescription = null,
                tint = if (acepta) Color.White else MaterialTheme.colorScheme.onErrorContainer,
                modifier = Modifier.size(24.dp).padding(end = 8.dp)
            )
            Text(
                text = if (acepta) "Términos y Condiciones ACEPTADOS" else "Términos NO ACEPTADOS",
                color = if (acepta) Color.White else MaterialTheme.colorScheme.onErrorContainer,
                fontWeight = FontWeight.Bold
            )
        }
    }
}