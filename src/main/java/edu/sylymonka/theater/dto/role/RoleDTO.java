package edu.sylymonka.theater.dto.role;/*
  @author   silim
  @project   theater
  @class  RoleDTO
  @version  1.0.0 
  @since 28.05.2024 - 13.10
*/

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.sylymonka.theater.dto.actor.ActorForRole;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "Role", description = "DTO class for roles table")
public class RoleDTO {
    @Schema(name = "Role ID", description = "Unique identificator", example = "1")
    private long id;
    @Schema(name = "Name", description = "Name of the character in play", example = "Romeo")
    private String name;
    @Schema(name = "Type of role", description = "Type of role, main or secondary", example = "main")
    private String type;
    @Schema(name = "Age", description = "Age of character", example = "23")
    private int age;
    @Schema(name = "Sex", description = "Gender of character, male or female", example = "1")
    private String sex;
    @Schema(name = "Actor", description = "Actor that is playing the role")
    private ActorForRole actor;
}
