package com.example.margarita_rezaeva_shop

import kotlinx.serialization.Serializable

@Serializable
    data class Product(
        val name: String,
        val imageURL: String
    )