package edu.sylymonka.theater.dto.role;/*
  @author   silim
  @project   theater
  @class  RoleInsertRequest
  @version  1.0.0 
  @since 28.05.2024 - 13.13
*/

import lombok.Data;

@Data
public class RoleInsertRequest {
    private String name;
    private String type;
    private int age;
    private String sex;
    private long actor_id;
    private long play_id;
}
