package com.example.data.request.auth

import kotlinx.serialization.Serializable

@Serializable
data class UserRegisterRequest(
    val userRole :Int,
    val username: String,
    val password: String,
)