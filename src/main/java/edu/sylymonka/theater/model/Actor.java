package edu.sylymonka.theater.model;/*
  @author   silim
  @project   theater
  @class  Actor
  @version  1.0.0 
  @since 19.04.2024 - 12.23
*/

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.Year;
import java.util.List;

@Entity
@Data
@Table(name = "actors")
@Schema(
        name = "Actor",
        description = "Model for actors table"
)
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id")
    private long id;
    private String name;
    private LocalDate dateOfBirth;
    private int age;
    private String sex;
    private Year startedWorkFrom;
    private String rewards;
    @OneToMany(mappedBy = "actor")
    private List<Role> roles;
}
