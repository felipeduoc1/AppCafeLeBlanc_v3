package com.example.appcafeleblanc.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.appcafeleblanc.ui.screens.*
import com.example.appcafeleblanc.ui.viewmodels.CarritoViewModel

@Composable
fun AppNavGraph(navController: NavHostController) {
    val carritoViewModel: CarritoViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") { HomeScreen(navController) }
        composable("productos") { ProductosScreen(navController, carritoViewModel) }
        composable("nosotros") { NosotrosScreen(navController) }
        composable("login") { LoginScreen(navController) }
        composable("carrito") { CarritoScreen(navController, carritoViewModel) }
        composable("contacto") { ContactoScreen(navController) }
    }
}
