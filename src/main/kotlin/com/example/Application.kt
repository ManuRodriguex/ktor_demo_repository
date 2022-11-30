package com.example

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import com.example.user.MongoUserDataSource
import com.example.user.User
import com.example.user.UserDataSource
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

fun main() {
    embeddedServer(Netty,
        port = 8080,
        host = "127.0.0.1",
        module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    val mongoPw = System.getenv("MONGO_PW")
    val dbName = "fair-split-try"
    val db = KMongo.createClient(
        connectionString = "mongodb+srv://manuel:$mongoPw@cluster0.ef7woqi.mongodb.net/$dbName?retryWrites=true&w=majority"
    ).coroutine
        .getDatabase(dbName)
    val userDataSource = MongoUserDataSource(db)

    GlobalScope.launch {
        val user = User(
            username = "test",
            password = "test-password",
            salt = "salt"
        )
        userDataSource.insertUser(user)
    }

    configureSerialization()
    configureRouting()
}
