package edu.sylymonka.theater.exceptions;/*
  @author   silim
  @project   theater
  @class  AppException
  @version  1.0.0 
  @since 03.06.2024 - 17.45
*/

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
@AllArgsConstructor
@Getter
public class AppException extends RuntimeException {
    private final String message;
    private final HttpStatus code;

}
