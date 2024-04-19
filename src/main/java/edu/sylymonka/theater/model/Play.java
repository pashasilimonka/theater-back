package edu.sylymonka.theater.model;/*
  @author   silim
  @project   theater
  @class  Play
  @version  1.0.0 
  @since 26.03.2024 - 14.06
*/

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Play {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "play_id")
    private long id;
    private String title;
    private String author;
    private String genre;
    private String plot;
    @OneToMany(mappedBy = "play")
    private List<Session> sessions;
    @OneToMany(mappedBy = "play")
    private List<Role> roles;

}
