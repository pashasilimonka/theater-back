package edu.sylymonka.theater.dto.play;/*
  @author   silim
  @project   theater
  @class  PlayForRole
  @version  1.0.0 
  @since 28.05.2024 - 13.39
*/

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "Play for role", description = "DTO class of play for association with roles table")
public class PlayForRole {
    @JsonProperty("Play ID")
    @Schema(name = "Play ID", description = "Unique identificator", example = "1")
    private long id;
    @JsonProperty("Title")
    @Schema(name = "Title", description = "Title of the play", example = "Romeo and Juliette")
    private String title;
}
