package com.example.data.tables.authTables

import org.ktorm.schema.Table
import org.ktorm.schema.int

object RolesPermissionsTable :Table<Nothing>("rolespermissions") {
    val role = int("role")
    val permission = int("permission")
}