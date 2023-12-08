package com.examen.examen_fullstack.config;

import com.examen.examen_fullstack.dto.ErrorMessageDto;
import com.examen.examen_fullstack.exception.InvalidValueException;
import com.examen.examen_fullstack.exception.ResourceAlreadyExistException;
import com.examen.examen_fullstack.exception.RessourceDoesntExist;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class ExceptionConfig {

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody ErrorMessageDto internalServerError(Exception ex) {
        ex.printStackTrace();
        return ErrorMessageDto.builder().code("INTERNAL_ERROR").message("An internal error occurred").build();
    }

    @ExceptionHandler(value = RessourceDoesntExist.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody ErrorMessageDto resourceNotFound(RessourceDoesntExist ex) {
        return ErrorMessageDto.builder().code("NOT_FOUND").message(ex.getMessage()).build();
    }

    @ExceptionHandler(value = ResourceAlreadyExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorMessageDto resourceNotFound(ResourceAlreadyExistException ex) {
        return ErrorMessageDto.builder().code("RESOURCE_ALREADY_EXIST").message(ex.getMessage()).build();
    }

    @ExceptionHandler(value = InvalidValueException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorMessageDto resourceNotFound(InvalidValueException ex) {
        return ErrorMessageDto.builder().code("RESOURCE_ALREADY_EXIST").message(ex.getMessage()).build();
    }

}
