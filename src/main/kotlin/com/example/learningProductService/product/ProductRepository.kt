package com.example.learningProductService.product

import org.jetbrains.exposed.sql.insertAndGetId
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
open class ProductRepository {
    @Transactional(readOnly = true)
    open fun findAll(): List<Product> {
        return ProductEntity
            .select(
                ProductEntity.id,
                ProductEntity.name,
            ).map {
                Product(
                    id = ProductId(it[ProductEntity.id].value),
                    name = it[ProductEntity.name],
                )
            }
    }

    @Transactional(readOnly = true)
    open fun findById(id: ProductId): Product? {
        return ProductEntity
            .select(
                ProductEntity.id,
                ProductEntity.name,
            ).where { ProductEntity.id eq id.value }
            .firstOrNull()
            ?.let {
                Product(
                    id = ProductId(it[ProductEntity.id].value),
                    name = it[ProductEntity.name],
                )
            }
    }

    @Transactional
    open fun create(product: Product): ProductId {
        val id =
            ProductEntity.insertAndGetId {
                it[name] = product.name
            }

        return ProductId(id.value)
    }
}