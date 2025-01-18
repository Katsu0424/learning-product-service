package com.example.testContainers

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class TestContainersApplication

fun main(args: Array<String>) {
    runApplication<TestContainersApplication>(*args)
}
