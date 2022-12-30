package com.example.data.source.dao.userDao

import com.example.data.dto.user.UserDto
import com.example.data.mapper.toUserEntity
import com.example.data.tables.authTables.UserTable
import com.example.db.user
import com.example.utils.checkIfExistByName
import org.ktorm.database.Database
import org.ktorm.entity.add

class UserDaoImpl constructor(
    private var dataBase: Database,
) : UserDao {

    override suspend fun checkIfUserExistByName(username: String): Boolean {
        return dataBase.checkIfExistByName(UserTable.userName, username)
    }

    override suspend fun insertUser(user: UserDto): Boolean {
        return dataBase.user.add(user.toUserEntity()) == 1
    }

    override suspend fun updateUserPassword(user: UserDto): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun deleteUser(username: String): Boolean {
        TODO("Not yet implemented")
    }


}