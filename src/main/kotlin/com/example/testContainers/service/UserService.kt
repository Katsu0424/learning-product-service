package com.example.testContainers.service

import com.example.testContainers.domain.User
import com.example.testContainers.domain.UserEntity
import com.example.testContainers.domain.UserId
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insertAndGetId
import org.jetbrains.exposed.sql.update
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
open class UserService {
    // read user by user primary key
    @Transactional(readOnly = true)
    open fun findById(id: UserId): User? {
        // Use Exposed dsl without `transaction { }`
        return UserEntity
            .select(
                UserEntity.id,
                UserEntity.name,
            ).where { UserEntity.id eq id.value }
            .firstOrNull()
            ?.let {
                User(
                    id = UserId(it[UserEntity.id].value),
                    name = it[UserEntity.name],
                )
            }
    }

    // create user
    @Transactional
    open fun create(request: UserCreateRequest): UserId {
        val id =
            UserEntity.insertAndGetId {
                it[name] = request.name
            }

        return UserId(id.value)
    }

    data class UserCreateRequest(
        val name: String,
    )

    // update user
    @Transactional
    open fun updateById(
        id: Long,
        request: UserUpdateRequest,
    ) {
        UserEntity.update({ UserEntity.id eq id }) {
            it[name] = request.name
        }
    }

    data class UserUpdateRequest(
        val name: String,
    )

    // delete user
    @Transactional
    open fun deleteById(id: UserId) {
        UserEntity.deleteWhere { UserEntity.id eq id.value }
    }
}
