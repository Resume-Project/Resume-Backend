package resumarble.reactor.domain.interview.controller

import org.springframework.data.domain.PageRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import resumarble.reactor.domain.interview.application.InterviewQuestionFacade

@RestController
@RequestMapping("/interview-questions")
class InterviewQuestionApi(
    private val interviewQuestionFacade: InterviewQuestionFacade
) {

    @PostMapping
    suspend fun createInterviewQuestion(
        @RequestBody request: InterviewQuestionRequest,
        @RequestHeader(X_AUTHORIZATION_ID, defaultValue = "0") userId: String
    ) = interviewQuestionFacade.generateInterviewQuestions(request.toCommandList(userId.toLong()))

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun readInterviewQuestion(
        @RequestParam(defaultValue = "0") page: Int,
        @RequestHeader(X_AUTHORIZATION_ID) userId: String
    ) = interviewQuestionFacade.readInterviewQuestions(userId.toLong(), PageRequest.of(page, 11))

    companion object {
        private const val X_AUTHORIZATION_ID = "X-Authorization-Id"
    }
}
