package edu.sylymonka.theater.dto.credentials;/*
  @author   silim
  @project   theater
  @class  CredentialsDto
  @version  1.0.0 
  @since 03.06.2024 - 17.53
*/

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CredentialsDto {

    private String login;
    private char[] password;
}
