package com.example.margarita_rezaeva_shop

import kotlinx.serialization.json.Json
import kotlinx.serialization.list

class UnderCategoriesPresenter(
    val underCategoriesUrl: String,
    val view: UnderCategoryActivity
) {
    val requestMaker = getRequestMaker()
    fun onAppear() {
        requestMaker.make(
            underCategoriesUrl,
            onResult = { underCategoriesJson ->
                val underCategories = Json.parse(UnderCategory.serializer().list, underCategoriesJson)
                view.displayCategories(underCategories)
            }
        )
    }
}