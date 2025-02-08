package com.example.playGround.controller

import com.example.playGround.domain.UserId
import com.example.playGround.service.UserService
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs
import io.mockk.verify
import org.springframework.http.HttpStatus

class UserControllerTest(
    private val userService: UserService = mockk(),
    private val userController: UserController = UserController(userService),
) : DescribeSpec({

        describe("UserController#findById") {
            context("ユーザが存在するとき") {
                it("HTTP 200(OK) とユーザ情報を返す") {
                    // given
                    val userIdValue = 1L
                    val userId = UserId(userIdValue)
                    val user =
                        com.example.playGround.domain.User(
                            id = userId,
                            name = "Alice",
                        )
                    every { userService.findById(userId) } returns user

                    // when
                    val response = userController.findById(userIdValue)

                    // then
                    response.statusCode shouldBe HttpStatus.OK
                    response.body?.id shouldBe userId
                    response.body?.name shouldBe "Alice"

                    // verify
                    verify(exactly = 1) { userService.findById(userId) }
                }
            }

            context("ユーザが存在しないとき") {
                it("HTTP 404(NotFound) を返す") {
                    // given
                    val userIdValue = 999L
                    val userId = UserId(userIdValue)
                    every { userService.findById(userId) } returns null

                    // when
                    val response = userController.findById(userIdValue)

                    // then
                    response.statusCode shouldBe HttpStatus.NOT_FOUND
                    response.body shouldBe null

                    // verify
                    verify(exactly = 1) { userService.findById(userId) }
                }
            }
        }

        describe("UserController#create") {
            it("HTTP 200(OK) と作成したユーザIDを返す") {
                // given
                val form = UserController.UserCreateRequestForm(name = "new user")
                val createdUserId = UserId(10L)
                every { userService.create(any()) } returns createdUserId

                // when
                val response = userController.create(form)

                // then
                response.statusCode shouldBe HttpStatus.OK
                response.body?.id shouldBe createdUserId.value

                // verify
                verify(exactly = 1) {
                    userService.create(
                        withArg {
                            it.name shouldBe "new user"
                        },
                    )
                }
            }
        }

        describe("UserController#updateById") {
            it("HTTP 200(OK) を返す") {
                // given
                val userIdValue = 2L
                val form = UserController.UserUpdateRequestForm(name = "updated user name")
                every { userService.updateById(userIdValue, any()) } just runs

                // when
                val response = userController.updateById(userIdValue, form)

                // then
                response.statusCode shouldBe HttpStatus.OK
                response.body shouldBe null

                // verify
                verify(exactly = 1) {
                    userService.updateById(
                        userIdValue,
                        withArg {
                            it.name shouldBe "updated user name"
                        },
                    )
                }
            }
        }

        describe("UserController#deleteById") {
            it("HTTP 204(NoContent) を返す") {
                // given
                val userIdValue = 3L
                every { userService.deleteById(UserId(userIdValue)) } just runs

                // when
                val response = userController.deleteById(userIdValue)

                // then
                response.statusCode shouldBe HttpStatus.NO_CONTENT
                response.body shouldBe null // ボディなし

                // verify
                verify(exactly = 1) {
                    userService.deleteById(UserId(userIdValue))
                }
            }
        }
    })
