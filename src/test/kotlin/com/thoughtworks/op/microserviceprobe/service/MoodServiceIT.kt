package com.thoughtworks.op.microserviceprobe.service

import com.thoughtworks.op.microserviceprobe.BaseIT
import com.thoughtworks.op.microserviceprobe.model.MoodDTO
import com.thoughtworks.op.microserviceprobe.model.MoodEnum
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.springframework.beans.factory.annotation.Autowired
import kotlin.test.assertNotNull

@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class MoodServiceIT (

    @Autowired
    private val moodService: MoodService
) : BaseIT() {

    @Test
    @Order(1)
    fun `should return all records`() {
        assertEquals(3, moodService.getMoods().count().block())
    }

    @Test
    @Order(2)
    fun `should return the mean mood`() {
        assertEquals(MoodEnum.PASSIVE.name, moodService.getMean().block()!!.name)
    }

    @Test
    @Order(3)
    fun `should register a new mood`() {
        assertNotNull(moodService.createMood(MoodDTO(scale = MoodEnum.VERY_GOOD.name, comment = null)).block())
    }

    @Test
    @Order(4)
    fun `should return updated mean mood`() {
        assertNotNull(moodService.createMood(MoodDTO(scale = MoodEnum.GOOD.name, comment = null)).block())
    }
}
