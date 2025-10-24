package com.example.appcafeleblanc.model

data class UsuarioUIState(
    val nombre : String = "",
    val correo : String = "",
    val clave : String = "",
    val direccion : String = "",
    val aceptaTerminos : Boolean = false,
    val errores : UsuarioErrores = UsuarioErrores(),

    // =======================================================
    // NUEVOS CAMPOS PARA LOGIN/REGISTRO
    // =======================================================
    val isLoading : Boolean = false, // Indica si una operación (login/registro) está en curso
    val isLoginSuccessful : Boolean = false, // Indica si el login fue exitoso para navegar
    val isRegisteredSuccessful : Boolean = false, // Indica si el registro fue exitoso para navegar
    val loginError : String? = null, // Mensaje de error general para el login (e.g., credenciales incorrectas)
    // =======================================================
)