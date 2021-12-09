package com.example.fitarmorapp.adapter

import com.example.fitarmorapp.models.Products

interface ProductsListener {
    fun OnProductsClick(product: Products, position: Int)
}