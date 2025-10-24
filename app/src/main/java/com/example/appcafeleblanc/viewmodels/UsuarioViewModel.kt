package com.example.appcafeleblanc.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appcafeleblanc.model.UsuarioErrores
import com.example.appcafeleblanc.model.UsuarioUIState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class UsuarioViewModel : ViewModel() {
    // MutableStateFlow para el estado interno y mutable
    private val _estado = MutableStateFlow(UsuarioUIState())

    // StateFlow público e inmutable para la UI
    val estado: StateFlow<UsuarioUIState> = _estado.asStateFlow()

    // =======================================================
    // ** LÓGICA DE SIMULACIÓN (Reemplazar con lógica real de persistencia) **
    // ESTAS VARIABLES MANTIENEN EL ÚLTIMO USUARIO REGISTRADO EN MEMORIA
    private var MOCKED_REGISTERED_EMAIL = "usuario@cafe.com"
    private var MOCKED_REGISTERED_PASSWORD = "password123"
    // ** FIN LÓGICA DE SIMULACIÓN **
    // =======================================================

    fun onNombreChange(valor: String) {
        _estado.update {
            it.copy(
                nombre = valor,
                errores = it.errores.copy(nombre = null)
            )
        }
    }

    fun onCorreoChange(valor: String) {
        _estado.update {
            it.copy(
                correo = valor,
                errores = it.errores.copy(correo = null),
                loginError = null // Limpiar error de login al modificar
            )
        }
    }

    fun onClaveChange(valor: String) {
        _estado.update {
            it.copy(
                clave = valor,
                errores = it.errores.copy(clave = null),
                loginError = null // Limpiar error de login al modificar
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
                aceptaTerminos = valor
            )
        }
    }

    // =======================================================
    // NUEVO: Métodos para manejar el estado de las pantallas
    // =======================================================
    fun clearLoginState() {
        _estado.update {
            it.copy(
                isLoginSuccessful = false,
                loginError = null,
                isLoading = false,
                correo = "", // Limpiar los inputs
                clave = ""   // Limpiar los inputs
            )
        }
    }

    // =======================================================
    // NUEVO: Método de Login
    // =======================================================
    fun login() {
        // Validación básica de campos no vacíos antes de intentar el login
        if (_estado.value.correo.isBlank() || _estado.value.clave.isBlank()) {
            _estado.update {
                it.copy(loginError = "Por favor, ingresa correo y contraseña.")
            }
            return
        }

        // 1. Iniciar el estado de carga
        _estado.update { it.copy(isLoading = true, loginError = null) }

        // 2. Ejecutar la lógica de autenticación en un coroutine
        viewModelScope.launch {
            // SIMULACIÓN DE RETARDO DE RED/BASE DE DATOS
            delay(1500)

            val estadoActual = _estado.value

            // Lógica para verificar el usuario guardado (SIMULADA)
            if (estadoActual.correo == MOCKED_REGISTERED_EMAIL && estadoActual.clave == MOCKED_REGISTERED_PASSWORD) {
                // Éxito
                _estado.update {
                    it.copy(
                        isLoading = false,
                        isLoginSuccessful = true,
                        loginError = null
                    )
                }
            } else {
                // Falla
                _estado.update {
                    it.copy(
                        isLoading = false,
                        isLoginSuccessful = false,
                        loginError = "Credenciales incorrectas. Verifica tu correo o contraseña."
                    )
                }
            }
        }
    }


    // =======================================================
    // MODIFICADO: Método de Registro Simulado
    // Actualiza las credenciales simuladas al registrar.
    // =======================================================
    fun registrarUsuarioSimulado() {
        if (validarFormulario()) {
            _estado.update { it.copy(isLoading = true) }
            viewModelScope.launch {
                delay(1500)
                // SIMULACIÓN: Guardamos el usuario registrado como el "único"
                MOCKED_REGISTERED_EMAIL = _estado.value.correo
                MOCKED_REGISTERED_PASSWORD = _estado.value.clave

                _estado.update {
                    it.copy(
                        isLoading = false,
                        isRegisteredSuccessful = true
                    )
                }
            }
        }
    }

    // =======================================================
    // TU FUNCIÓN ORIGINAL validarFormulario (se mantiene)
    // =======================================================
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
        val hayErrores = listOfNotNull(
            errores.nombre,
            errores.correo,
            errores.clave,
            errores.direccion
        ).isNotEmpty()

        // 3. Actualizar el Estado de la UI:
        _estado.update {
            it.copy(errores = errores)
        }

        // 4. Retornar Resultado:
        return !hayErrores
    }
}