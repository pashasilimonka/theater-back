package edu.sylymonka.theater.dto.role;/*
  @author   silim
  @project   theater
  @class  RoleDTO
  @version  1.0.0 
  @since 28.05.2024 - 13.10
*/

import edu.sylymonka.theater.dto.actor.ActorDTO;
import edu.sylymonka.theater.dto.actor.ActorForRole;
import edu.sylymonka.theater.model.Actor;
import lombok.Data;

@Data
public class RoleDTO {
    private long id;
    private String name;
    private String type;
    private int age;
    private String sex;
    private ActorForRole actor;
}
