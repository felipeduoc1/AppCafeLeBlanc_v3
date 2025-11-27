package com.example.appcafeleblanc.api

import com.example.appcafeleblanc.model.Producto
import retrofit2.Response
import retrofit2.http.GET

interface ProductService {

    /**
     * Endpoint para obtener el listado completo de productos desde la base de datos.
     * * @return Response<List<Producto>> que contiene la lista de productos.
     * Nota: Debes asegurar que la URL base en RetrofitClient esté configurada correctamente.
     */
    @GET("obtenerProductos") // <--- Reemplaza "productos" por el endpoint de tu ORDS (ej: /api/v1/productos)
    suspend fun getProductos(): Response<List<Producto>>
}