package com.example.appcafeleblanc.screens

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
import com.example.appcafeleblanc.viewmodels.CarritoViewModel
import com.example.appcafeleblanc.viewmodels.ProductosViewModel // <-- NUEVO: Importamos el ViewModel de Productos
import com.example.appcafeleblanc.model.Producto
// NOTA: Ya no importamos 'listaProductos', el ViewModel lo gestiona.


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductosScreen(
    navController: NavController,
    // Obtenemos las instancias de los ViewModels necesarios
    carritoViewModel: CarritoViewModel = viewModel(),
    productosViewModel: ProductosViewModel = viewModel() // <-- NUEVO ViewModel de Productos
) {

    // ⭐️ OBTENEMOS la lista de productos del ViewModel ⭐️
    val productos: List<Producto> = productosViewModel.productos

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
                .padding(horizontal = 16.dp),
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
                        // Usamos un logo de placeholder
                        Image(
                            painter = painterResource(id = R.drawable.logo),
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
                            // Formato de precio
                            Text("$${producto.precio}", style = MaterialTheme.typography.bodyLarge.copy(
                                color = MaterialTheme.colorScheme.primary
                            ))
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
                        .padding(horizontal = 60.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary)
                ) {
                    Text("Volver al inicio")
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}