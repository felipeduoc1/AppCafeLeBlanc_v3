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
fun ContactoScreen(navController: NavController) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Contacto 📞") }) }
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
                text = "Contáctanos",
                style = MaterialTheme.typography.headlineSmall
            )

            Text(
                text = """
                    📍 Dirección: Av. Central 123, Santiago
                    📞 Teléfono: +56 9 5555 5555
                    ✉️ Email: contacto@cafeleblanc.cl
                """.trimIndent(),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = { navController.navigate("home") }) {
                Text("Volver al inicio")
            }
        }
    }
}
