package edu.sylymonka.theater.dto.play;/*
  @author   silim
  @project   theater
  @class  PlayUpdateRequest
  @version  1.0.0 
  @since 24.05.2024 - 19.01
*/

import jakarta.annotation.Nonnull;
import lombok.Data;

@Data
public class PlayUpdateRequest {
    private long id;
    @Nonnull
    private String title;
    @Nonnull
    private String author;
    @Nonnull
    private String genre;
    @Nonnull
    private String plot;
}
