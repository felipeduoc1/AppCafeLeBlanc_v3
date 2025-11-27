package com.example.appcafeleblanc.model // Asegúrate de usar el nombre de tu package

import com.google.gson.annotations.SerializedName

// Usamos SerializedName para que coincida con las variables de enlace p_correo, p_clave_hash, etc.
data class RegistroRequest(
    @SerializedName("p_correo") val correo: String,
    @SerializedName("p_clave_hash") val claveHash: String,
    @SerializedName("p_nombre") val nombre: String? // El nombre es opcional
)