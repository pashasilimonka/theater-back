package edu.sylymonka.theater.dto.role;/*
  @author   silim
  @project   theater
  @class  RoleForActor
  @version  1.0.0 
  @since 28.05.2024 - 13.38
*/

import edu.sylymonka.theater.dto.play.PlayForRole;
import lombok.Data;

@Data
public class RoleForActor {
    private long id;
    private String name;
    private String type;
    private PlayForRole play;
}
