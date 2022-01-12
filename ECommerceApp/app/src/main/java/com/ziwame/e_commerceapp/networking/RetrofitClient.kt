package com.deliverain.log_automation.networking



import com.google.gson.GsonBuilder
import com.ziwame.e_commerceapp.service.ApiEndPoints
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient{

    val client = OkHttpClient.Builder()
            .connectTimeout(50, TimeUnit.SECONDS)
            .readTimeout(50, TimeUnit.SECONDS)
            .writeTimeout(50, TimeUnit.SECONDS)
            .build()
    val instance: ApiEndPoints by lazy{


        val retrofit = Retrofit.Builder()
            .baseUrl("https://my-json-server.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().serializeNulls().create()))
            .client(client)
            .build()

        retrofit.create(ApiEndPoints::class.java)

    }

}