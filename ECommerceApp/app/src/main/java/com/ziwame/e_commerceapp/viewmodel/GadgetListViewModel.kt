package com.ziwame.e_commerceapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ziwame.e_commerceapp.service.repository.GadgetListRepositoryImpl
import com.ziwame.e_commerceapp.service.model.ProductList
import kotlin.properties.Delegates

class GadgetListViewModel : ViewModel(){
    var url:String?="https://my-json-server.typicode.com/nancymadan/assignment/db"
    var gadgetListRepository: GadgetListRepositoryImpl by Delegates.notNull()


    init {
        this.gadgetListRepository= GadgetListRepositoryImpl()

    }

    val gadgetListObject: MutableLiveData<ProductList> by lazy {
        MutableLiveData<ProductList>()
    }


    fun userLogin(viewModel: GadgetListViewModel){
        gadgetListRepository.getGadgets(viewModel)
    }

}