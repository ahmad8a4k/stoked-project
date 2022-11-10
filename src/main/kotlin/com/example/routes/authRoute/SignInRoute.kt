package com.example.routes.authRoute

import com.example.data.request.auth.UserRegisterRequest
import com.example.data.response.AuthResponse
import com.example.data.repositories.authRepository.UserRepository
import com.example.security.HashingService
import com.example.security.SaltedHash
import com.example.token.Token
import com.example.token.TokenConfig
import com.example.token.TokenService
import com.example.domin.endPoints.AuthenticationEndPoint
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.apache.commons.codec.digest.DigestUtils

fun Route.signInRoute(
    userDataSource: UserRepository,
    hashingService: HashingService,
    tokenService: TokenService,
    tokenConfig: TokenConfig,
) {
    post(AuthenticationEndPoint.SignIn.path) {

        val request = call.receiveOrNull<UserRegisterRequest>() ?: kotlin.run {
            call.respond(HttpStatusCode.BadRequest)
            return@post
        }

        val user = userDataSource.getUserByUserName(request.username)

        if (user == null) {
            call.respond(
                HttpStatusCode.Conflict,
                message = AuthResponse(
                    success = false,
                    token = "",
                    message = "INCORRECT USERNAME OR PASSWORD"
                )
            )
            return@post
        }

        val isValidPassword = hashingService.verify(
            value = request.password,
            saltedHash = SaltedHash(
                hash = user.userPassword,
                salt = user.userSalt
            )
        )

        if (!isValidPassword) {
            println(
                "Entered hash: ${DigestUtils.sha256Hex("${user.userSalt}${request.password}")}," +
                        " Hashed PW: ${user.userPassword}"
            )
            call.respond(
                HttpStatusCode.Conflict,
                message = AuthResponse(
                    success = false,
                    token = "",
                    message = "INCORRECT PASSWORD"
                )
            )
            return@post
        }

        val token = tokenService.generate(
            config = tokenConfig,
            Token(
                name = "userId",
                value = user.username
            )
        )

        call.respond(
            status = HttpStatusCode.OK,
            message = AuthResponse(
                success = true,
                token = token,
                message = "SUCCESS SIGN IN"
            )
        )
    }
}