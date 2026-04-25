package com.mpn.ktorconnfromlaptop

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.cio.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

object KtorServer {

    private var server: ApplicationEngine? = null

    fun start() {
        if (server != null) return

        server = embeddedServer(CIO, port = 8090, host = "127.0.0.1") {
            routing {
                get("/") {
                    call.respondText("Hello from Ktor on Android!")
                }

                get("/health") {
                    call.respondText("OK")
                }
            }
        }.start(wait = false)
    }

    fun stop() {
        server?.stop(1000, 2000)
        server = null
    }
}
