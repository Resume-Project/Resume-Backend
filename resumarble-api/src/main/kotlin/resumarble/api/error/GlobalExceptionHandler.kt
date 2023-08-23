package resumarble.api.error

import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import resumarble.api.response.Response
import resumarble.core.global.error.BusinessException
import resumarble.core.global.error.PromptNotFoundException

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException::class)
    fun handleBusinessException(e: BusinessException): Response<Any?> {
        return Response.fail(e.errorCode)
    }

    @ExceptionHandler(PromptNotFoundException::class)
    fun handlePromptNotFoundException(e: PromptNotFoundException): Response<Any?> {
        return Response.fail(e.errorCode)
    }
}
