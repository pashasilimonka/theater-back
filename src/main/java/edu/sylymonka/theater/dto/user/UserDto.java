package edu.sylymonka.theater.dto.user;/*
  @author   silim
  @project   theater
  @class  UserDto
  @version  1.0.0 
  @since 03.06.2024 - 17.40
*/

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserDto {
    private long id;
    private String firstName;
    private String lastName;
    private String login;
    private String token;

}
