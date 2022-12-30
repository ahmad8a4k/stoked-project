package com.example.plugins.routing

import com.example.token.TokenConfig
import com.example.data.repositories.userRepository.UserRepositoryImpl
import com.example.domin.useCases.SignUpUseCase
import com.example.routes.userRoute.*
import com.example.security.SHA256HashingServiceImpl
import com.example.token.JwtTokenServiceImpl
import io.ktor.server.routing.*
import io.ktor.server.application.*

fun Application.authConfigRouting() {
    val hashingService = SHA256HashingServiceImpl()
    val tokenService = JwtTokenServiceImpl()

    routing {
        getSecretInfoRoute()
        signUpRoute()
//        signInRoute(useRepository, hashingService, tokenService, tokenConfig)
        authenticateRoute()
//        deleteUserRoute(useRepository, hashingService)
//        updatePasswordRoute(useRepository, hashingService, tokenService, tokenConfig)
    }
}
