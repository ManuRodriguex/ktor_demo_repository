package com.example.routes

import com.example.user.User
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*



fun Route.userRouting(){



    /*
    route("/user"){
        get{
            if (users.isNotEmpty()){
                call.respond(users)
            }else{
                call.respondText("No hay usuarios", status = HttpStatusCode.OK)
            }
        }
        get ("{id?}"){
            val id = call.parameters["id"] ?: return@get call.respondText(
                    "Id no encontrado",
                    status = HttpStatusCode.BadRequest
            )
            val user = users.find { it.id == id.toInt() } ?: return@get call.respondText(
                "User con id: $id no encontrado",
                status = HttpStatusCode.NotFound
            )
            call.respond(user)
        }
        post {
            val user = call.receive<User>()
            users.add(user)
            call.respondText("El usuario se ha creado correctamente",
                status = HttpStatusCode.Created)
        }

        patch("{id?}"){
            val id = call.parameters["id"] ?: return@patch call.respondText(
                "Id no encontrado",
                status = HttpStatusCode.BadRequest
            )
            val user = call.receive<User>()
            users.forEachIndexed {i, usuario ->
                if (usuario.id == id.toInt()){
                    users[i] = user
                    call.respondText("Usuario con id:$id actualizado con exito",
                        status = HttpStatusCode.OK )
                }
            }
        }

        delete("{id?}"){
            val id = call.parameters["id"] ?: return@delete call.respondText(
                "Id no encontrado",
                status = HttpStatusCode.BadRequest
            )
            if (users.removeIf{ it.id == id.toInt()}){
                call.respondText("Usuario $id eliminado", status = HttpStatusCode.Accepted)
            }else{
                call.respondText("No encontrado", status = HttpStatusCode.NotFound)
            }
        }
    }

     */
}