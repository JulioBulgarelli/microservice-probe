package com.thoughtworks.op.microserviceprobe

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.ActiveProfiles
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.utility.DockerImageName

@SpringBootTest
@AutoConfigureWebTestClient
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@ActiveProfiles("test")
class BaseIT {

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
