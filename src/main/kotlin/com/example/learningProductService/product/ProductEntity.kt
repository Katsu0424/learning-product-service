package com.example.learningProductService.product

import org.jetbrains.exposed.dao.id.LongIdTable

// Define the table name
object ProductEntity : LongIdTable("product") {
    val name = varchar("name", length = 50)
}