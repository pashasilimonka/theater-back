package edu.sylymonka.theater.model;/*
  @author   silim
  @project   theater
  @class  Image
  @version  1.0.0 
  @since 19.04.2024 - 12.49
*/

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String contentType;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] data;
}
