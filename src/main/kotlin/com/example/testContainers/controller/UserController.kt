package com.example.testContainers.controller

import com.example.testContainers.domain.UserId
import com.example.testContainers.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/users")
class UserController(
    private val userService: UserService,
) {
    @GetMapping("/{id}")
    fun findById(
        @PathVariable id: Long,
    ): ResponseEntity<UserResponse> {
        val user = userService.findById(UserId(id))
        return if (user != null) { ResponseEntity.ok(UserResponse(user.id, user.name)) } else { ResponseEntity.notFound().build()  }
    }

    data class UserResponse(
        val id: UserId,
        val name: String,
    )

    @PostMapping
    fun create(
        @RequestBody form: UserCreateRequestForm,
    ): ResponseEntity<UserCreateResponse> {
        val userId =
            userService.create(
                UserService.UserCreateRequest(
                    name = form.name,
                ),
            )

        return ResponseEntity.ok(
            UserCreateResponse(
                id = userId.value,
            ),
        )
    }

    data class UserCreateRequestForm(
        val name: String,
    )

    data class UserCreateResponse(
        val id: Long,
    )

    // Update User
    @PutMapping("/{id}")
    fun updateById(
        @PathVariable id: Long,
        @RequestBody form: UserUpdateRequestForm,
    ): ResponseEntity<Unit> {
        userService.updateById(
            id = id,
            request =
                UserService.UserUpdateRequest(
                    name = form.name,
                ),
        )

        return ResponseEntity.ok().build()
    }

    data class UserUpdateRequestForm(
        val name: String,
    )

    // Delete User
    @DeleteMapping("/{id}")
    fun deleteById(
        @PathVariable id: Long,
    ): ResponseEntity<Unit> {
        userService.deleteById(UserId(id))

        return ResponseEntity.noContent().build()
    }
}
