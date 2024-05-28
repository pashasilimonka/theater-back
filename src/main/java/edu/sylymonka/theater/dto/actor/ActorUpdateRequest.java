package edu.sylymonka.theater.dto.actor;/*
  @author   silim
  @project   theater
  @class  ActorUpdateRequest
  @version  1.0.0 
  @since 24.05.2024 - 19.23
*/

import lombok.Data;

import java.time.LocalDate;
import java.time.Year;
@Data
public class ActorUpdateRequest {
    private long id;
    private String name;
    private LocalDate dateOfBirth;
    private String sex;
    private Year startedWorkFrom;
    private String rewards;
}
