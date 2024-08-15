package com.thoughtworks.op.microserviceprobe.resource

import com.thoughtworks.op.microserviceprobe.model.MoodDTO
import com.thoughtworks.op.microserviceprobe.service.MoodService
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
class MoodController(
    private val moodService: MoodService
) : MoodResource {

    override fun getMoods(): Flux<MoodDTO> {
        return moodService.getMoods()
    }

    override fun postMood(moodDTO: MoodDTO): Mono<MoodDTO> {
        return moodService.createMood(moodDTO).map { MoodDTO.toDto(it) }
    }

    override fun getMoodsMean(): Mono<String> {
        return moodService.getMean().map { it.name }
    }
}
