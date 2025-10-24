package com.example.appcafeleblanc.viewmodels

import androidx.lifecycle.ViewModel
import com.example.appcafeleblanc.model.UsuarioErrores
import com.example.appcafeleblanc.model.UsuarioUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class UsuarioViewModel : ViewModel() {
    // MutableStateFlow para el estado interno y mutable
    private val _estado = MutableStateFlow(UsuarioUIState())

    // StateFlow público e inmutable para la UI
    val estado: StateFlow<UsuarioUIState> = _estado.asStateFlow()

    fun onNombreChange(valor: String) {
        _estado.update {
            it.copy(
                nombre = valor,
                // Al cambiar el valor, limpiamos el error asociado al campo
                errores = it.errores.copy(nombre = null)
            )
        }
    }

    fun onCorreoChange(valor: String) {
        _estado.update {
            it.copy(
                correo = valor,
                errores = it.errores.copy(correo = null)
            )
        }
    }

    fun onClaveChange(valor: String) {
        _estado.update {
            it.copy(
                clave = valor,
                errores = it.errores.copy(clave = null)
            )
        }
    }

    fun onDireccionChange(valor: String) {
        _estado.update {
            it.copy(
                direccion = valor,
                errores = it.errores.copy(direccion = null)
            )
        }
    }

    fun onAceptarTerminosChange(valor: Boolean) {
        _estado.update {
            it.copy(
                // Simplemente actualiza el valor booleano
                aceptaTerminos = valor
            )
        }
    }

    fun validarFormulario(): Boolean {
        val estadoActual = _estado.value
        // 1. Definición de Errores: Se evalúa cada campo
        val errores = UsuarioErrores(
            nombre = if (estadoActual.nombre.isBlank()) "NO PUEDE ESTAR VACÍO" else null,

            // Usamos contains("@") para una validación básica de correo
            correo = if (!estadoActual.correo.contains("@")) "CORREO INVÁLIDO" else null,

            // Verificamos la longitud de la clave
            clave = if (estadoActual.clave.length < 8) "DEBE TENER AL MENOS 8 CARACTERES" else null,

            direccion = if (estadoActual.direccion.isBlank()) "NO PUEDE ESTAR VACÍO" else null
        )

        // 2. Comprobación de Existencia de Errores:
        // Crea una lista solo con los mensajes de error que NO son null.
        // Si la lista no está vacía, es que hay errores.
        val hayErrores = listOfNotNull(
            errores.nombre,
            errores.correo,
            errores.clave,
            errores.direccion
        ).isNotEmpty() // <-- Esta función comprueba si la lista contiene elementos

        // 3. Actualizar el Estado de la UI:
        // Publicamos los nuevos errores para que la UI los muestre
        _estado.update {
            it.copy(errores = errores)
        }

        // 4. Retornar Resultado:
        // Retorna true si NO hay errores (si hayErrores es false)
        return !hayErrores
    }
}