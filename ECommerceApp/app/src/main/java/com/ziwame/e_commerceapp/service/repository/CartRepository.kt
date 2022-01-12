package com.ziwame.e_commerceapp.service.repository

import androidx.lifecycle.LiveData
import com.example.roomapp.data.UserDao
import com.ziwame.e_commerceapp.service.model.CartProduct

class CartRepository(private val userDao: UserDao) {

    val readAllData: LiveData<List<CartProduct>> = userDao.readAllData()

    suspend fun addUser(cartProduct: CartProduct){
        userDao.addProduct(cartProduct)
    }

    suspend fun updateUser(cartProduct: CartProduct){
        userDao.updateProduct(cartProduct)
    }

    suspend fun deleteUser(cartProduct: CartProduct){
        userDao.deleteProduct(cartProduct)
    }

    suspend fun deleteAllProducts(){
        userDao.deleteAllProducts()
    }

}