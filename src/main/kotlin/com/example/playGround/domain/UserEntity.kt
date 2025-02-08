package com.example.playGround.domain

import org.jetbrains.exposed.dao.id.LongIdTable

// Define the table name
object UserEntity : LongIdTable("user") {
    val name = varchar("name", length = 50)
}
