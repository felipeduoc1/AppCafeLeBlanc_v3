package com.example.apirest.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.apirest.viewmodel.PostViewModel
import com.example.apirest.data.model.Post // <--- ⚠️ IMPORTACIÓN FALTANTE

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostScreen(viewModel: PostViewModel) {
    // Observamos el flujo de datos del ViewModel
    val posts = viewModel.postList.collectAsState().value

    // Scaffold con TopAppBar
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Listado de Posts") }
            )
        }
    ) { innerPadding ->
        // Aplicamos el padding de seguridad del sistema
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues = innerPadding) // Garantiza edge-to-edge
        ) {
            // Lista de publicaciones
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(all = 16.dp) // Espaciado interior
            ) {
                items(items = posts) { post ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Column(modifier = Modifier.padding(all = 10.dp)) {
                            Text(
                                text = "Titulo: ${post.title}",
                                style = MaterialTheme.typography.titleMedium
                            )
                            Spacer(modifier = Modifier.height(height = 4.dp))
                            Text(
                                text = post.body,
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                }
            }
        }
    }
}