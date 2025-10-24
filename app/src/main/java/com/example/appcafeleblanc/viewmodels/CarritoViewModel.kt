package com.example.appcafeleblanc.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

data class ProductoCarrito(
    val nombre: String,
    val descripcion: String,
    val precio: String,
    val imagen: Int
)

class CarritoViewModel : ViewModel() {
    private val _carrito = mutableStateListOf<ProductoCarrito>()
    val carrito: List<ProductoCarrito> get() = _carrito

    fun agregarProducto(producto: ProductoCarrito) {
        _carrito.add(producto)
    }

    fun eliminarProducto(producto: ProductoCarrito) {
        _carrito.remove(producto)
    }

    fun vaciarCarrito() {
        _carrito.clear()
    }

    fun total(): Int {
        // Elimina el signo $ y los puntos, y suma los precios
        return _carrito.sumOf {
            it.precio.replace("$", "").replace(".", "").trim().toIntOrNull() ?: 0
        }
    }
}
