package com.example.margarita_rezaeva_shop

import android.content.Context
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.product_item.view.*
import org.jetbrains.anko.layoutInflater
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.wrapContent

class CategoryAdapter (

    val categories: List<Category>,
    val context: Context

) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(recycleView: ViewGroup, ViewType: Int) = run {
        val view = context.layoutInflater.inflate(
            R.layout.category_item,
            recycleView,
            false
        )
        ViewHolder(view)
    }

    override fun getItemCount(): Int = categories.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = categories[position]
        holder.itemView.nameView.text = category.name

        Picasso.get()
            .load(category.imageURL)
            .into(holder.itemView.pictureView)

        holder.itemView.onClick {
            if (category.haveSubCategories) {
                context.startActivity<CategoryActivity>("categoriesUrl" to category.url)
            } else {
                context.startActivity<ProductActivity>("productsUrl" to category.url)
            }
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}