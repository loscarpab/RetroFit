package com.ccormor392.retrofit.mainScreen.network

import com.ccormor392.retrofit.mainScreen.ui.model.User
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

// Definición de la URL base para las solicitudes a la API de GitHub
private const val BASE_URL = "https://api.github.com/"
// Creación de una instancia de Retrofit utilizando el patrón de diseño Builder
val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())// Configuración para usar Gson para la conversión JSON
    .baseUrl(BASE_URL)// Establece la URL base para todas las solicitudes
    .build()
// Definición de una interfaz que especifica los métodos para interactuar con la API de GitHub
interface GitHubApiService{
    @GET("users")// Anotación indicando que este método realizará una solicitud HTTP GET a la ruta "users"
    fun getUsers():Call<List<User>>// Método para obtener una lista de usuarios, devuelve un objeto Call<List<User>>
}