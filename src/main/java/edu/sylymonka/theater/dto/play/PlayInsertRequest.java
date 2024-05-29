package edu.sylymonka.theater.dto.play;/*
  @author   silim
  @project   theater
  @class  PlayInsertRequest
  @version  1.0.0 
  @since 24.05.2024 - 18.51
*/

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "Play insert request", description = "DTO class for insert requests to play table")
public class PlayInsertRequest {
    @JsonProperty("Title")
    @Schema(name = "Title", description = "Title of the play", example = "Romeo and Juliette")
    private String title;
    @JsonProperty("Author")
    @Schema(name = "Author", description = "Author of the play", example = "Ronan Connor")
    private String author;
    @JsonProperty("Genre")
    @Schema(name = "Genre", description = "Genre of the play", example = "Tragedy")
    private String genre;
    @JsonProperty("Plot")
    @Schema(name = "Plot", description = "Plot of the play", example = "This play is about tragic love boy and girl.")
    private String plot;
}
