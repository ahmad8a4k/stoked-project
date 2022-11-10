package com.example.routes.authRoute

import com.example.data.response.AuthResponse
import com.example.domin.endPoints.AuthenticationEndPoint
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.authenticateRoute(){
    authenticate{
        get(AuthenticationEndPoint.Authenticate.path){
            call.respond(
                status = HttpStatusCode.OK,
                message = AuthResponse(
                    success = true,
                    token = "",
                    message = "SUCCESS AUTHENTICATED"
                )
            )
        }
    }
}