package edu.sylymonka.theater.dto.session;/*
  @author   silim
  @project   theater
  @class  SessionDTO
  @version  1.0.0 
  @since 28.05.2024 - 14.34
*/

import edu.sylymonka.theater.dto.play.PlayForRole;
import lombok.Data;

import java.sql.Time;
import java.time.LocalDate;

@Data
public class SessionDTO {
    private long id;
    private LocalDate dateOfSession;
    private Time timeOfSession;
    private PlayForRole play;
}
