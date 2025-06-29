package com.example.learningProductService.product

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/products")
class ProductController(
    private val productRepository: ProductRepository,
) {
    @GetMapping
    fun getAllProducts(): List<Product> = productRepository.findAll()

    @PostMapping
    fun createProduct(@RequestBody product: Product): ProductId = productRepository.create(product)

    @GetMapping("/{id}")
    fun getProductById(@PathVariable id: Long): ResponseEntity<Product> {
        return productRepository.findById(ProductId(id))
            ?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()
    }
}
