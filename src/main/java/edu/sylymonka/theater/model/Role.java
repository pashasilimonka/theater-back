package edu.sylymonka.theater.model;/*
  @author   silim
  @project   theater
  @class  Role
  @version  1.0.0 
  @since 19.04.2024 - 12.30
*/

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private long id;
    private String name;
    private String type;
    private int age;
    private String sex;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "actor_id")
    private Actor actor;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "play_id")
    private Play play;

    public Role(String name,String type,int age, String sex, Actor actor, Play play){
        this.name=name;
        this.type=type;
        this.age=age;
        this.sex=sex;
        this.actor=actor;
        this.play=play;
    }
}
