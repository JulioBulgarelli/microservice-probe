package com.thoughtworks.op.microserviceprobe.model

data class MoodDTO(
    var scale: String,
    var comment: String?,
) {

    companion object {
        fun toDto(mood: Mood): MoodDTO {
            return MoodDTO(scale = mood.scale.name, comment = mood.comment)
        }

        fun toEntity(moodDTO: MoodDTO): Mood {
            return Mood(scale = MoodEnum.valueOf(moodDTO.scale), comment = moodDTO.comment)
        }
    }
}

