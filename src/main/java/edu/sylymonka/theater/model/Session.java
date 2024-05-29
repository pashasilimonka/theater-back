package edu.sylymonka.theater.model;/*
  @author   silim
  @project   theater
  @class  Session
  @version  1.0.0 
  @since 26.03.2024 - 14.08
*/

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sessions")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "session_id")
    private long id;
    private LocalDate dateOfSession;
    private LocalTime timeOfSession;
    @ManyToOne
    @JoinColumn(name = "play_id")
    private Play play;

    public Session(
            LocalDate dateOfSession,
            LocalTime timeOfSession,
            Play play){
        this.dateOfSession=dateOfSession;
        this.timeOfSession=timeOfSession;
        this.play=play;
    }




}
