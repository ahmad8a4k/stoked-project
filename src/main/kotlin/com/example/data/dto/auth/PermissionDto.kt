package com.example.data.dto.auth

import kotlinx.serialization.Serializable

@Serializable
data class PermissionDto(
    val permissionId: Int,
    val permissionName: String,
    val permissionDescription: String,
)