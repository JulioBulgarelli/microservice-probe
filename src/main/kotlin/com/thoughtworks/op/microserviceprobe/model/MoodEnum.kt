package com.thoughtworks.op.microserviceprobe.model

enum class MoodEnum(
    val value: Int,
) {

    VERY_BAD    (1),
    BAD         (2),
    PASSIVE     (3),
    GOOD        (4),
    VERY_GOOD   (5);

    companion object {
        fun fromValue(value: Int): MoodEnum {
            return entries.first { it.value == value }
        }
    }
}
