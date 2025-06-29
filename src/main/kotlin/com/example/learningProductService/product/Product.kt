package com.example.learningProductService.product

data class Product(
    val id: ProductId,
    val name: String
)

@JvmInline
value class ProductId(
    val value: Long,
) {
    init {
        require(value > 0) { "Product must be greater than 0" }
    }
}