package com.thoughtworks.op.microserviceprobe.model

import com.thoughtworks.op.microserviceprobe.BaseUT
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MoodDTOUT : BaseUT() {

    @Test
    fun `instance is created without comment successfully`() {
        val mood = buildMoodDTO(MoodEnum.PASSIVE)

        assertNotNull(mood)
        assertNotNull(mood.scale)
        assertEquals(MoodEnum.PASSIVE, MoodEnum.valueOf(mood.scale))
        assertNull(mood.comment)
    }

    @Test
    fun `instance is created with comment successfully`() {
        val mood = buildMoodDTO(MoodEnum.PASSIVE, "test comment only")

        assertNotNull(mood)
        assertNotNull(mood.scale)
        assertEquals(MoodEnum.PASSIVE, MoodEnum.valueOf(mood.scale))
        assertNotNull(mood.comment)
        assertTrue(mood.comment!!.contains("test comment"))
    }

    @Test
    fun `instance is created successfully and is modifiable`() {
        val mood = buildMoodDTO(MoodEnum.PASSIVE, "test comment only")

        assertNotNull(mood)
        assertNotNull(mood.scale)
        assertEquals(MoodEnum.PASSIVE, MoodEnum.valueOf(mood.scale))
        assertNotNull(mood.comment)
        assertTrue(mood.comment!!.contains("test comment"))

        mood.scale = MoodEnum.GOOD.name
        mood.comment = "test comment modified"

        assertNotNull(mood.scale)
        assertEquals(MoodEnum.GOOD, MoodEnum.valueOf(mood.scale))
        assertNotNull(mood.comment)
        assertTrue(mood.comment!!.contains("modified"))
    }
}
