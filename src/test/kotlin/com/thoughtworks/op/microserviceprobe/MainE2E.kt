package com.thoughtworks.op.microserviceprobe

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class MainE2E : PostgreSQL12Container() {

    @Test
    fun `application runs successfully`() {
        assertDoesNotThrow {
            System.setProperty("spring.r2dbc.username", "postgres")
            System.setProperty("spring.r2dbc.password", "tc")

            main(emptyArray())
        }
    }
}
