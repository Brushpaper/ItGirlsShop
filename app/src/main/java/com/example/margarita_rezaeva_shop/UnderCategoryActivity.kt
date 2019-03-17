package com.example.margarita_rezaeva_shop

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_category.*
import kotlinx.android.synthetic.main.activity_under_category.*

class UnderCategoryActivity : AppCompatActivity() {

    lateinit var presenter: UnderCategoriesPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_under_category)
        val underCategoriesUrl = intent.getStringExtra("underCategoriesUrl")
        presenter = UnderCategoriesPresenter(underCategoriesUrl, this)
    }

    override fun onResume() {
        super.onResume()
        presenter.onAppear()
    }

    fun displayCategories(underCategories: List<UnderCategory>) {
        UnderCategoryListView.adapter = UnderCategoryAdapter(underCategories, this@UnderCategoryActivity)
    }
}