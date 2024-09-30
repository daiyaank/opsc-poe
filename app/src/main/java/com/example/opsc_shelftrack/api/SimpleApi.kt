package com.example.opsc_shelftrack.api

import com.example.opsc_shelftrack.Models.User
import retrofit2.http.GET

interface SimpleApi {

    @GET("users/1")
    suspend fun getUser(): User

}