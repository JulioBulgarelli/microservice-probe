package com.thoughtworks.op.microserviceprobe.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.OffsetDateTime

class ErrorDTOTest {

    @Test
    fun `instance is created without message successfully`() {
        val error = ErrorDTO(message = null)

        assertNotNull(error)
        assertNull(error.message)
        assertNotNull(error.timestamp)
        assertEquals(OffsetDateTime.now().dayOfMonth, error.timestamp.dayOfMonth)
    }

    @Test
    fun `instance is created with message successfully`() {
        val error = ErrorDTO(message = "test message")

        assertNotNull(error)
        assertNotNull(error.message)
        assertEquals("test message", error.message)
        assertNotNull(error.timestamp)
        assertEquals(OffsetDateTime.now().dayOfMonth, error.timestamp.dayOfMonth)
    }

    @Test
    fun `instance is created successfully and is modifiable`() {
        val error = ErrorDTO(message = "test message")

        assertNotNull(error)
        assertNotNull(error.message)
        assertEquals("test message", error.message)
        assertNotNull(error.timestamp)
        assertEquals(OffsetDateTime.now().dayOfMonth, error.timestamp.dayOfMonth)

        error.message = "test comment modified"
        error.timestamp = OffsetDateTime.now().minusDays(5)

        assertNotNull(error.message)
        assertTrue(error.message!!.contains("modified"))
        assertNotNull(error.timestamp)
        assertEquals(OffsetDateTime.now().minusDays(5).dayOfMonth, error.timestamp.dayOfMonth)
    }
}
