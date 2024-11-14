package org.ssmartoffice.seatservice.global.const.errorcode

import lombok.Getter
import org.springframework.http.HttpStatus

@Getter
enum class SeatErrorCode(override val httpStatus: HttpStatus, override val message: String) : ErrorCode {
    NOT_FOUND_REFRESH_TOKEN(HttpStatus.UNAUTHORIZED, "저장된 리프레시 토큰이 없습니다."),
    NOT_MATCH_REFRESH_TOKEN(HttpStatus.UNAUTHORIZED, "리프레시 토큰이 일치하지 않습니다."),
    NO_TOKEN_EXCEPTION(HttpStatus.UNAUTHORIZED, "해당 토큰이 존재하지 않습니다."),
    EXPIRED_TOKEN_EXCEPTION(HttpStatus.UNAUTHORIZED, "해당 토큰이 만료되었습니다."),
    INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "사용할 수 없는 토큰입니다."),
    ACCESS_DENIED(HttpStatus.UNAUTHORIZED, "해당 api에 접근 권한이 없습니다."),
    NOT_MATCHED_REDIRECT_URI(HttpStatus.BAD_REQUEST, "Redirect URI가 맞지 않습니다."),
    ACCESS_ADMIN_DENIED(HttpStatus.FORBIDDEN, "관리자만 접근 가능한 api입니다."),
    DUPLICATED_VALUE(HttpStatus.BAD_REQUEST, "중복된 이메일 또는 사원번호 입니다."),
    INVALID_OLD_PASSWORD(HttpStatus.CONFLICT, "비밀번호가 일치하지 않습니다."),
    DUPLICATE_PASSWORD(HttpStatus.CONFLICT, "기존 비밀번호와 동일합니다"),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "사용자를 찾을 수 없습니다."),
    SEAT_NOT_FOUND(HttpStatus.NOT_FOUND, "좌석을 찾을 수 없습니다."),
    DUPLICATE_STATUS(HttpStatus.CONFLICT, "기존 좌석 해제 후 다시 앉아주세요"),
    OCCUPIED_BY_ANOTHER_USER(HttpStatus.CONFLICT, "다른 이용자가 사용 중입니다. 다른 좌석을 이용해주세요."),
    SEAT_UNAVAILABLE(HttpStatus.BAD_REQUEST, "사용 불가한 좌석입니다."),
}