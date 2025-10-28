package com.example.appcafeleblanc.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
// 1. IMPORTAMOS el modelo de Producto de la fuente correcta
import com.example.appcafeleblanc.model.Producto

// 2. ELIMINAR O COMENTAR la data class ProductoCarrito de aquí

class CarritoViewModel : ViewModel() {

    // 3. ACTUALIZAMOS: La lista debe ser de tipo Producto
    private val _carrito = mutableStateListOf<Producto>()
    val carrito: List<Producto> get() = _carrito

    // 3. ACTUALIZAMOS: El argumento de la función debe ser de tipo Producto
    fun agregarProducto(producto: Producto) {
        _carrito.add(producto)
    }

    // 3. ACTUALIZAMOS: El argumento de la función debe ser de tipo Producto
    fun eliminarProducto(producto: Producto) {
        _carrito.remove(producto)
    }

    fun vaciarCarrito() {
        _carrito.clear()
    }

    // 4. SIMPLIFICAMOS: Como 'precio' en Producto es Int, solo necesitas sumarlo
    fun total(): Int {
        return _carrito.sumOf { it.precio }
    }
}