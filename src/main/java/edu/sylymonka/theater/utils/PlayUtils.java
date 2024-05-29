package edu.sylymonka.theater.utils;/*
  @author   silim
  @project   theater
  @class  PlayUtils
  @version  1.0.0 
  @since 29.05.2024 - 16.17
*/

import edu.sylymonka.theater.dto.play.PlayInsertRequest;
import edu.sylymonka.theater.dto.play.PlayUpdateRequest;

public class PlayUtils {
    public static void validateInsertRequest(PlayInsertRequest request){
        validateTitle(request.getTitle());
        validateAuthorName(request.getAuthor());
        validateGenre(request.getGenre());
        validatePlot(request.getPlot());
    }
    public static void validateUpdateRequest(PlayUpdateRequest request){
        validateTitle(request.getTitle());
        validateAuthorName(request.getAuthor());
        validateGenre(request.getGenre());
        validatePlot(request.getPlot());

    }
    private static void validatePlot(String plot) {
        if(plot==null|| plot.isEmpty()){
            throw new IllegalArgumentException("Plot cannot be null or empty");
        }
    }

    private static void validateGenre(String genre) {
        if(genre==null|| genre.isEmpty()){
            throw new IllegalArgumentException("Genre cannot be null or empty");
        }
    }

    private static void validateAuthorName(String author) {
        if(author==null|| author.isEmpty()){
            throw new IllegalArgumentException("Author cannot be null or empty");
        }
        if(author.length()<2){
            throw new IllegalArgumentException("Author name cannot be less than 2");
        }
    }

    private static void validateTitle(String title) {
        if (title==null|| title.isEmpty()){
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        if (title.length()<2){
            throw new IllegalArgumentException("Title cannot be less than 2");
        }
    }
}
