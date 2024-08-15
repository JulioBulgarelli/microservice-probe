package com.thoughtworks.op.microserviceprobe.service

import com.thoughtworks.op.microserviceprobe.model.Mood
import com.thoughtworks.op.microserviceprobe.model.MoodDTO
import com.thoughtworks.op.microserviceprobe.model.MoodEnum
import com.thoughtworks.op.microserviceprobe.repository.MoodRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.extra.math.averageAsBigInt

@Service
class MoodServiceImpl(
    private val moodRepository: MoodRepository
) : MoodService {

    override fun getMoods(): Flux<MoodDTO> {
        return moodRepository.findAll().map { MoodDTO.toDto(it) }
    }
    override fun createMood(moodDTO: MoodDTO): Mono<Mood> {
        return moodRepository.save(MoodDTO.toEntity(moodDTO))
    }

    override fun getMean(): Mono<MoodEnum> {
        val mean = moodRepository.findAll()
            .map { m -> m.scale.value }
            .averageAsBigInt()

        return mean.map { m ->  MoodEnum.fromValue(m.intValueExact()) }
    }
}
