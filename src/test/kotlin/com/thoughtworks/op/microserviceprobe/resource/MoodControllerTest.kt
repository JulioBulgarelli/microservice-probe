package com.thoughtworks.op.microserviceprobe.resource

import com.thoughtworks.op.microserviceprobe.model.MoodDTO
import com.thoughtworks.op.microserviceprobe.model.MoodEnum
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class MoodControllerTest(
    @Autowired
    private val moodResource: MoodResource
) {

    @Test @Order(1)
    fun `moods are retrieved successfully`() {

        assertDoesNotThrow {
            val moods = moodResource.getMoods()

            assertNotNull(moods)
            assertEquals(3, moods.count().block())
        }
    }

    @Test @Order(3)
    fun `mood is created successfully`() {

        assertDoesNotThrow {
            val moodCreated = moodResource.postMood(MoodDTO(scale = MoodEnum.GOOD.name, comment = null)).block()

            assertNotNull(moodCreated)
            assertEquals(MoodEnum.GOOD, MoodEnum.valueOf(moodCreated!!.scale))
        }
    }

    @Test @Order(2)
    fun `mean mood is retrieved successfully`() {

        assertDoesNotThrow {
            val mood = moodResource.getMoodsMean().block()

            assertNotNull(mood)
            assertEquals(MoodEnum.PASSIVE, MoodEnum.valueOf(mood!!))
        }
    }
}
