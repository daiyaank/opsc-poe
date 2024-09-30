package com.example.opsc_shelftrack

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.opsc_shelftrack.Models.User
import com.example.opsc_shelftrack.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository) : ViewModel() {

    val myResponse: MutableLiveData<User> = MutableLiveData()

    fun getUser() {
        viewModelScope.launch{
            val response = repository.getUser()
            myResponse.value = response
        }
    }
}