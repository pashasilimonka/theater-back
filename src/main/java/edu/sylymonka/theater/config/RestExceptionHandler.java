package edu.sylymonka.theater.config;/*
  @author   silim
  @project   theater
  @class  RestExceptionHandler
  @version  1.0.0 
  @since 03.06.2024 - 18.39
*/

import edu.sylymonka.theater.dto.ErrorDTO;
import edu.sylymonka.theater.exceptions.AppException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(value = {AppException.class})
    @ResponseBody
    public ResponseEntity<ErrorDTO> handleException(AppException e) {
        return ResponseEntity.status(e.getCode())
                .body(ErrorDTO.builder().message(e.getMessage()).build());
    }
}
