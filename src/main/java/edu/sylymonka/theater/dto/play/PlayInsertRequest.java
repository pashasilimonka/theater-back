package edu.sylymonka.theater.dto.play;/*
  @author   silim
  @project   theater
  @class  PlayInsertRequest
  @version  1.0.0 
  @since 24.05.2024 - 18.51
*/

import jakarta.annotation.Nonnull;
import lombok.Data;

@Data
public class PlayInsertRequest {
    @Nonnull
    private String title;
    @Nonnull
    private String author;
    @Nonnull
    private String genre;
    @Nonnull
    private String plot;
}
