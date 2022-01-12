package com.ziwame.e_commerceapp.service.repository

import com.ziwame.e_commerceapp.viewmodel.GadgetListViewModel

interface GadgetListrepository {
    fun getGadgets(viewModel: GadgetListViewModel)
}