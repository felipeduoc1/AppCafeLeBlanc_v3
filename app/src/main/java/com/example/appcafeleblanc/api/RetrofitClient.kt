package com.example.appcafeleblanc.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object RetrofitClient {

    // --- CORRECCIÓN FINAL Y DEFINITIVA ---
    // Eliminamos "/open-api-catalog/" de la URL para apuntar directamente a la API
    // y no a su documentación protegida. Asegúrate de que termine con un slash "/".
    private const val BASE_URL = "https://gb6a0169c1a52a8-appmovil.adb.sa-valparaiso-1.oraclecloudapps.com/ords/cafeleblanc_owner/api/"

    // El interceptor de logs está perfecto, nos ayudó a encontrar el problema.
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    val userService: UserService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserService::class.java)
    }
}
