package edu.sylymonka.theater.model;/*
  @author   silim
  @project   theater
  @class  Play
  @version  1.0.0 
  @since 26.03.2024 - 14.06
*/

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "play")
public class Play {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "play_id")
    private long id;
    @Nonnull
    private String title;
    @Nonnull
    private String author;
    @Nonnull
    private String genre;
    @Nonnull
    private String plot;
    @JsonIgnore
    @OneToMany(mappedBy = "play")
    private List<Session> sessions;
    @OneToMany(mappedBy = "play")
    private List<Role> roles;

    public Play(){}
    public Play(String title, String author, String genre,String plot){
        this.title=title;
        this.author=author;
        this.genre=genre;
        this.plot=plot;
    }
}
