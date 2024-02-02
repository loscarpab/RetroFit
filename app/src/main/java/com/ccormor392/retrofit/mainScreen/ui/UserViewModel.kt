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

class UserViewModel : ViewModel() {
    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> get() = _users

    fun loadUsers() {
        val service = retrofit.create(GitHubApiService::class.java)
        val call = service.getUsers()

        call.enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful) {
                    val userList = response.body()
                    _users.value = userList!!
                } else {

                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {

            }
        })
    }
}


