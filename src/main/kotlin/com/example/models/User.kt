package com.example.models

import kotlinx.serialization.Serializable

@Serializable // esta anotación facilita la transformación de este objeto a json
data class User(val id: Int, val name: String, val age: Int, val email:String)
