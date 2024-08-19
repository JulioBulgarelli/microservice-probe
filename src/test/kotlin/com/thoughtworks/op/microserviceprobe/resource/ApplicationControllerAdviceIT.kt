package com.thoughtworks.op.microserviceprobe.resource

import com.thoughtworks.op.microserviceprobe.BaseIT
import com.thoughtworks.op.microserviceprobe.model.ErrorDTO
import com.thoughtworks.op.microserviceprobe.service.MoodService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.whenever
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient
import java.time.OffsetDateTime

@ExtendWith(MockitoExtension::class)
class ApplicationControllerAdviceIT(

    @Autowired
    private val webTestClient: WebTestClient
) : BaseIT() {

    @MockBean
    lateinit var moodService: MoodService

    @Test
    fun `any exception is correctly mapped and handled`() {

        whenever(moodService.getMean())
            .thenThrow(RuntimeException("mocked error message"))

        val error = webTestClient.get()
            .uri("/moods/mean")
            .exchange()
            .expectHeader().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE)
            .expectStatus().is5xxServerError
            .expectBody(ErrorDTO::class.java)
            .returnResult().responseBody

        assertNotNull(error)
        assertEquals("mocked error message", error!!.message)
        assertNotNull(error.timestamp)
        assertEquals(OffsetDateTime.now().dayOfMonth, error.timestamp.dayOfMonth)
    }
}
