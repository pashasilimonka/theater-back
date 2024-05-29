package edu.sylymonka.theater.utils;/*
  @author   silim
  @project   theater
  @class  ActorUtils
  @version  1.0.0 
  @since 29.05.2024 - 14.43
*/

import edu.sylymonka.theater.dto.actor.ActorInsertRequest;
import edu.sylymonka.theater.dto.actor.ActorUpdateRequest;

import java.time.LocalDate;
import java.time.Year;

public class ActorUtils {

    public static void validateInsertRequest(ActorInsertRequest request){
        validateName(request.getName());
        validateAge(request.getAge());
        validateGender(request.getSex());
        validateYearOfBirth(request.getDateOfBirth(),request.getAge());
        validateYearOfStartOfWork(request.getStartedWorkFrom());
    }
    public static void validateUpdateRequest(ActorUpdateRequest request){
        validateName(request.getName());
        validateAge(request.getAge());
        validateGender(request.getSex());
        validateYearOfBirth(request.getDateOfBirth(),request.getAge());
        validateYearOfStartOfWork(request.getStartedWorkFrom());
    }
    private static void validateName(String name) {
        if (name==null || name.isEmpty()){
            throw new NullPointerException("Actor name cannot be null or empty");
        }
        if (name.length()<2){
            throw new IllegalArgumentException("Actor name must be at least 2 characters");
        }
    }

    private static void validateAge(int age) {
        if (age<=0){
            throw new IllegalArgumentException("Actor age cannot be negative or zero");
        }
        if (age<18){
            throw new IllegalArgumentException("Actor age must be at least 18 years");
        }
    }

    private static void validateGender(String sex) {
        if(sex==null || sex.isEmpty()){
            throw new IllegalArgumentException("Actor gender cannot be null or empty");
        }
        if(!sex.equalsIgnoreCase("male") && !sex.equalsIgnoreCase("female")){
            throw new IllegalArgumentException("Actor gender must be 'male' or 'female'");
        }
    }

    private static void validateYearOfBirth(LocalDate dateOfBirth, int age) {
        if(dateOfBirth==null){
            throw new IllegalArgumentException("Actor year birth cannot be null");
        }
        if(dateOfBirth.plusYears(age).getYear()!= LocalDate.now().getYear()){
            throw new IllegalArgumentException("Incorrect date of birth or age");
        }
    }

    private static void validateYearOfStartOfWork(Year yearOfStart) {
        if (yearOfStart==null){
            throw new IllegalArgumentException("Actor year start cannot be null");
        }
        if(yearOfStart.isAfter(Year.now())){
            throw new IllegalArgumentException("Actor started work from is after this year");
        }
    }
}
