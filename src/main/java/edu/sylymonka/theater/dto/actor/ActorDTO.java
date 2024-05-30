package edu.sylymonka.theater.dto.actor;/*
  @author   silim
  @project   theater
  @class  ActorDTO
  @version  1.0.0 
  @since 24.05.2024 - 19.20
*/

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.sylymonka.theater.dto.role.RoleForActor;
import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Year;
import java.util.List;
@Data
@Getter
@Setter
@Schema(
        name = "Actor",
        description = "DTO class for actors table"
)
public class ActorDTO {
    @Schema(name = "Actor ID", description = "Unique identificator",example = "1")
    private long id;
    @Schema(name = "Actor name", description = "Name of actor", example = "John Doe")
    private String name;
    @Schema(name = "Date of birth", description = "Date of birth of actor",example = "1971-01-01")
    private LocalDate dateOfBirth;
    @Schema(name = "Age", description = "Age of actor", example = "22")
    private int age;
    @Schema(name = "Sex", description = "Gender of actor", example = "Male")
    private String sex;
    @Schema(name = "Started work from", description = "Year when actor started performing", example = "2001")
    private Year startedWorkFrom;
    @Schema(name = "Rewards", description = "Rewards obtained by actor", example = "Oscar - for the main role")
    private String rewards;
    @Schema(name = "Roles", description = "Roles that actor have played")
    private List<RoleForActor> roles;
}
