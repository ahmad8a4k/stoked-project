package com.example.data.tables.authTables

import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object PermissionsTable : Table<Nothing>("permissions") {
    val permissionId = int("permission_id").primaryKey()
    val permissionName = varchar("permission_name")
    val permissionDescription = varchar("permission_description")
}