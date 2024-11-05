package com.ssmartofice.userservice.user.controller.response

import com.ssmartofice.userservice.user.domain.Role
import com.ssmartofice.userservice.user.domain.User
import com.ssmartofice.userservice.user.domain.UserStatus

class UserInfoResponse(
    val id: Int = 0,
    val employeeNumber: String,
    val email: String,
    val name: String,
    val position: String,
    val duty: String,
    val profileImageUrl: String,
    var role: Role,
    val status: UserStatus,
) {
    companion object {
        fun fromModel(user: User): UserInfoResponse {
            return UserInfoResponse(
                id = user.id,
                email = user.email,
                name = user.name,
                position = user.position,
                duty = user.duty,
                profileImageUrl = user.profileImageUrl,
                role = user.role,
                employeeNumber = user.employeeNumber,
                status = user.status,
            )
        }
    }
}
