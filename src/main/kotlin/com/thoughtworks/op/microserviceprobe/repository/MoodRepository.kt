package com.thoughtworks.op.microserviceprobe.repository

import com.thoughtworks.op.microserviceprobe.model.Mood
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MoodRepository : ReactiveCrudRepository<Mood, Long>
