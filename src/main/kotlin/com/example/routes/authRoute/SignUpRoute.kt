package com.example.routes

import com.example.data.request.auth.UserRegisterRequest
import com.example.data.response.AuthResponse
import com.example.domin.endPoints.AuthenticationEndPoint
import com.example.data.dto.auth.UserDto
import com.example.data.repositories.authRepository.UserRepository
import com.example.security.HashingService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.signUpRoute(
    userDataSource: UserRepository,
    hashingService: HashingService,
) {
    post(AuthenticationEndPoint.SignUp.path) {
        val request = call.receiveOrNull<UserRegisterRequest>() ?: kotlin.run {
            call.respond(
                status = HttpStatusCode.BadRequest,
                message = AuthResponse(
                    success = false,
                    token = "",
                    message = "INCORRECT REQUEST"
                )
            )
            return@post
        }

        val areFieldsBlank = request.username.isBlank() || request.password.isBlank()
        val isPwTooShort = request.password.length < 8

        if (areFieldsBlank || isPwTooShort) {
            call.respond(
                status = HttpStatusCode.Conflict,
                message = AuthResponse(
                    success = false,
                    token = "",
                    message = "EMPTY USERNAME OR PASSWORD OR PASSWORD IS LESS THEN 8 CHARACTER"
                )
            )
            return@post
        }

        val saltedHash = hashingService.generateSaltedHash(value = request.password)

        if(!userDataSource.checkIfRoleExistByRoleId(request.userRole)){
            call.respond(
                status = HttpStatusCode.Conflict,
                message = AuthResponse(
                    success = false,
                    token = "",
                    message = "NOT EXIST USER ROLE"
                )
            )
            return@post
        }

        val user = UserDto(
            userId = 0,
            userRole = request.userRole,
            username = request.username,
            userPassword = saltedHash.hash,
            userSalt = saltedHash.salt
        )

        val wasAcknowledged = userDataSource.insertUser(user)

        if (!wasAcknowledged) {
            call.respond(
                status = HttpStatusCode.Conflict,
                message = AuthResponse(
                    success = false,
                    token = "",
                    message = "USER ALREADY EXIST!"
                )
            )
            return@post
        }

        call.respond(
            status = HttpStatusCode.OK,
            message = AuthResponse(
                success = true,
                token = "",
                message = "SUCCESS SIGNUP"
            )
        )
    }
}