package com.thoughtworks.op.microserviceprobe.model

import java.time.OffsetDateTime

data class ErrorDTO(
    var message: String?,
    var timestamp: OffsetDateTime = OffsetDateTime.now()
)
