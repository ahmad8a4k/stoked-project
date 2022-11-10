package com.example.utils

import com.example.data.response.MessageResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*

suspend fun ApplicationCall.notFoundResponse() {
     return respond(
         status = HttpStatusCode.NotFound,
         MessageResponse(false,"")
     )
}