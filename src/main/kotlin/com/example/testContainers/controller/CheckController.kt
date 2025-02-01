package com.example.testContainers.controller

import org.springframework.context.annotation.Profile
import org.springframework.core.env.Environment
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/check")
@Profile("local", "docker")
class CheckController(
    private val environment: Environment,
) {
    @GetMapping("/profile")
    fun getProfile(): ResponseEntity<String> {
        val profile = environment.activeProfiles.joinToString(", ")
        return ResponseEntity.ok(profile)
    }
}
