package com.example.roomapp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ziwame.e_commerceapp.service.model.CartProduct
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addProduct(cartProduct: CartProduct)

    @Update
    suspend fun updateProduct(cartProduct: CartProduct)

    @Delete
    suspend fun deleteProduct(cartProduct: CartProduct)

    @Query("DELETE FROM cart_table")
    suspend fun deleteAllProducts()

    @Query("SELECT * FROM cart_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<CartProduct>>

    @Query("SELECT * FROM cart_table WHERE name LIKE :searchQuery")
    fun searchDatabase(searchQuery: String): Flow<List<CartProduct>>

}