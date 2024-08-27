package com.thoughtworks.op.microserviceprobe

import io.swagger.v3.oas.models.OpenAPI
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient

class ApplicationIT(

    @Autowired
    private val applicationContext: ApplicationContext,

    @Autowired
    private val webTestClient: WebTestClient
) : BaseIT() {

    @Test
    fun `application loads successfully`() {
        assertNotNull(applicationContext)
    }

    @Test
    fun `open api specs should be provided`() {

        val apiSpec = webTestClient.get()
            .uri("/api-docs")
            .exchange()
                .expectHeader().contentType(MediaType.APPLICATION_JSON_VALUE)
                .expectStatus().isOk
                .expectBody(OpenAPI::class.java)
            .returnResult().responseBody

        assertNotNull(apiSpec)
        assertEquals("Mood Tracker", apiSpec!!.info.title)
    }
}
