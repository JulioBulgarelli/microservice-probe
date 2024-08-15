package com.thoughtworks.op.microserviceprobe.service

import com.thoughtworks.op.microserviceprobe.model.Mood
import com.thoughtworks.op.microserviceprobe.model.MoodDTO
import com.thoughtworks.op.microserviceprobe.model.MoodEnum
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface MoodService {

    fun getMoods(): Flux<MoodDTO>
    fun createMood(moodDTO: MoodDTO): Mono<Mood>
    fun getMean(): Mono<MoodEnum>
}
