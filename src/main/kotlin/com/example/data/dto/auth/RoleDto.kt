package com.example.data.dto.auth

import kotlinx.serialization.Serializable

@Serializable
data class RoleDto(
    val RolesId :Int,
    val RolesName:String,
    val RolesDescription:String
)