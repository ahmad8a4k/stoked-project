package com.example

import com.example.db.configurationDataBase
import com.example.token.TokenConfig
import io.ktor.server.application.*
import com.example.plugins.*
import com.example.plugins.routing.authConfigRouting
import com.example.plugins.routing.productsConfigRouting
import com.example.plugins.routing.stockAppConfigurationRouting
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.ktorm.database.Database

lateinit var dataBase: Database

fun main() {
    embeddedServer(Netty, port = 8080, host = "127.0.0.1") {
        module()
    }.start(wait = true)
}

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {

    val tokenConfig = TokenConfig(
        issuer = "http://127.0.0.1:8080",
        audience = "users",
        expiresIn = 365L * 1000L * 60L * 60L * 24L,
        secret = System.getenv("JWT_SECRET")
    )

    productsConfigRouting()
    stockAppConfigurationRouting()
    configureSecurity(tokenConfig)
    configureSerialization()
    configureMonitoring()
    authConfigRouting(tokenConfig)
    configurationDataBase()
}
