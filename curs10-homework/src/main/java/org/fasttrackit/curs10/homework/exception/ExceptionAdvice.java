package org.fasttrackit.curs10.homework.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.logging.Logger;
@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(TrainNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void trainNotFoundExceptionHandler(TrainNotFoundException exception){
        log.info(exception.MESSAGE);
    }

    @ExceptionHandler(OperationNotCompletedException.class)
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    public void trainNotFoundExceptionHandler(OperationNotCompletedException exception){
        log.info(exception.MESSAGE);
    }

    @ExceptionHandler(LocationNotFoundException.class)
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    public void locationNotFoundExceptionHandler(LocationNotFoundException exception){
        log.info(exception.MESSAGE);
    }
}
