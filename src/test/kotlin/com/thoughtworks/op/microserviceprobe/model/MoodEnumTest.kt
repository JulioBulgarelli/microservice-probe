package com.thoughtworks.op.microserviceprobe.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MoodEnumTest {

    @Test
    fun `gets the correct value of the Enum`() {
        val mood: MoodEnum = MoodEnum.BAD

        assertEquals(MoodEnum.BAD.value, mood.value)
        assertEquals(MoodEnum.BAD.name, mood.name)
    }

    @Test
    fun `gets the correct size of the enumerations`() {
        assertEquals(5, MoodEnum.entries.size)
    }

    @Test
    fun `gets the Enum by its value`() {
        val mood1: MoodEnum = MoodEnum.fromValue(3)

        assertEquals(MoodEnum.PASSIVE, mood1)

        val mood2: MoodEnum = MoodEnum.fromValue(4)

        assertEquals(MoodEnum.GOOD, mood2)
    }
}
