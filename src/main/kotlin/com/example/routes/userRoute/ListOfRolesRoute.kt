package com.example.routes.userRoute

import com.example.domin.endPoints.AuthenticationEndPoint
import io.ktor.server.routing.*

fun Route.listOfRoles(){
    post(AuthenticationEndPoint.ListOfRoles.path) {



    }
}