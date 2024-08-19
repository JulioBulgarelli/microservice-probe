package com.thoughtworks.op.microserviceprobe

import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext

class ApplicationIT(

    @Autowired
    private val applicationContext: ApplicationContext
) : BaseIT() {

    @Test
    fun `application loads successfully`() {
        assertNotNull(applicationContext)
    }
}
