package com.example.appcafeleblanc.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.appcafeleblanc.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Café Le Blanc") })
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Logo principal
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo Café Le Blanc",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                contentScale = ContentScale.Fit
            )

            // Texto de bienvenida
            Text(
                text = "Bienvenido a Café Le Blanc ☕",
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Botones de navegación principales
            Button(
                onClick = { navController.navigate("productos") },
                modifier = Modifier.fillMaxWidth(0.8f)
            ) {
                Text("Ver Productos")
            }

            Button(
                onClick = { navController.navigate("carrito") },
                modifier = Modifier.fillMaxWidth(0.8f)
            ) {
                Text("Ver Carrito 🛒")
            }

            Button(
                onClick = { navController.navigate("nosotros") },
                modifier = Modifier.fillMaxWidth(0.8f)
            ) {
                Text("Nosotros")
            }

            Button(
                onClick = { navController.navigate("contacto") },
                modifier = Modifier.fillMaxWidth(0.8f)
            ) {
                Text("Contacto")
            }

            Button(
                onClick = { navController.navigate("login") },
                modifier = Modifier.fillMaxWidth(0.8f)
            ) {
                Text("Iniciar Sesión")
            }
        }
    }
}
