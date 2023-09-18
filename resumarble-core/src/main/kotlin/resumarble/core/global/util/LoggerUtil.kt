package resumarble.core.global.util

import org.slf4j.LoggerFactory
import resumarble.core.global.util.LoggerUtil.logger
import java.time.Duration
import java.time.LocalDateTime

object LoggerUtil {
    inline fun <reified T> T.logger(): org.slf4j.Logger = LoggerFactory.getLogger(T::class.java)
}

val logger = LoggerUtil.logger()

fun <T> loggingStopWatch(function: () -> T): T {
    val startAt = LocalDateTime.now()
    logger.info("Start at $startAt")

    val result = function.invoke()

    val endAt = LocalDateTime.now()

    logger.info("End at $endAt")
    logger.info("Logic Duration : ${Duration.between(startAt, endAt).toMillis()}ms")

    return result
}

inline fun loggingErrorMarking(function: () -> String) {
    val startAt = LocalDateTime.now()
    logger.error(function.invoke())
    logger.info("예외 발생 시각: $startAt")
}
