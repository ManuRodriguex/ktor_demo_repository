package com.example.user

interface UserDataSource {
    suspend fun findUserByUsername(username: String):User?
    suspend fun insertUser(user: User):Boolean
}