package com.example.routes.userRoute

import com.example.data.repositories.userRepository.UserRepository
import com.example.security.HashingService
import com.example.token.TokenConfig
import com.example.token.TokenService
import io.ktor.server.routing.*

fun Route.signInRoute(
    userDataSource: UserRepository,
    hashingService: HashingService,
    tokenService: TokenService,
    tokenConfig: TokenConfig,
) {
//    post(AuthenticationEndPoint.SignIn.path) {
//
//        val request = call.receiveOrNull<UserSignIn>() ?: kotlin.run {
//            call.respond(HttpStatusCode.BadRequest)
//            return@post
//        }
//
//        val user = userDataSource.getUserByUserName(request.username)
//
//        if (user == null) {
//            call.respond(
//                HttpStatusCode.Conflict,
//                message = AuthResponse(
//                    success = false,
//                    token = "",
//                    message = "INCORRECT USERNAME OR PASSWORD"
//                )
//            )
//            return@post
//        }
//
//        val isValidPassword = hashingService.verify(
//            value = request.password,
//            saltedHash = SaltedHash(
//                hash = user.userPassword,
//                salt = user.userSalt
//            )
//        )
//
//        if (!isValidPassword) {
//            call.respond(
//                HttpStatusCode.Conflict,
//                message = AuthResponse(
//                    success = false,
//                    token = "",
//                    message = "INCORRECT PASSWORD"
//                )
//            )
//            return@post
//        }
//
//        val token = tokenService.generate(
//            config = tokenConfig,
//            Token(
//                name = "userId",
//                value = user.username
//            )
//        )
//
//        call.respond(
//            status = HttpStatusCode.OK,
//            message = AuthResponse(
//                success = true,
//                token = token,
//                message = "SUCCESS SIGN IN"
//            )
//        )
//    }
}