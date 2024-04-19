package edu.sylymonka.theater.model;/*
  @author   silim
  @project   theater
  @class  Session
  @version  1.0.0 
  @since 26.03.2024 - 14.08
*/

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.time.LocalDate;

@Entity
@Data
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "session_id")
    private long id;
    private LocalDate dateOfSession;
    private Time timeOfSession;
    @ManyToOne
    private Play play;





}
