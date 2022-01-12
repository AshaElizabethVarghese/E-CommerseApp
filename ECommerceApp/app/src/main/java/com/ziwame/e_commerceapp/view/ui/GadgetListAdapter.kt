package com.ziwame.e_commerceapp.view.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ziwame.e_commerceapp.R
import com.ziwame.e_commerceapp.service.model.Product

class GadgetListAdapter(
    private var context: Context,
    private var gadgetList: List<Product>,
    private var dataListener: DataListener
) : RecyclerView.Adapter<GadgetListAdapter.DataViewHolder>() {
    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView = itemView.findViewById<ImageView>(R.id.imageView)
        var addtocart = itemView.findViewById<ImageView>(R.id.addtocart)
        var Name = itemView.findViewById<TextView>(R.id.name)
        var Price = itemView.findViewById<TextView>(R.id.price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.gadget_list, parent, false)
        )

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        Glide.with(context).load(gadgetList[position].image_url)
            .into(holder.imageView)
        holder.Price.text = gadgetList[position].price
        holder.Name.text = gadgetList[position].name
        holder.addtocart.setOnClickListener {
            dataListener.onClickListener(position)
        }
    }

    override fun getItemCount(): Int {
        return gadgetList?.size!!
    }

    interface DataListener {
        fun onClickListener(position: Int)
    }
}