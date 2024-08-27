package com.thoughtworks.op.microserviceprobe

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.utility.DockerImageName

open class PostgreSQL12Container {

    companion object {

        private val postgres = PostgreSQLContainer<Nothing>(DockerImageName.parse("postgres:12"))

        @JvmStatic
        @BeforeAll
        fun setup() {
            postgres.withExposedPorts(5432)
            postgres.withUsername("postgres")
            postgres.withPassword("tc")
            postgres.withStartupTimeoutSeconds(10)

            postgres.start()
            System.setProperty("spring.r2dbc.url", postgres.jdbcUrl.replace("jdbc:", "r2dbc:"))
        }

        @JvmStatic
        @AfterAll
        fun setdown() {
            postgres.stop()
        }
    }
}
