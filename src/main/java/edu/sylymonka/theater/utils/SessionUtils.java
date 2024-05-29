package edu.sylymonka.theater.utils;/*
  @author   silim
  @project   theater
  @class  SessionUtils
  @version  1.0.0 
  @since 29.05.2024 - 16.49
*/

import edu.sylymonka.theater.dto.session.SessionInsertRequest;
import edu.sylymonka.theater.dto.session.SessionUpdateRequest;

import java.time.LocalDate;
import java.time.LocalTime;

public class SessionUtils {
    public static void validateInsertRequest(SessionInsertRequest request){
        validateDateOfSession(request.getDateOfSession());
        validateTimeOfSession(request.getTimeOfSession());
    }
    public static void validateUpdateRequest(SessionUpdateRequest request){
        validateDateOfSession(request.getDateOfSession());
        validateTimeOfSession(request.getTimeOfSession());
    }
    private static void validateDateOfSession(LocalDate dateOfSession){
        if(dateOfSession==null){
            throw new IllegalArgumentException("Date of session cannot be null");
        }
        if(dateOfSession.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("Date of session is before current date");
        }
    }
    private static void validateTimeOfSession(LocalTime timeOfSession){
        if (timeOfSession==null){
            throw new IllegalArgumentException("Time of session cannot be null");
        }
        if (timeOfSession.isBefore(LocalTime.parse("10:00") )|| timeOfSession.isAfter(LocalTime.parse("22:00"))){
            throw new IllegalArgumentException("Time of session should be in the period from 10:00 to 22:00");
        }
}
}
