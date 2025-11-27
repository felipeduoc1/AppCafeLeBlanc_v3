package com.example.appcafeleblanc.model // Asegúrate de usar el nombre de tu package

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("p_correo") val correo: String,
    @SerializedName("p_clave_hash") val claveHash: String
)