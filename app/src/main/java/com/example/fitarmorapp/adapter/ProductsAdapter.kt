package com.example.fitarmorapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fitarmorapp.R
import com.example.fitarmorapp.models.Products
import com.squareup.picasso.Picasso

class ProductsAdapter (val productsListener: ProductsListener): RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {
    var listProducts = ArrayList<Products>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_product,parent, false))

    override fun onBindViewHolder(holder: ProductsAdapter.ViewHolder, position: Int) {
        val products = listProducts[position]
        holder.tvNameProduct.text = products.nombre
        holder.tvDescripcion.text = products.descripcion
        holder.tvType.text = products.tipo
        holder.tvPriceProduct.text = products.precio
        Picasso.get().load(products.url).into(holder.ivItemProduct)

        holder.itemView.setOnClickListener {
            productsListener.OnProductsClick(products, position)
        }

    }

    override fun getItemCount() = listProducts.size

    fun updateData(data: List<Products>) {
        listProducts.clear()
        listProducts.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNameProduct = itemView.findViewById<TextView>(R.id.tvNameProduct)
        val tvDescripcion = itemView.findViewById<TextView>(R.id.tvDescripcion)
        val tvType = itemView.findViewById<TextView>(R.id.tvType)
        var tvPriceProduct = itemView.findViewById<TextView>(R.id.tvPriceProduct)
        val ivItemProduct = itemView.findViewById<ImageView>(R.id.ivItemProduct)
    }
}