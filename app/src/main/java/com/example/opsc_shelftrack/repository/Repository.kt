package com.example.opsc_shelftrack.repository

import com.example.opsc_shelftrack.Models.User
import com.example.opsc_shelftrack.api.RetrofitInstance

class Repository {

    suspend fun getUser(): User {
       return RetrofitInstance.api.getUser()
    }
}