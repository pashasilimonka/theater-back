package edu.sylymonka.theater.model;/*
  @author   silim
  @project   theater
  @class  Item
  @version  1.0.0 
  @since 26.03.2024 - 13.50
*/

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String description;
}
