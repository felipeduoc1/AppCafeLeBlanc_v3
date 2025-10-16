package com.example.appcafeleblanc.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NosotrosScreen(navController: NavController) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Nosotros") }) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Sobre Café Le Blanc ☕",
                style = MaterialTheme.typography.headlineSmall
            )

            Text(
                text = """
                    En Café Le Blanc creemos en el arte de preparar un buen café.
                    Nuestra misión es ofrecer experiencias únicas a través del aroma,
                    el sabor y la calidez de nuestros espacios.

                    Desde 2010, tostamos granos seleccionados y trabajamos con
                    productores locales para asegurar la mejor calidad en cada taza.
                """.trimIndent(),
                textAlign = TextAlign.Justify,
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = { navController.navigate("home") }
            ) {
                Text("Volver al inicio")
            }
        }
    }
}
