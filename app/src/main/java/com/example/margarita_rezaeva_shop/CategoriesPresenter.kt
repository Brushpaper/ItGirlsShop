package com.example.margarita_rezaeva_shop

import android.content.Context
import kotlinx.serialization.json.Json
import kotlinx.serialization.list
import org.kodein.di.direct
import org.kodein.di.generic.instance


class CategoriesPresenter(
    val categoriesUrl: String,
    val view: CategoryActivity
) {
    val requestMaker = di.direct.instance<RequestMaker>()
    fun onAppear() {
        updateCategories()
    }

    fun onRefresh(){
        updateCategories()
    }

    fun updateCategories(){
        requestMaker.make(
            categoriesUrl,
            onResult = { categoriesJson ->
                val categories = Json.parse(Category.serializer().list, categoriesJson)
                view.displayCategories(categories)
            },
            onError = {
                view.displayError()
            }
        )
    }
}