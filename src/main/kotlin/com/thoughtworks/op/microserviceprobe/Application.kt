package com.thoughtworks.op.microserviceprobe

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MicroserviceProbeApplication

fun main(args: Array<String>) {
    runApplication<MicroserviceProbeApplication>(*args)
}
