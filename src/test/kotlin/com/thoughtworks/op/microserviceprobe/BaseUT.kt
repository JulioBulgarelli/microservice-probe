package com.thoughtworks.op.microserviceprobe

import com.thoughtworks.op.microserviceprobe.model.ErrorDTO
import com.thoughtworks.op.microserviceprobe.model.Mood
import com.thoughtworks.op.microserviceprobe.model.MoodDTO
import com.thoughtworks.op.microserviceprobe.model.MoodEnum
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles("test")
open class BaseUT {

    fun buildErrorDTO(): ErrorDTO {
        return buildErrorDTO(null)
    }

    fun buildErrorDTO(message: String?): ErrorDTO {
        return ErrorDTO(message = message)
    }

    fun buildMoodDTO(scale: MoodEnum): MoodDTO {
        return buildMoodDTO(scale, null)
    }

    fun buildMoodDTO(scale: MoodEnum, comment: String?): MoodDTO {
        return MoodDTO(scale = scale.name, comment = comment)
    }

    fun buildMood(id: Long, scale: MoodEnum): Mood {
        return buildMood(id, scale, null)
    }

    fun buildMood(id: Long, scale: MoodEnum, comment: String?): Mood {
        return Mood(id = id, scale = scale, comment = comment)
    }
}
