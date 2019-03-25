package com.example.margarita_rezaeva_shop

import android.content.Context
import kotlinx.serialization.json.Json
import kotlinx.serialization.list
import org.kodein.di.direct
import org.kodein.di.generic.instance

class ProductsPresenter(
    val productsUrl: String,
    val view: ProductActivity
) {
    val requestMaker = di.direct.instance<RequestMaker>()
    fun onAppear() {
        updateProducts()
    }

    fun onRefresh() {
        updateProducts()
    }

    fun updateProducts() {
        requestMaker.make(
            productsUrl,
            onResult = { productsJson ->
                val products = Json.parse(Product.serializer().list, productsJson)
                view.displayProducts(products)
            },
            onError = {
                view.displayError()
            }
        )
    }
}