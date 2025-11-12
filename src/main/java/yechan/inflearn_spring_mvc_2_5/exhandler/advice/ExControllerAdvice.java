package yechan.inflearn_spring_mvc_2_5.exhandler.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import yechan.inflearn_spring_mvc_2_5.exception.UserException;
import yechan.inflearn_spring_mvc_2_5.exhandler.ErrorResult;

@Slf4j
@RestControllerAdvice(basePackages = "yechan.inflearn_spring_mvc_2_5")
public class ExControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorResult illegalExHandler(IllegalArgumentException e) {
        log.error("exceptionHandler ex", e);
        return new ErrorResult("BAD", e.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResult> userExceptionHandler(UserException e) {
        log.error("userExceptionHandler ex", e);
        ErrorResult errorResult = new ErrorResult("USER-EX", e.getMessage());
        return new ResponseEntity<>(errorResult, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResult exHandler(Exception e) {
        log.error("exceptionHandler ex", e);
        return new ErrorResult("EX", "내부 오류");
    }
}
