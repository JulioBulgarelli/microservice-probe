package com.thoughtworks.op.microserviceprobe.resource

import com.thoughtworks.op.microserviceprobe.BaseIT
import com.thoughtworks.op.microserviceprobe.model.MoodDTO
import com.thoughtworks.op.microserviceprobe.model.MoodEnum
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient

@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class MoodControllerIT(

    @Autowired
    private val webTestClient: WebTestClient
) : BaseIT() {

    @Test
    @Order(1)
    fun `moods are retrieved successfully`() {

        val moods = webTestClient.get()
            .uri("/moods")
            .exchange()
            .expectHeader().contentType(MediaType.APPLICATION_JSON_VALUE)
            .expectStatus().isOk
            .expectBodyList(MoodDTO::class.java)
            .returnResult().responseBody

            assertNotNull(moods)
            assertEquals(MoodEnum.PASSIVE.value, moods!!.size)
    }

    @Test
    @Order(3)
    fun `mood is created successfully`() {

        val moodCreated = webTestClient.post()
            .uri("/moods")
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(MoodDTO(scale = MoodEnum.GOOD.name, comment = null))
            .exchange()
            .expectHeader().contentType(MediaType.APPLICATION_JSON_VALUE)
            .expectStatus().isOk
            .expectBody(MoodDTO::class.java)
            .returnResult().responseBody

        assertNotNull(moodCreated)
        assertEquals(MoodEnum.GOOD, MoodEnum.valueOf(moodCreated!!.scale))
    }

    @Test
    @Order(2)
    fun `mean mood is retrieved successfully`() {

        val meanMoods = webTestClient.get()
            .uri("/moods/mean")
            .exchange()
            .expectHeader().contentTypeCompatibleWith(MediaType.TEXT_PLAIN_VALUE)
            .expectStatus().isOk
            .expectBody(String::class.java)
            .returnResult().responseBody

        assertNotNull(meanMoods)
        assertEquals(MoodEnum.PASSIVE, MoodEnum.valueOf(meanMoods!!))
    }
}
