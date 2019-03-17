package com.example.margarita_rezaeva_shop

import kotlinx.serialization.json.Json
import kotlinx.serialization.list

class ProductsPresenter(
    val productsUrl: String,
    val view: ProductActivity
) {
    val requestMaker = getRequestMaker()
    fun onAppear() {
        requestMaker.make(
            productsUrl,
            onResult = { productsJson ->
                val products = Json.parse(Product.serializer().list, productsJson)
                view.displayProducts(products)
            }
        )
    }
}