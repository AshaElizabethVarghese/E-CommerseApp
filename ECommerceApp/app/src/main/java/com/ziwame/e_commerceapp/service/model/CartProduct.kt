package com.ziwame.e_commerceapp.service.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity(tableName = "cart_table")
data class CartProduct(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var name: String? = null,
    var price: String? = null,
    var image_url: String? = null,
    var rating: Int? = null
): Parcelable