package com.example.margarita_rezaeva_shop

import kotlinx.serialization.json.Json


class CategoriesPresenter(
    val categoriesUrl: String,
    val view: CategoryActivity
) {
    val requestMaker = getRequestMaker()
    fun onAppear() {
        requestMaker.make(
            categoriesUrl,
            onResult = { categoriesJson ->
                val categories = Json.parse(Category.serializer().list, categoriesJson)
                view.displayCategories(categories)
            }
        )
    }
}