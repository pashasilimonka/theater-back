package edu.sylymonka.theater.dto.actor;/*
  @author   silim
  @project   theater
  @class  ActorDTO
  @version  1.0.0 
  @since 24.05.2024 - 19.20
*/

import edu.sylymonka.theater.dto.role.RoleDTO;
import edu.sylymonka.theater.dto.role.RoleForActor;
import edu.sylymonka.theater.model.Role;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.time.LocalDate;
import java.time.Year;
import java.util.List;
@Data
public class ActorDTO {
    private long id;
    private String name;
    private LocalDate dateOfBirth;
    private String sex;
    private Year startedWorkFrom;
    private String rewards;
    @OneToMany(mappedBy = "actor")
    private List<RoleForActor> roles;
}
