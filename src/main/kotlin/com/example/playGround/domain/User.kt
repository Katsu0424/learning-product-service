package com.example.playGround.domain

data class User(
    val id: UserId,
    val name: String,
)

@JvmInline
value class UserId(
    val value: Long,
) {
    init {
        require(value > 0) { "UserId must be greater than 0" }
    }
}
