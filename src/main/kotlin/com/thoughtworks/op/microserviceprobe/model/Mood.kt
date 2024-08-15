package com.thoughtworks.op.microserviceprobe.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("mood")
data class Mood(
    @Id var id: Long? = null,
    var scale: MoodEnum,
    var comment: String?,
)
