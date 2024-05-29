package edu.sylymonka.theater.dto.actor;/*
  @author   silim
  @project   theater
  @class  ActorUpdateRequest
  @version  1.0.0 
  @since 24.05.2024 - 19.23
*/

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Year;
@Data
@Getter
@Setter
@Schema(
        name = "Actor for update request",
        description = "DTO class of actor for update requests")
public class ActorUpdateRequest {
    @JsonProperty("Actor ID")
    @Schema(name = "Actor ID", description = "Unique identificator",example = "1")
    private long id;
    @JsonProperty("Actor name")
    @Schema(name = "Actor name", description = "Name of actor", example = "John Doe")
    private String name;
    @JsonProperty("Date of birth")
    @Schema(name = "Date of birth", description = "Date of birth of actor",example = "1971-01-01")
    private LocalDate dateOfBirth;
    @JsonProperty("Age")
    @Schema(name = "Age", description = "Age of actor", example = "22")
    private int age;
    @JsonProperty("Sex")
    @Schema(name = "Sex", description = "Gender of actor", example = "Male")
    private String sex;
    @JsonProperty("Started work from")
    @Schema(name = "Started work from", description = "Year when actor started performing", example = "2001")
    private Year startedWorkFrom;
    @JsonProperty("Rewards")
    @Schema(name = "Rewards", description = "Rewards obtained by actor", example = "Oscar - for the main role")
    private String rewards;
}
