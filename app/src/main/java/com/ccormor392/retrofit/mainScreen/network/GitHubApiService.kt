package com.ccormor392.retrofit.mainScreen.network

import com.ccormor392.retrofit.mainScreen.ui.model.User
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


private const val BASE_URL = "https://api.github.com/"

val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface GitHubApiService{
    @GET("users")
    fun getUsers():Call<List<User>>
}