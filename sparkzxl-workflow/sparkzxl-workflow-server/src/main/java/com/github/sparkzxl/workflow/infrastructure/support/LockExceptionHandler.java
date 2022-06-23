package com.github.sparkzxl.workflow.infrastructure.support;

import com.github.sparkzxl.core.base.result.Response;
import com.github.sparkzxl.core.support.code.ResultErrorCode;
import com.github.sparkzxl.lock.exception.LockException;
import com.github.sparkzxl.lock.exception.LockFailureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * description:
 *
 * @author zhouxinlei
 * @since 2022-06-21 15:33:04
 */
@ControllerAdvice
@RestController
@Slf4j
public class LockExceptionHandler implements Ordered {

    @ExceptionHandler(LockException.class)
    public Response<?> handleLockException(LockException e) {
        log.error("LockException异常:", e);
        return Response.fail(ResultErrorCode.FAILURE.getErrorCode(), e.getMessage());
    }

    @ExceptionHandler(LockFailureException.class)
    public Response<?> handleLockFailureException(LockFailureException e) {
        log.error("LockFailureException异常:", e);
        return Response.fail(ResultErrorCode.PARAM_VALID_ERROR.getErrorCode(), e.getMessage());
    }

    @Override
    public int getOrder() {
        return Integer.MIN_VALUE;
    }
}
