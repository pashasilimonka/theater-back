package edu.sylymonka.theater.dto.actor;/*
  @author   silim
  @project   theater
  @class  ActorInsertRequest
  @version  1.0.0 
  @since 24.05.2024 - 19.22
*/

import lombok.Data;

import java.time.LocalDate;
import java.time.Year;
@Data
public class ActorInsertRequest {
    private String name;
    private LocalDate dateOfBirth;
    private String sex;
    private Year startedWorkFrom;
    private String rewards;
}
