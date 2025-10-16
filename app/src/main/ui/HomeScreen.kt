package com.example.appcafeleblanc.ui.theme

// Importaciones necesarias
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Divider // Necesario para el nuevo elemento (Punto 8)
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Scaffold
import androidx.compose.material3.MaterialTheme // Necesario para usar colores del tema (Punto 5)
import androidx.compose.ui.Alignment // Necesario para alineación (Punto 6)
import com.example.appcafeleblanc.R

/**
 * 7. Comentar: Función Composable que define la estructura principal de la pantalla de inicio.
 * Utiliza Scaffold para la estructura base de Material Design.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Mi App Kotlin",
                        // 5. Usar MaterialTheme: Aplicar el color primario al título
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            )
        }
    ) { innerPadding ->
        // Contenedor principal para organizar los elementos verticalmente.
        Column(
            // 7. Comentar: Modificadores para padding y tamaño.
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp),

            // 4. Agregar espaciado uniforme: Distancia de 20dp entre todos los elementos hijos.
            verticalArrangement = Arrangement.spacedBy(20.dp),

            // 6. Verificar alineación: Centrar los elementos horizontalmente en la columna.
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // 8. Nuevo elemento: Un texto de bienvenida con estilo del tema.
            Text(
                text = "¡Bienvenido a Jetpack Compose!",
                // 5. Usar MaterialTheme: Estilo de texto grande (Headline Large).
                style = MaterialTheme.typography.headlineLarge
            )

            // 8. Nuevo elemento: Un separador visual.
            // 7. Comentar: Separador horizontal para organizar secciones.
            Divider(
                modifier = Modifier.fillMaxWidth(),
                thickness = 1.dp,
                // 5. Usar MaterialTheme: Color de contorno sutil.
                color = MaterialTheme.colorScheme.outline
            )

            // 7. Comentar: Botón interactivo.
            Button(
                onClick = { /* TODO: Lógica de clic */ },
                // 6. Alineación: Ocupa todo el ancho.
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Presióname")
            }

            // 7. Comentar: Imagen de logo.
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo App",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                contentScale = ContentScale.Fit
            )
        }
    }
}

/**
 * Función de previsualización.
 */
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    // 7. Comentar: Envolver la previsualización en el tema para ver los colores y estilos.
    AppCafeLeBlancTheme {
        HomeScreen()
    }
}