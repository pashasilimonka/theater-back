package edu.sylymonka.theater.dto.actor;/*
  @author   silim
  @project   theater
  @class  ActorForRole
  @version  1.0.0 
  @since 28.05.2024 - 13.37
*/

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(
        name = "Actor for Role",
        description = "DTO class of actor for roles table"
)
public class ActorForRole {
    @Schema(name = "Actor ID", description = "Unique identificator for actor",example = "1")
    private long id;
    @Schema(name = "Actor name", description = "Name of actor", example = "John Doe")
    private String name;
}
