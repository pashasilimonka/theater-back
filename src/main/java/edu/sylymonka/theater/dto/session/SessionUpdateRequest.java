package edu.sylymonka.theater.dto.session;/*
  @author   silim
  @project   theater
  @class  SessionUpdateRequest
  @version  1.0.0 
  @since 28.05.2024 - 14.39
*/

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class SessionUpdateRequest {
    @JsonProperty("Session ID")
    @Schema(name = "Session ID", description = "Unique identification", example = "1")
    private long id;
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
