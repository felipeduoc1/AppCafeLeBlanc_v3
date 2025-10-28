package com.example.appcafeleblanc.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.appcafeleblanc.viewmodels.CarritoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarritoScreen(
    navController: NavController,
    carritoViewModel: CarritoViewModel = viewModel()
) {
    val carrito = carritoViewModel.carrito

    Scaffold(
        topBar = { TopAppBar(title = { Text("Tu Carrito 🛒") }) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            if (carrito.isEmpty()) {
                Text(
                    text = "No hay productos en el carrito",
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.weight(1f))
            } else {
                LazyColumn(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(carrito) { producto ->
                        Card(modifier = Modifier.fillMaxWidth()) {
                            Row(
                                modifier = Modifier
                                    .padding(12.dp)
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                // PRIMER TEXT: Muestra el nombre
                                Text(
                                    text = producto.nombre,
                                    style = MaterialTheme.typography.titleMedium
                                )

                                // SEGUNDO TEXT: Muestra el precio convertido a String y con formato
                                Text(
                                    text = "$${producto.precio}", // ✨ CORRECCIÓN DE SINTAXIS y TIPO
                                    style = MaterialTheme.typography.bodyLarge.copy(
                                        color = MaterialTheme.colorScheme.primary
                                    )
                                )
                            }
                        }
                    }
                }
            }

            Divider()

            // BLOQUE INFERIOR (siempre visible)
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                // Total (se mantiene abajo)
                Text(
                    text = "Total: $${if (carrito.isEmpty()) 0 else carritoViewModel.total()}",
                    style = MaterialTheme.typography.titleMedium
                )

                // Botones
                if (carrito.isNotEmpty()) {
                    Button(
                        onClick = { carritoViewModel.vaciarCarrito() },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Vaciar Carrito")
                    }
                }

                Button(
                    onClick = { navController.navigate("home") },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Volver al inicio")
                }
            }
        }
    }
}
