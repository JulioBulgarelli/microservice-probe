package com.thoughtworks.op.microserviceprobe.model

import com.thoughtworks.op.microserviceprobe.BaseUT
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MoodUT : BaseUT() {

    @Test
    fun `instance is created without comment successfully`() {
        val mood = buildMood(1L, MoodEnum.PASSIVE)

        assertNotNull(mood)
        assertNotNull(mood.id)
        assertEquals(1L, mood.id)
        assertNotNull(mood.scale)
        assertEquals(MoodEnum.PASSIVE, mood.scale)
        assertNull(mood.comment)
    }

    @Test
    fun `instance is created with comment successfully`() {
        val mood = buildMood(1L, MoodEnum.PASSIVE, "test comment only")

        assertNotNull(mood)
        assertNotNull(mood.id)
        assertEquals(1L, mood.id)
        assertNotNull(mood.scale)
        assertEquals(MoodEnum.PASSIVE, mood.scale)
        assertNotNull(mood.comment)
        assertTrue(mood.comment!!.contains("test comment"))
    }

    @Test
    fun `instance is created successfully and is modifiable`() {
        val mood = buildMood(1L, MoodEnum.PASSIVE, "test comment only")

        assertNotNull(mood)
        assertNotNull(mood.id)
        assertEquals(1L, mood.id)
        assertNotNull(mood.scale)
        assertEquals(MoodEnum.PASSIVE, mood.scale)
        assertNotNull(mood.comment)
        assertTrue(mood.comment!!.contains("test comment"))

        mood.id = 3L
        mood.scale = MoodEnum.GOOD
        mood.comment = "test comment modified"

        assertNotNull(mood.id)
        assertEquals(3L, mood.id)
        assertNotNull(mood.scale)
        assertEquals(MoodEnum.GOOD, mood.scale)
        assertNotNull(mood.comment)
        assertTrue(mood.comment!!.contains("modified"))
    }
}
