package com.ccormor392.retrofit.mainScreen.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ccormor392.retrofit.mainScreen.network.GitHubApiService
import com.ccormor392.retrofit.mainScreen.ui.model.User
import com.ccormor392.retrofit.mainScreen.network.retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// ViewModel utilizado para gestionar y proporcionar datos relacionados con los usuarios
class UserViewModel : ViewModel() {

    // MutableLiveData que contendrá la lista de usuarios; se utiliza para actualizaciones en tiempo real
    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> get() = _users

    // Método para cargar la lista de usuarios desde la API de GitHub
    fun loadUsers() {
        // Creación de una instancia del servicio GitHubApiService utilizando la instancia de Retrofit creada previamente
        val service = retrofit.create(GitHubApiService::class.java)

        // Creación de una llamada asíncrona para obtener la lista de usuarios
        val call = service.getUsers()

        // Manejo de la respuesta asíncrona utilizando enqueue
        call.enqueue(object : Callback<List<User>> {
            // Método llamado cuando la respuesta HTTP es exitosa
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful) {
                    // Obtiene la lista de usuarios de la respuesta y la asigna al MutableLiveData
                    val userList = response.body()
                    _users.value = userList!!
                } else {
                    // Puedes manejar aquí el caso en el que la respuesta no sea exitosa
                }
            }
            // Método llamado cuando la solicitud HTTP falla
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                // Puedes manejar aquí el caso en el que la solicitud falle
            }
        })
    }
}



