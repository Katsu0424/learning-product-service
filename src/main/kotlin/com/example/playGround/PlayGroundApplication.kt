package com.example.playGround

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class PlayGroundApplication

fun main(args: Array<String>) {
    runApplication<PlayGroundApplication>(*args)
}
