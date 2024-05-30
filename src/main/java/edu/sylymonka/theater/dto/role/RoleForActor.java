package edu.sylymonka.theater.dto.role;/*
  @author   silim
  @project   theater
  @class  RoleForActor
  @version  1.0.0 
  @since 28.05.2024 - 13.38
*/

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.sylymonka.theater.dto.play.PlayForRole;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "Role for actor", description = "DTO class for association with actors table")
public class RoleForActor {
    @Schema(name = "Role ID", description = "Unique identificator", example = "1")
    private long id;
    @Schema(name = "Name", description = "Name of the character in play", example = "Romeo")
    private String name;
    @Schema(name = "Type of role", description = "Type of role, main or secondary", example = "main")
    private String type;
    private PlayForRole play;
}
