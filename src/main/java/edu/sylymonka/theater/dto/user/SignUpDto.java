package edu.sylymonka.theater.dto.user;/*
  @author   silim
  @project   theater
  @class  SignUpDto
  @version  1.0.0 
  @since 03.06.2024 - 18.25
*/

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class SignUpDto {
    private String firstName;
    private String lastName;
    private String login;
    private char[] password;
}
