package com.example.data.repositories.authRepository

import com.example.data.dto.auth.PermissionDto
import com.example.data.dto.auth.RoleDto
import com.example.data.dto.auth.UserDto

interface UserRepository {

    suspend fun getUserByUserName(username: String): UserDto?

    suspend fun getListOfRolesName(): List<RoleDto>

    suspend fun checkIfRoleExistByRoleId(roleId :Int): Boolean

    suspend fun getWhatIsTheUserPermissionsByUserRole(userRole:String):List<PermissionDto>

    suspend fun insertUser(user: UserDto): Boolean

    suspend fun updateUserPassword(user: UserDto): Boolean

    suspend fun deleteUser(username: String): Boolean
}