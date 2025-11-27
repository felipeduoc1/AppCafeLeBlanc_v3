package com.example.appcafeleblanc

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.appcafeleblanc.screens.CarritoScreen
import com.example.appcafeleblanc.screens.ContactoScreen
import com.example.appcafeleblanc.screens.HomeScreen
import com.example.appcafeleblanc.screens.LoginScreen
import com.example.appcafeleblanc.screens.RegistroScreen
import com.example.appcafeleblanc.screens.NosotrosScreen
import com.example.appcafeleblanc.screens.ProductosScreen
import com.example.appcafeleblanc.screens.ResumenScreen
import com.example.appcafeleblanc.viewmodels.CarritoViewModel
import com.example.appcafeleblanc.viewmodels.UsuarioViewModel


// Asegúrate de que esta importación sea correcta

@Composable
fun AppNavGraph(navController: NavHostController) {
    // Los ViewModels se instancian una vez a nivel del NavHost
    val carritoViewModel: CarritoViewModel = viewModel()
    val usuarioViewModel: UsuarioViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        // Rutas Principales
        composable("home") { HomeScreen(navController) }
        composable("productos") { ProductosScreen(navController, carritoViewModel) }
        composable("carrito") { CarritoScreen(navController, carritoViewModel) }

        // Rutas Informativas
        composable("nosotros") { NosotrosScreen(navController) }
        composable("contacto") { ContactoScreen(navController) }

        // Rutas de Usuario (Inyectando UsuarioViewModel)
        composable("login") { LoginScreen(navController, usuarioViewModel) }
        composable("registro") { RegistroScreen(navController, usuarioViewModel) }

        // ⭐️ NUEVA RUTA ⭐️
        // Le pasamos el navController (para el botón de regreso)
        // y automáticamente obtiene el usuarioViewModel compartido.
        composable("resumen") { ResumenScreen(navController, usuarioViewModel) }
    }
}