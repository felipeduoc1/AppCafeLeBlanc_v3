package com.example.appcafeleblanc.model // Asegúrate de usar el nombre de tu package

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    // Captura el ID generado que devuelve el servidor
    @SerializedName("o_new_id") val newId: Int?
)