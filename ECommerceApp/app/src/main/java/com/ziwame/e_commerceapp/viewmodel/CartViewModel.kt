package com.ziwame.e_commerceapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.roomapp.data.UserDatabase
import com.ziwame.e_commerceapp.service.model.CartProduct
import com.ziwame.e_commerceapp.service.repository.CartRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CartViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<CartProduct>>
    private val repository: CartRepository

    init {
        val userDao = UserDatabase.getDatabase(
            application
        ).userDao()
        repository = CartRepository(userDao)
        readAllData = repository.readAllData
    }

    fun addUser(cartProduct: CartProduct){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(cartProduct)
        }
    }

    fun updateUser(cartProduct: CartProduct){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateUser(cartProduct)
        }
    }

    fun deleteUser(cartProduct: CartProduct){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteUser(cartProduct)
        }
    }

    fun deleteAllUsers(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllProducts()
        }
    }

}