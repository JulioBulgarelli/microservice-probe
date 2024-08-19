package com.thoughtworks.op.microserviceprobe.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MoodDTOTest {

    @Test
    fun `instance is created without comment successfully`() {
        val mood = MoodDTO(scale = MoodEnum.PASSIVE.name, comment = null)

        assertNotNull(mood)
        assertNotNull(mood.scale)
        assertEquals(MoodEnum.PASSIVE.name, mood.scale)
        assertNull(mood.comment)
    }

    @Test
    fun `instance is created with comment successfully`() {
        val mood = MoodDTO(scale = MoodEnum.PASSIVE.name, comment = "test comment only")

        assertNotNull(mood)
        assertNotNull(mood.scale)
        assertEquals(MoodEnum.PASSIVE.name, mood.scale)
        assertNotNull(mood.comment)
        assertTrue(mood.comment!!.contains("test comment"))
    }

    @Test
    fun `instance is created successfully and is modifiable`() {
        val mood = MoodDTO(scale = MoodEnum.PASSIVE.name, comment = "test comment only")

        assertNotNull(mood)
        assertNotNull(mood.scale)
        assertEquals(MoodEnum.PASSIVE.name, mood.scale)
        assertNotNull(mood.comment)
        assertTrue(mood.comment!!.contains("test comment"))

        mood.scale = MoodEnum.GOOD.name
        mood.comment = "test comment modified"

        assertNotNull(mood.scale)
        assertEquals(MoodEnum.GOOD.name, mood.scale)
        assertNotNull(mood.comment)
        assertTrue(mood.comment!!.contains("modified"))
    }
}
