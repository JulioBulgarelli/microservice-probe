package com.thoughtworks.op.microserviceprobe.resource

import com.thoughtworks.op.microserviceprobe.model.MoodDTO
import com.thoughtworks.op.microserviceprobe.model.MoodEnum
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.parameters.RequestBody
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.MediaType
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface MoodResource {

    @Operation(summary = "Get all moods")
    @ApiResponses(value = [
        ApiResponse(
            responseCode = "200",
            description = "OK",
            content = arrayOf(
                (Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE, array = (
                        ArraySchema(schema = Schema(implementation = MoodDTO::class))
                    )
                ))
            )
        )
    ])
    @GetMapping("/moods", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getMoods(): Flux<MoodDTO>

    @Operation(summary = "Create a mood")
    @RequestBody(
        content = [
            Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = Schema(implementation = MoodDTO::class))
        ]
    )
    @ApiResponses(value = [
        ApiResponse(
            responseCode = "201",
            description = "Created",
            content = [
                Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = Schema(implementation = MoodDTO::class))
            ]
        )
    ])
    @PostMapping("/moods", consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun postMood(@Validated @org.springframework.web.bind.annotation.RequestBody moodDTO: MoodDTO): Mono<MoodDTO>

    @Operation(summary = "Get mean mood")
    @ApiResponses(value = [
        ApiResponse(
            responseCode = "200",
            description = "OK",
            content = [
                Content(mediaType = MediaType.TEXT_PLAIN_VALUE, schema = Schema(implementation = String::class))
            ]
        )
    ])
    @GetMapping("/moods/mean", produces = [MediaType.TEXT_PLAIN_VALUE])
    fun getMoodsMean(): Mono<String>
}
