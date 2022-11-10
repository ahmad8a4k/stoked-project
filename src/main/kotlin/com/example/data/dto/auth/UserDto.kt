package com.example.data.dto.auth

import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    val userId: Int,
    val userRole :Int,
    val username:String,
    val userPassword:String,
    val userSalt:String
)