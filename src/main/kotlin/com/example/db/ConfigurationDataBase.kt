package com.example.db

import com.example.dataBase
import com.example.utils.Constants.STOCKED_DATABASE_DRIVER
import com.example.utils.Constants.STOCKED_DATABASE_PASSWORD
import com.example.utils.Constants.STOCKED_DATABASE_USER
import com.example.utils.Constants.STOCKED_DATABASE_URL
import io.ktor.server.application.*
import org.ktorm.database.Database
import org.ktorm.support.mysql.MySqlDialect

fun Application.configurationDataBase(){
    dataBase = Database.connect(
        url = STOCKED_DATABASE_URL,
        driver = STOCKED_DATABASE_DRIVER,
        user = STOCKED_DATABASE_USER,
        password = STOCKED_DATABASE_PASSWORD,
        dialect = MySqlDialect(),
    )
}