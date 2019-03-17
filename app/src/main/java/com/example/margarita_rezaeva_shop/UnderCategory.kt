package com.example.margarita_rezaeva_shop

import kotlinx.serialization.Serializable


@Serializable
data class UnderCategory(
    val productsUrl: String,
    val name: String,
    val imageURL: String
)