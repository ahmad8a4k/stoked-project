package com.example.db

import org.ktorm.database.Database


class DatabaseFactory constructor(private var database: Database) {
    fun init() {
        database.useTransaction {

        }
    }
//    companion object {
//        suspend fun <T> dbQuery(block: suspend () -> T): T =
//            newSuspendedTransaction(Dispatchers.IO) { block() }
//    }
}
//fun Application.configurationDataBase(){
//    dataBase = Database.connect(
//        url = STOCKED_DATABASE_URL,
//        driver = STOCKED_DATABASE_DRIVER,
//        user = STOCKED_DATABASE_USER,
//        password = STOCKED_DATABASE_PASSWORD,
//        dialect = MySqlDialect(),
//    )
//}