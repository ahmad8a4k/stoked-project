package com.example.data.request.auth

import kotlinx.serialization.Serializable

@Serializable
data class UserSignIn(
    val username :String,
    val password:String
)
