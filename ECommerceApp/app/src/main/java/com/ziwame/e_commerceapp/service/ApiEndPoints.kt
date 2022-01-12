package com.ziwame.e_commerceapp.service


import com.ziwame.e_commerceapp.service.model.ProductList
import retrofit2.Call
import retrofit2.http.*





interface ApiEndPoints {
    @GET
    fun getGadgetList(@Url url: String?): Call<ProductList?>
}

