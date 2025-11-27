package com.example.appcafeleblanc.api

import com.example.appcafeleblanc.model.ApiResponse
import com.example.appcafeleblanc.model.RegistroRequest
import com.example.appcafeleblanc.model.LoginRequest // Aunque el endpoint no existe, dejamos la estructura
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserService {

    // 1. ENDPOINT PARA EL REGISTRO
    // Metodo: POST
    // Ruta: BASE_URL + "registroUsuario"
    // Cuerpo: Recibe el objeto RegistroRequest
    // Respuesta: Espera un objeto ApiResponse (que contiene el o_new_id)
    @POST("registroUsuario")
    suspend fun registerUser(@Body request: RegistroRequest): Response<ApiResponse>

    // 2. ENDPOINT PARA EL INICIO DE SESIÓN (PENDIENTE)
    // Cuando crees esta plantilla en ORDS, es probable que se llame 'loginUsuario'.
    // Si usas otro nombre, ajústalo aquí.
    @POST("loginUsuario")
    suspend fun loginUser(@Body request: LoginRequest): Response<ApiResponse>
}