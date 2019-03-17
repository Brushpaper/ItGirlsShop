package com.example.margarita_rezaeva_shop

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_product.*
import kotlinx.android.synthetic.main.product_item.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import android.util.Log
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.list
import kotlinx.serialization.parse

class ProductActivity : AppCompatActivity() {

    lateinit var presenter: ProductsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        val productsUrl = intent.getStringExtra("productsUrl")
        presenter = ProductsPresenter(productsUrl, this)
    }

    override fun onResume() {
        super.onResume()
        presenter.onAppear()
    }

    fun displayProducts(products: List<Product>){
        ProductListView.adapter = ProductAdapter(products, this@ProductActivity)
    }

}