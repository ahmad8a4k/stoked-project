package com.example.plugins.routing

import com.example.token.TokenConfig
import com.example.data.repositories.authRepository.UseRepositoryImpl
import com.example.routes.*
import com.example.routes.authRoute.authenticateRoute
import com.example.routes.authRoute.deleteUserRoute
import com.example.routes.authRoute.getSecretInfoRoute
import com.example.routes.authRoute.signInRoute
import com.example.security.SHA256HashingServiceImpl
import com.example.token.JwtTokenServiceImpl
import io.ktor.server.routing.*
import io.ktor.server.application.*

fun Application.authConfigRouting(tokenConfig: TokenConfig) {
    val useRepository = UseRepositoryImpl()
    val hashingService = SHA256HashingServiceImpl()
    val tokenService = JwtTokenServiceImpl()

    routing {
        getSecretInfoRoute()
        signUpRoute(useRepository, hashingService)
        signInRoute(useRepository, hashingService, tokenService, tokenConfig)
        authenticateRoute()
        deleteUserRoute(useRepository, hashingService)
        updatePasswordRoute(useRepository, hashingService, tokenService, tokenConfig)
    }
}
