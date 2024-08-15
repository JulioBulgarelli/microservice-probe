package com.thoughtworks.op.microserviceprobe.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MoodTest {

    @Test
    fun `instance is created without comment successfully`() {
        val mood = Mood(id = 1L, scale = MoodEnum.PASSIVE, comment = null)

        assertNotNull(mood)
        assertNotNull(mood.id)
        assertEquals(1L, mood.id)
        assertNotNull(mood.scale)
        assertEquals(3, mood.scale.value)
        assertNull(mood.comment)
    }

    @Test
    fun `instance is created with comment successfully`() {
        val mood = Mood(id = 1L, scale = MoodEnum.PASSIVE, comment = "test comment only")

        assertNotNull(mood)
        assertNotNull(mood.id)
        assertEquals(1L, mood.id)
        assertNotNull(mood.scale)
        assertEquals(3, mood.scale.value)
        assertNotNull(mood.comment)
        assertTrue(mood.comment!!.contains("test comment"))
    }
}
