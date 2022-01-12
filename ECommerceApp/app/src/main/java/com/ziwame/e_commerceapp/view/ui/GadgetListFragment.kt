package com.ziwame.e_commerceapp.view.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.ziwame.e_commerceapp.MainActivity
import com.ziwame.e_commerceapp.R
import com.ziwame.e_commerceapp.databinding.FragmentGadgetListBinding
import com.ziwame.e_commerceapp.service.model.CartProduct
import com.ziwame.e_commerceapp.service.model.Product
import com.ziwame.e_commerceapp.view.callback.OnFragmentActionListener
import com.ziwame.e_commerceapp.viewmodel.CartViewModel
import com.ziwame.e_commerceapp.viewmodel.GadgetListViewModel

class GadgetListFragment : Fragment(), GadgetListAdapter.DataListener {
    private lateinit var binding: FragmentGadgetListBinding
    lateinit var adapter: GadgetListAdapter
    lateinit var callBack: OnFragmentActionListener
    private lateinit var viewModel: GadgetListViewModel
    private lateinit var cartViewModel: CartViewModel
    private lateinit var productList: List<Product>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_gadget_list, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        callBack.onProgressBarLoad(true)
        cartViewModel = ViewModelProvider(this).get(CartViewModel::class.java)
        viewModel = ViewModelProviders.of(this).get(GadgetListViewModel::class.java)
        viewModel.userLogin(viewModel)
        viewModel.gadgetListObject.observe(viewLifecycleOwner, Observer {
            it.let {
                callBack.onProgressBarLoad(false)
                productList = it.products!!
                initializeAdapter()
            }

        })
    }

    fun initializeAdapter() {

        binding.recyclerView.setLayoutManager(GridLayoutManager(context, 1))
        adapter = GadgetListAdapter(
            requireContext(),
            productList, this
        )
        binding.recyclerView.isNestedScrollingEnabled = false
        binding.recyclerView.adapter = adapter
    }

    override fun onClickListener(position: Int) {
        addProductToDatabase(position)
    }

    private fun addProductToDatabase(position: Int) {
        val cartProduct = CartProduct(
            0,
            productList[position].name,
            productList[position].price,
            productList[position].image_url,
            productList[position].rating
        )
        cartViewModel.addUser(cartProduct)
        Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_LONG).show()

    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentActionListener) {
            callBack = context
        } else {
            throw ClassCastException(context.toString())
        }
    }
}