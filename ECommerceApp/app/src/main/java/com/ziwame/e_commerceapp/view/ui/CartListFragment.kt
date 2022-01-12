package com.ziwame.e_commerceapp.view.ui

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.ziwame.e_commerceapp.MainActivity
import com.ziwame.e_commerceapp.R
import com.ziwame.e_commerceapp.databinding.FragmentCartListBinding
import com.ziwame.e_commerceapp.databinding.FragmentGadgetListBinding
import com.ziwame.e_commerceapp.service.model.CartProduct
import com.ziwame.e_commerceapp.service.model.Product
import com.ziwame.e_commerceapp.viewmodel.CartViewModel
import com.ziwame.e_commerceapp.viewmodel.GadgetListViewModel

class CartListFragment : Fragment(), CartListAdapter.DataListener {
    private lateinit var binding: FragmentCartListBinding
    lateinit var adapter: CartListAdapter
    private lateinit var cartViewModel: CartViewModel
    private var cartList: List<CartProduct>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_cart_list, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(false)
        cartViewModel = ViewModelProvider(this).get(CartViewModel::class.java)
        cartViewModel.readAllData.observe(viewLifecycleOwner, Observer { cart ->
            cartList = cart
            if (cartList?.size!! > 0) {
                initializeAdapter()
                binding.checkOut.visibility = View.VISIBLE
                binding.error.visibility = View.GONE
            } else {
                binding.recyclerView.visibility = View.GONE
                binding.checkOut.visibility = View.GONE
                binding.error.visibility = View.VISIBLE
            }
        })
    }

    fun initializeAdapter() {
        binding.checkOut.setOnClickListener {
            deleteAllUsers()
        }
        binding.recyclerView.setLayoutManager(GridLayoutManager(context, 1))
        adapter = CartListAdapter(
            requireContext(),
            cartList, this
        )
        binding.recyclerView.isNestedScrollingEnabled = false
        binding.recyclerView.adapter = adapter
    }

    private fun deleteAllUsers() {
        cartViewModel.deleteAllUsers()
        findNavController().navigate(R.id.action_cart_to_order)

    }

    override fun onClickListener(position: Int) {

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        val userItem = menu.findItem(R.id.cart)
        var actionView = userItem.actionView
        actionView.visibility = View.GONE
    }

}