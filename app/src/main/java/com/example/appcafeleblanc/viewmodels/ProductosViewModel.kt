package com.example.appcafeleblanc.viewmodels

import androidx.lifecycle.ViewModel
import com.example.appcafeleblanc.model.Producto
import com.example.appcafeleblanc.model.listaProductos

// ProductosViewModel hereda de ViewModel
class ProductosViewModel : ViewModel() {

    // Exponemos la lista de productos estáticos como un valor (val)
    // Las pantallas accederán a esta lista inmutable.
    val productos: List<Producto> = listaProductos

    /* * Aquí podrías añadir lógica en el futuro, como:
    * - Filtros (e.g., por categoría)
    * - Búsqueda de productos
    * - Carga de datos desde una API o DB (usando LiveData/StateFlow)
    */
}