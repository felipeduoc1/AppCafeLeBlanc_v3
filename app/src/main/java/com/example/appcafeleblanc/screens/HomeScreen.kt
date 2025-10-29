package com.example.appcafeleblanc.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor // ⭐ IMPORTACIÓN CORREGIDA
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
//import com.example.appcafeleblanc.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Café Le Blanc",
                        style = MaterialTheme.typography.headlineSmall.copy(
                            fontWeight = FontWeight.Bold
                        )
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent,
                    titleContentColor = MaterialTheme.colorScheme.onBackground
                )
            )
        },
        containerColor = MaterialTheme.colorScheme.background // Fondo oscuro
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // --- 1. SECCIÓN PRINCIPAL (HERO/IMAGEN DE FONDO) ---
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp)
            ) {
//                Image(
//                    // ⚠️ Asegúrate de que R.drawable.logo sea tu imagen principal del café
//                    painter = painterResource(id = R.drawable.logo),
//                    contentDescription = "Fondo del Café",
//                    contentScale = ContentScale.Crop,
//                    modifier = Modifier.fillMaxSize()
//                )
                // Overlay de color sutil para oscurecer la imagen
                Spacer(modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.2f))
                )

            }

            // --- 2. SECCIÓN DE BOTONES (TARJETA FLOTANTE) ---
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = (-40).dp) // Efecto flotante
                    .padding(horizontal = 24.dp),
                shape = MaterialTheme.shapes.large,
                color = MaterialTheme.colorScheme.surface,
                shadowElevation = 8.dp
            ) {
                Column(
                    modifier = Modifier
                        .padding(vertical = 24.dp, horizontal = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    // Botón Principal: Ver Productos (Rojo LeBlanc)
                    Button(
                        onClick = { navController.navigate("productos") },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                            contentColor = MaterialTheme.colorScheme.onPrimary
                        ),
                        contentPadding = PaddingValues(vertical = 14.dp)
                    ) {
                        Text("Ver Menú Completo", style = MaterialTheme.typography.labelLarge)
                    }

                    // Botón Secundario: Ver Carrito (Contorno)
                    OutlinedButton(
                        onClick = { navController.navigate("carrito") },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = MaterialTheme.colorScheme.onPrimary
                        ),
                        border = ButtonDefaults.outlinedButtonBorder.copy(
                            // Usa SolidColor para el borde
                            brush = SolidColor(MaterialTheme.colorScheme.primary)
                        ),
                        contentPadding = PaddingValues(vertical = 14.dp)
                    ) {
                        Text("Ver Carrito 🛒", style = MaterialTheme.typography.labelLarge)
                    }

                    Divider(
                        modifier = Modifier.padding(vertical = 8.dp),
                        color = MaterialTheme.colorScheme.outlineVariant
                    )

                    // Fila de Navegación Rápida
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        QuickNavLink(text = "Nosotros", onClick = { navController.navigate("nosotros") })
                        QuickNavLink(text = "Contacto", onClick = { navController.navigate("contacto") })
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Botones de Sesión y Registro (parte inferior)
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Login (Color Terciario: Azul Eléctrico)
                TextButton(onClick = { navController.navigate("login") }) {
                    Text("Iniciar Sesión", color = MaterialTheme.colorScheme.tertiary)
                }
                // Registro (Color Secundario: Vino Oscuro)
                TextButton(onClick = { navController.navigate("registro") }) {
                    Text("Registrarse", color = MaterialTheme.colorScheme.secondary)
                }
                // NUEVO BOTÓN: VER RESUMEN
                TextButton(onClick = { navController.navigate("resumen") }) {
                    // Usamos un color distinto (onSurfaceVariant) para que no compita
                    Text("Resumen", color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f))
                }

            }
        }
    }
}

// Composable helper para enlaces rápidos (TextButton)
@Composable
fun QuickNavLink(text: String, onClick: () -> Unit) {
    TextButton(onClick = onClick) {
        Text(
            text,
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}