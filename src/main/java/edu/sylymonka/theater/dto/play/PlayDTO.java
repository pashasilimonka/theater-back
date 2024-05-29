package edu.sylymonka.theater.dto.play;/*
  @author   silim
  @project   theater
  @class  PlayDTO
  @version  1.0.0 
  @since 16.05.2024 - 23.43
*/

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.sylymonka.theater.dto.role.RoleDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Schema(name = "Play", description = "DTO class for play table")
@NoArgsConstructor
public class PlayDTO {
    @JsonProperty("Play ID")
    @Schema(name = "Play ID", description = "Unique identificator", example = "1")
    private long id;
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
    @JsonProperty("Roles")
    @Schema(name = "Roles", description = "List roles that are played")
    private List<RoleDTO> roles;

}
