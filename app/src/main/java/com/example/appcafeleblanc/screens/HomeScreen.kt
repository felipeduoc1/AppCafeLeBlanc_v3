package com.example.appcafeleblanc.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color // Asegúrate de importar Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.appcafeleblanc.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    // 1. Usa Scaffold con colores del tema
    Scaffold(
        // Cambiamos el color de la barra superior para que se vea integrado o resalte
        topBar = {
            TopAppBar(
                title = {
                    // 2. Aplica el estilo de tipografía para títulos grandes
                    Text(
                        "Café Le Blanc",
                        style = MaterialTheme.typography.titleLarge
                    )
                },
                // Usa un color neutro o el color de superficie para la TopBar
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    titleContentColor = MaterialTheme.colorScheme.onSurface
                )
            )
        },
        // 3. Usa el color de fondo definido en el tema
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                // Opcional: Si quieres que el Column tenga un color diferente al fondo
                // .background(MaterialTheme.colorScheme.background)
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
                // 4. Aplica el estilo de tipografía para subtítulos/headlines
                style = MaterialTheme.typography.headlineSmall,
                // 5. Aplica el color del tema para el texto principal (NegroTinta o onBackground)
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Botones de navegación principales

            // Botón Principal: Usa el color 'primary' (VerdeMatcha)
            Button(
                onClick = { navController.navigate("productos") },
                modifier = Modifier.fillMaxWidth(0.8f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary, // Verde Matcha
                    contentColor = MaterialTheme.colorScheme.onPrimary // Texto sobre Matcha
                )
            ) {
                // 6. Aplica el estilo de tipografía para botones (labelLarge)
                Text("Ver Productos", style = MaterialTheme.typography.labelLarge)
            }

            // Botones Secundarios: Usa el color 'secondary' (MarronTostado) o 'surface'
            NavigationButton(
                text = "Ver Carrito 🛒",
                onClick = { navController.navigate("carrito") },
                color = MaterialTheme.colorScheme.secondary // Marrón Tostado
            )
            NavigationButton(
                text = "Nosotros",
                onClick = { navController.navigate("nosotros") },
                color = MaterialTheme.colorScheme.surfaceVariant // Color neutro más claro
            )
            NavigationButton(
                text = "Contacto",
                onClick = { navController.navigate("contacto") },
                color = MaterialTheme.colorScheme.secondaryContainer // Otro color secundario
            )
            NavigationButton(
                text = "Iniciar Sesión",
                onClick = { navController.navigate("login") },
                color = MaterialTheme.colorScheme.tertiary // Rosa Sakura (para destacar el login/registro)
            )
            NavigationButton(
                text = "Registrarse",
                onClick = { navController.navigate("registro") },
                color = MaterialTheme.colorScheme.secondaryContainer // Otro color secundario
            )
        }
    }
}

// Composable helper para simplificar los botones de navegación
@Composable
fun NavigationButton(text: String, onClick: () -> Unit, color: Color) {
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(0.8f),
        colors = ButtonDefaults.buttonColors(
            containerColor = color,
            contentColor = MaterialTheme.colorScheme.contentColorFor(color)
        )
    ) {
        Text(text, style = MaterialTheme.typography.labelLarge)
    }
}