package org.ssmartoffice.attendanceservice.client.response

import io.github.oshai.kotlinlogging.KotlinLogging
import org.ssmartoffice.attendanceservice.domain.Role

private val logger = KotlinLogging.logger {}

class UserAuthenticationResponse(
    val userId: Long = 0,
    var role: Role
)