package com.example.appcafeleblanc.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.appcafeleblanc.R
import com.example.appcafeleblanc.ui.viewmodels.CarritoViewModel
import com.example.appcafeleblanc.ui.viewmodels.ProductoCarrito

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductosScreen(
    navController: NavController,
    carritoViewModel: CarritoViewModel = viewModel()
) {

    val productos = listOf(
        ProductoCarrito("Espresso", "Café intenso de sabor fuerte", "$2.000", R.drawable.logo),
        ProductoCarrito("Café Latte", "Mezcla suave con leche espumada", "$2.500", R.drawable.logo),
        ProductoCarrito("Capuccino", "Con espuma de leche y canela", "$2.700", R.drawable.logo),
        ProductoCarrito("Muffin de Arándanos", "Recién horneado, ideal con café", "$1.800", R.drawable.logo)
    )

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Nuestros Productos") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate("carrito") }) {
                Text("🛒")
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(productos) { producto ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = producto.imagen),
                            contentDescription = producto.nombre,
                            modifier = Modifier
                                .size(80.dp)
                                .padding(end = 16.dp),
                            contentScale = ContentScale.Fit
                        )

                        Column(modifier = Modifier.weight(1f)) {
                            Text(producto.nombre, style = MaterialTheme.typography.titleMedium)
                            Text(producto.descripcion, style = MaterialTheme.typography.bodyMedium)
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(producto.precio, style = MaterialTheme.typography.bodyLarge)
                            Spacer(modifier = Modifier.height(8.dp))
                            Button(
                                onClick = { carritoViewModel.agregarProducto(producto) },
                                modifier = Modifier.align(Alignment.End)
                            ) {
                                Text("Agregar al carrito")
                            }
                        }
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(24.dp))
                Button(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 60.dp)
                ) {
                    Text("Volver al inicio")
                }
            }
        }
    }
}
