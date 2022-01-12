package com.ziwame.e_commerceapp.service.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class ProductList (
    var products: List<Product>? = null
    )

data class Product (
    var name: String? = null,
    var price: String? = null,
    var image_url: String? = null,
    var rating: Int? = null
    )
