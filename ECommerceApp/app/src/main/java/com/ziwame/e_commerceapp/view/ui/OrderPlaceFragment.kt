package com.ziwame.e_commerceapp.view.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.ziwame.e_commerceapp.R
import com.ziwame.e_commerceapp.databinding.FragmentCartListBinding
import com.ziwame.e_commerceapp.databinding.FragmentOrderPlaceBinding

class OrderPlaceFragment : Fragment() {

    private lateinit var binding: FragmentOrderPlaceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_order_place, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.continueShopping.setOnClickListener {
            findNavController().navigate(R.id.action_order_to_productlist)

        }
    }

}