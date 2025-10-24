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
import com.example.appcafeleblanc.screens.NosotrosScreen
import com.example.appcafeleblanc.screens.ProductosScreen
import com.example.appcafeleblanc.viewmodels.CarritoViewModel
import com.example.appcafeleblanc.viewmodels.UsuarioViewModel
import com.example.appcafeleblanc.screens.RegistroScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    val carritoViewModel: CarritoViewModel = viewModel()
    val usuarioViewModel: UsuarioViewModel = viewModel()

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
        composable("registro") {RegistroScreen(navController, usuarioViewModel)}
    }
}
