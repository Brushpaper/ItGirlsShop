package com.example.margarita_rezaeva_shop

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.product_item.view.*
import org.jetbrains.anko.layoutInflater
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

data class UnderCategoryAdapter (

    val underCategories: List<UnderCategory>,
    val context: Context

) : RecyclerView.Adapter<UnderCategoryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(recycleView: ViewGroup, ViewType: Int) = run {
        val view = context.layoutInflater.inflate(
            R.layout.category_item,
            recycleView,
            false
        )
        ViewHolder(view)
    }

    override fun getItemCount(): Int = underCategories.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val underCategory = underCategories[position]
        holder.itemView.nameView.text = underCategory.name

        Picasso.get()
            .load(underCategory.imageURL)
            .into(holder.itemView.pictureView)

        holder.itemView.onClick {
            context.startActivity<ProductActivity> ("productsUrl" to underCategory.productsUrl)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}