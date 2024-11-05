package com.ssmartofice.userservice.user.controller

import com.ssmartofice.userservice.global.const.successcode.SuccessCode
import com.ssmartofice.userservice.global.dto.CommonResponse
import com.ssmartofice.userservice.global.jwt.JwtUtil
import com.ssmartofice.userservice.user.controller.port.UserService
import com.ssmartofice.userservice.user.controller.response.UserInfoResponse
import com.ssmartofice.userservice.user.domain.User
import jakarta.validation.Valid
import org.example.auth_module.global.exception.errorcode.UserErrorCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/users")
class UserController(
    val userService: UserService,
    val jwtUtil: JwtUtil
) {
    @GetMapping("/ping")
    fun check(): ResponseEntity<Any> {
        return ResponseEntity.ok("pong");
    }

    @PostMapping
    fun join(@RequestBody @Valid user: User): ResponseEntity<CommonResponse> {
        userService.addUser(user)
        return ResponseEntity.ok(
            CommonResponse.builder()
                .status(SuccessCode.CREATED.getValue())
                .message("직원등록에 성공하였습니다.")
                .build()
        )
    }

    @GetMapping("/me")
    fun myInfo(@RequestHeader("Authorization") token: String): ResponseEntity<CommonResponse> {
        val user = jwtUtil.getUserByToken(token)
        return ResponseEntity.ok(
            CommonResponse.builder()
                .status(SuccessCode.OK.getValue())
                .data(UserInfoResponse.fromModel(user))
                .message("내 정보 조회 성공")
                .build()
        )
    }

}