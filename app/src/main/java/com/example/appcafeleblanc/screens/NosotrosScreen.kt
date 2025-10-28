package com.example.appcafeleblanc.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.material.icons.filled.Star // Icono de ejemplo
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NosotrosScreen(navController: NavController) {

    // Usamos el color de fondo para el tema oscuro
    val backgroundColor = MaterialTheme.colorScheme.background

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Nuestra Historia") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Volver"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent,
                    titleContentColor = MaterialTheme.colorScheme.onBackground
                )
            )
        },
        containerColor = backgroundColor
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()), // Habilitamos el scroll
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // --- 1. SECCIÓN HERO (TITULO GRANDE) ---
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primaryContainer) // Usa un color relacionado con el tema
                    .padding(vertical = 40.dp, horizontal = 20.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Column {
                    Text(
                        text = "La Identidad",
                        style = MaterialTheme.typography.displaySmall,
                        fontWeight = FontWeight.Light,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                    Text(
                        text = "De Cada Taza",
                        style = MaterialTheme.typography.displayMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // --- 2. CONTENIDO PRINCIPAL (DENTRO DE UNA CARD) ---
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface // Color de superficie oscuro
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp) // Gran elevación
            ) {
                Column(modifier = Modifier.padding(24.dp)) {
                    Text(
                        text = "Nuestra Filosofía",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "En Café Le Blanc creemos en el arte de preparar un buen café. Nuestra misión es ofrecer experiencias únicas a través del aroma, el sabor y la calidez de nuestros espacios. Somos más que una cafetería, somos un refugio.",
                        textAlign = TextAlign.Justify,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    Spacer(modifier = Modifier.height(20.dp))
                    Divider(color = MaterialTheme.colorScheme.outlineVariant)
                    Spacer(modifier = Modifier.height(20.dp))

                    // --- VALORES DESTACADOS ---
                    ValoresSeccion(
                        titulo = "Granos Seleccionados",
                        descripcion = "Desde 2010, tostamos granos de origen único y trabajamos directamente con productores locales para asegurar la máxima calidad.",
                        icono = Icons.Default.Star
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    ValoresSeccion(
                        titulo = "Tradición y Calidez",
                        descripcion = "Mantenemos viva la tradición artesanal en cada método de preparación, sirviendo cada bebida con la calidez que nos define.",
                        icono = Icons.Default.Star
                    )
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            // --- 3. BOTÓN DE NAVEGACIÓN ---
            Button(
                onClick = { navController.popBackStack() }, // Usamos popBackStack para volver
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(bottom = 20.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.secondary,
                    contentColor = MaterialTheme.colorScheme.onSecondary
                )
            ) {
                Text("Explorar el Menú")
            }
        }
    }
}

// Composable Helper para mostrar valores con iconos
@Composable
fun ValoresSeccion(titulo: String, descripcion: String, icono: androidx.compose.ui.graphics.vector.ImageVector) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top
    ) {
        Icon(
            imageVector = icono,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.tertiary, // Usamos el acento Azul Eléctrico
            modifier = Modifier.size(24.dp).padding(top = 4.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column {
            Text(
                text = titulo,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = descripcion,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}