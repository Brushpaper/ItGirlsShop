package com.example.margarita_rezaeva_shop

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.product_item.view.*
import org.jetbrains.anko.layoutInflater
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.wrapContent

class ProductAdapter (

    val products: List<Product>,
    val context: Context

): RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
           override fun onCreateViewHolder(recycleView: ViewGroup, ViewType: Int) = run {
           val view = context.layoutInflater.inflate(
           R.layout.product_item,
           recycleView,
           false
           )
           ViewHolder(view)
           }

           override fun getItemCount(): Int = products.size

           override fun onBindViewHolder(holder: ViewHolder, position: Int) {
           val product = products.get(position)
           holder.itemView.nameView.text = product.name
           holder.itemView.authorView.text = product.author
            //holder.itemView.specialView.text = product.special
          //  holder.itemView.priceView.text = "${product.price}"

           Picasso.get()
           .load(product.imageURL)
           .into(holder.itemView.pictureView)
           }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}
}