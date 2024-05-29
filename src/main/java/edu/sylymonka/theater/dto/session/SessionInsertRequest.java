package edu.sylymonka.theater.dto.session;/*
  @author   silim
  @project   theater
  @class  SessionInsertRequest
  @version  1.0.0 
  @since 28.05.2024 - 14.38
*/

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Schema(name = "Session insert request", description = "DTO class for insert requests to sessions table")
public class SessionInsertRequest {
    @JsonProperty("Date of session")
    @Schema(name = "Date of session", description = "Date of session of play", example = "2024-05-30")
    private LocalDate dateOfSession;
    @JsonProperty("Time of session")
    @Schema(name = "Time of session", description = "Time of session", example = "16:00")
    private LocalTime timeOfSession;
    @JsonProperty("Play ID")
    @Schema(name = "Play ID", description = "Foreign key to associate with play")
    private long play_id;
}
