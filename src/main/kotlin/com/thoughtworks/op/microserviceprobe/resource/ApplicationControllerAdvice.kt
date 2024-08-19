package com.thoughtworks.op.microserviceprobe.resource

import com.thoughtworks.op.microserviceprobe.model.ErrorDTO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ApplicationControllerAdvice {

    @ExceptionHandler(Exception::class)
    fun handleException(e: Exception): ResponseEntity<ErrorDTO> {
        return ResponseEntity.internalServerError().body(ErrorDTO(e.message))
    }
}
