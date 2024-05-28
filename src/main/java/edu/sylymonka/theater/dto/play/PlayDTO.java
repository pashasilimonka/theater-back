package edu.sylymonka.theater.dto.play;/*
  @author   silim
  @project   theater
  @class  PlayDTO
  @version  1.0.0 
  @since 16.05.2024 - 23.43
*/

import edu.sylymonka.theater.dto.role.RoleDTO;
import edu.sylymonka.theater.model.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PlayDTO {
    private long id;
    private String title;
    private String author;
    private String genre;
    private String plot;
    private List<RoleDTO> roles;

}
