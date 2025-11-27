package com.example.appcafeleblanc.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appcafeleblanc.api.RetrofitClient
import com.example.appcafeleblanc.model.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UsuarioViewModel : ViewModel() {

    // 1. Manejo del Estado de la UI (Sincronizado con RegistroScreen: usa 'estado')
    private val _estado = MutableStateFlow(UsuarioUIState())
    val estado: StateFlow<UsuarioUIState> = _estado // Se llama 'estado'

    // --- MANEJADORES DE CAMBIO DE CAMPOS ---

    // Al cambiar un campo, limpiamos los errores de validación locales (incluido 'terminos')
    fun onNombreChange(newValue: String) {
        _estado.value = _estado.value.copy(nombre = newValue, errores = UsuarioErrores())
    }

    fun onCorreoChange(newValue: String) {
        _estado.value = _estado.value.copy(correo = newValue, errores = UsuarioErrores())
    }

    fun onClaveChange(newValue: String) {
        _estado.value = _estado.value.copy(clave = newValue, errores = UsuarioErrores())
    }

    fun onDireccionChange(newValue: String) {
        _estado.value = _estado.value.copy(direccion = newValue, errores = UsuarioErrores())
    }

    // --- FUNCIONES DE API ---

    // La UI llama a registrarUsuarioSimulado(), y esta función contiene la llamada real a la API
    fun registrarUsuarioSimulado() {
        val currentState = estado.value

        // 1. Prepara el cuerpo de la petición con los datos actuales
        val requestBody = RegistroRequest(
            correo = currentState.correo,
            claveHash = currentState.clave,
            nombre = currentState.nombre.ifEmpty { null }
        )

        // 2. Inicializa el estado para el registro (Cargando)
        _estado.value = currentState.copy(
            isLoading = true,
            loginError = null,
            isRegisteredSuccessful = false,
            errores = UsuarioErrores() // Limpiamos errores de validación locales antes de la llamada API
        )

        viewModelScope.launch(Dispatchers.IO) {
            try {
                // 3. Llama al endpoint de ORDS "registroUsuario"
                val response = RetrofitClient.userService.registerUser(requestBody)

                withContext(Dispatchers.Main) {
                    // Finaliza la carga
                    _estado.value = _estado.value.copy(isLoading = false)

                    if (response.isSuccessful) {
                        // CÓDIGO 201: Éxito en el registro
                        _estado.value = _estado.value.copy(isRegisteredSuccessful = true)
                    } else {
                        // CÓDIGOS DE ERROR (400, 409, 500)
                        handleApiError(response.code())
                    }
                }
            } catch (e: Exception) {
                // Error de red (Timeouts, servidor caído)
                withContext(Dispatchers.Main) {
                    _estado.value = _estado.value.copy(
                        isLoading = false,
                        loginError = "Error de conexión: No se pudo contactar al servidor."
                    )
                }
            }
        }
    }

    fun iniciarSesion() {
        val currentState = estado.value
        val requestBody = LoginRequest(
            correo = currentState.correo,
            claveHash = currentState.clave
        )

        // Inicializa el estado para el login (Cargando)
        _estado.value = currentState.copy(
            isLoading = true,
            loginError = null,
            isLoginSuccessful = false
        )

        viewModelScope.launch(Dispatchers.IO) {
            try {
                // Llama al endpoint de ORDS "loginUsuario" (o el que corresponda)
                val response = RetrofitClient.userService.loginUser(requestBody)

                withContext(Dispatchers.Main) {
                    // Finaliza la carga
                    _estado.value = _estado.value.copy(isLoading = false)

                    if (response.isSuccessful) {
                        // CÓDIGO 200: Éxito en el login
                        _estado.value = _estado.value.copy(isLoginSuccessful = true)
                    } else {
                        // CÓDIGOS DE ERROR (401, 404, 500)
                        handleApiError(response.code())
                    }
                }
            } catch (e: Exception) {
                // Error de red
                withContext(Dispatchers.Main) {
                    _estado.value = _estado.value.copy(
                        isLoading = false,
                        loginError = "Error de conexión. Verifica tu red o la URL."
                    )
                }
            }
        }
    }

    // Función central para manejar los códigos de estado HTTP
    private fun handleApiError(statusCode: Int) {
        val errorMessage = when (statusCode) {
            400 -> "Datos incompletos o inválidos (Bad Request)."
            401 -> "Credenciales incorrectas (Unauthorized)."
            409 -> "El correo ya está registrado (Conflict)."
            500 -> "Error interno del servidor. Intenta más tarde."
            else -> "Error del servidor: Código $statusCode."
        }
        _estado.value = _estado.value.copy(loginError = errorMessage)
    }
}