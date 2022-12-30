package com.example.routes.userRoute

import com.example.domin.endPoints.AuthenticationEndPoint
import com.example.domin.useCases.SignUpUseCase
import com.example.routes.mapper.userRequestToDto
import com.example.routes.userParameters
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.signUpRoute() {
    val userUseCase by inject<SignUpUseCase>()
    get(AuthenticationEndPoint.SignUp.path) {
        val userParameters = userParameters()
        val signUpUser = userUseCase(userParameters.userRequestToDto())
        call.respond(message = signUpUser, status = signUpUser.statuesCode)
    }
}


