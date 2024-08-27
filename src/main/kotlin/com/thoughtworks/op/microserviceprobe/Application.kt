package com.thoughtworks.op.microserviceprobe

import io.swagger.v3.oas.annotations.ExternalDocumentation
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Contact
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.info.License
import io.swagger.v3.oas.annotations.servers.Server
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@OpenAPIDefinition(
    info = Info(
        title = "Mood Tracker",
        version = "1.0.0",
        description = "API for tracking crowd mood",
        license = License(name = "MIT", url = "https://opensource.org/license/mit"),
        contact = Contact(name = "Julio Bulgarelli", email = "julio@bulgamart.com")
    ),
    tags = [Tag(name = "Mood", description = "Mood resources")],
    externalDocs = ExternalDocumentation(description = "definition docs desc"),
    servers = [Server(description = "Localhost", url = "http://localhost:8080")]
)
@SpringBootApplication
class MicroserviceProbeApplication

fun main(args: Array<String>) {
    runApplication<MicroserviceProbeApplication>(*args)
}
