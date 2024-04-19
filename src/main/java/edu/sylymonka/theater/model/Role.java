package edu.sylymonka.theater.model;/*
  @author   silim
  @project   theater
  @class  Role
  @version  1.0.0 
  @since 19.04.2024 - 12.30
*/

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private long id;
    private String name;
    private String type;
    @ManyToOne
    private Actor actor;
    @ManyToOne
    private Play play;

}
