package com.example.appcafeleblanc

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.appcafeleblanc.screens.CarritoScreen
import com.example.appcafeleblanc.screens.ContactoScreen
import com.example.appcafeleblanc.screens.HomeScreen
import com.example.appcafeleblanc.screens.LoginScreen // Importación necesaria
import com.example.appcafeleblanc.screens.NosotrosScreen
import com.example.appcafeleblanc.screens.ProductosScreen
import com.example.appcafeleblanc.screens.RegistroScreen // Importación necesaria
import com.example.appcafeleblanc.viewmodels.CarritoViewModel
import com.example.appcafeleblanc.viewmodels.UsuarioViewModel

@Composable
fun AppNavGraph(navController: NavHostController) {
    val carritoViewModel: CarritoViewModel = viewModel()
    // Creamos la instancia UNA SOLA VEZ para que se comparta el estado de registro/login
    val usuarioViewModel: UsuarioViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") { HomeScreen(navController) }
        composable("productos") { ProductosScreen(navController, carritoViewModel) }
        composable("nosotros") { NosotrosScreen(navController) }

        // =======================================================
        // MODIFICADO: Inyectamos el usuarioViewModel
        composable("login") { LoginScreen(navController, usuarioViewModel) }
        // =======================================================

        composable("carrito") { CarritoScreen(navController, carritoViewModel) }
        composable("contacto") { ContactoScreen(navController) }

        // Ya estabas inyectando el ViewModel aquí, lo cual es correcto.
        composable("registro") { RegistroScreen(navController, usuarioViewModel) }
    }
}