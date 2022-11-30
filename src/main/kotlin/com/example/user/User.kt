package com.example.user

import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

//@Serializable // esta anotación facilita la transformación de este objeto a json
data class User(@BsonId val id: ObjectId = ObjectId(),
                val username: String,
                val password: String,
                val salt: String)
