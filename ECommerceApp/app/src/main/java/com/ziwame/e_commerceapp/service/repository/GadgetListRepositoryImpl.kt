package com.ziwame.e_commerceapp.service.repository

import com.deliverain.log_automation.networking.RetrofitClient
import com.ziwame.e_commerceapp.service.model.ProductList
import com.ziwame.e_commerceapp.viewmodel.GadgetListViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GadgetListRepositoryImpl :GadgetListrepository{
    override fun getGadgets(viewModel: GadgetListViewModel) {
        viewModel.url?.let {
            RetrofitClient.instance.getGadgetList(it).enqueue(object : Callback<ProductList?> {
                override fun onFailure(call: Call<ProductList?>, t: Throwable) {
                    println("failed")
                    println(t)
                    viewModel.gadgetListObject.value = null
                }

                override fun onResponse(
                    call: Call<ProductList?>,
                    response: Response<ProductList?>
                ) {
                    println("login response")
                    println(response.body())
                    viewModel.gadgetListObject.value = response.body()
                }

            })
        }
    }

}
