package com.example.data.tables.authTables

import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object UserTable: Table<Nothing>("users"){
    val userId = int("user_id").primaryKey()
    val userRole = int("user_role")
    val userName = varchar("user_name")
    val userPassword = varchar("user_password")
    val userSalt = varchar("user_salt")
}