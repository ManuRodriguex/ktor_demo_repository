package com.example.user

import org.litote.kmongo.coroutine.CoroutineDatabase
import org.litote.kmongo.eq

class MongoUserDataSource(
    db: CoroutineDatabase
): UserDataSource {

    private val users = db.getCollection<User>() // automatically creats a collections of json objects
    //containing the data of the user dataClass.

    override suspend fun findUserByUsername(username: String): User? {
        return users.findOne(User::username eq username) //we specify the specific
        //property of the specific class that we want to compare to the function argument
        //and use this notation, "eq" means equal, there are more operators...
    }

    override suspend fun insertUser(user: User): Boolean {
        return users.insertOne(user).wasAcknowledged()
    }
}