package com.example.donkey.Api

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("login") // Replace with your API endpoint
    fun login(@Body loginRequest: LoginRequest): Call<LoginResponse> // Use the appropriate response type for your API


}

val retrofit = Retrofit.Builder()
    .baseUrl("https://donkeydeliveries.com/donkey/api/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()