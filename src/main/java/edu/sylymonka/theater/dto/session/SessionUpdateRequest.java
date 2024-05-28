package edu.sylymonka.theater.dto.session;/*
  @author   silim
  @project   theater
  @class  SessionUpdateRequest
  @version  1.0.0 
  @since 28.05.2024 - 14.39
*/

import lombok.Data;

import java.sql.Time;
import java.time.LocalDate;

@Data
public class SessionUpdateRequest {
    private long id;
    private LocalDate dateOfSession;
    private Time timeOfSession;
    private long play_id;
}
