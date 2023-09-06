package resumarble.core.global.error

import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.http.HttpStatus

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
enum class ErrorCode(
    val status: HttpStatus,
    val message: String
) {
    // Common
    INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, "유효하지 않은 입력값입니다"),

    // InterviewQuestion
    REQUEST_FAILED(HttpStatus.BAD_REQUEST, "요청에 실패했습니다"),

    // prompt
    PROMPT_NOT_FOUND(HttpStatus.NOT_FOUND, "프롬프트를 찾을 수 없습니다"),
    PROMPT_ALREADY_EXISTS(HttpStatus.CONFLICT, "프롬프트가 이미 존재합니다"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 내부 에러입니다."),

    // user
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "유저를 찾을 수 없습니다"),
    UNIDENTIFIED_USER(HttpStatus.UNAUTHORIZED, "사용자 정보가 일치하지 않습니다.")
}
