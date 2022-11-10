package com.example.data.tables.authTables

import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object RolesTable : Table<Nothing>("roles") {
    val RolesId = int("roles_id").primaryKey()
    val RolesName = varchar("roles_name")
    val RolesDescription = varchar("roles_description")
}