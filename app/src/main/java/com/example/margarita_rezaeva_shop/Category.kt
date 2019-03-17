package com.example.margarita_rezaeva_shop

import kotlinx.serialization.Serializable

@Serializable
    data class Category(
        val underCategoriesUrl: String,
        val name: String,
        val imageURL: String
    )