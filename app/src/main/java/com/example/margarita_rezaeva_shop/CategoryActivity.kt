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
import kotlinx.android.synthetic.main.activity_category.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.list
import kotlinx.serialization.parse

class CategoryActivity : AppCompatActivity() {

    val categoriesUrl =
        "https://gist.githubusercontent.com/Brushpaper/d02ded2ce3dba9ffdd6b69bd9fb55fe7/raw/ba07fba54cafa046e3e613f3c5fef437344bd138/Categories.json"

    val presenter = CategoriesPresenter(categoriesUrl, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
    }

    override fun onResume() {
        super.onResume()
        presenter.onAppear()
    }

    fun displayCategories(categories: List<Category>) {
        CategoryListView.adapter = CategoryAdapter(categories, this@CategoryActivity)
    }
}