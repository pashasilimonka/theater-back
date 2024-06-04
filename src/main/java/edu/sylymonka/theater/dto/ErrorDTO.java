package edu.sylymonka.theater.dto;/*
  @author   silim
  @project   theater
  @class  ErrorDTO
  @version  1.0.0 
  @since 03.06.2024 - 16.58
*/

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@JsonInclude
@AllArgsConstructor
@Builder
@Data
public class ErrorDTO {
    private String message;
}
