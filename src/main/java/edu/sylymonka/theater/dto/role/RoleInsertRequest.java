package edu.sylymonka.theater.dto.role;/*
  @author   silim
  @project   theater
  @class  RoleInsertRequest
  @version  1.0.0 
  @since 28.05.2024 - 13.13
*/

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "Role insert request", description = "DTO class for insert requests to roles table")
public class RoleInsertRequest {
    @JsonProperty("Name")
    @Schema(name = "Name", description = "Name of the character in play", example = "Romeo")
    private String name;
    @JsonProperty("Type of role")
    @Schema(name = "Type of role", description = "Type of role, main or secondary", example = "main")
    private String type;
    @JsonProperty("Age")
    @Schema(name = "Age", description = "Age of character", example = "23")
    private int age;
    @JsonProperty("Sex")
    @Schema(name = "Sex", description = "Gender of character, male or female", example = "1")
    private String sex;
    @JsonProperty("Actor ID")
    @Schema(name = "Actor ID", description = "Foreign key for associating with actors table")
    private long actor_id;
    @JsonProperty("Play ID")
    @Schema(name = "Play ID", description = "Foreign key for associating with play table")
    private long play_id;
}
