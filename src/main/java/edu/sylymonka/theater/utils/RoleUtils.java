package edu.sylymonka.theater.utils;/*
  @author   silim
  @project   theater
  @class  RoleUtils
  @version  1.0.0 
  @since 29.05.2024 - 16.35
*/

import edu.sylymonka.theater.dto.role.RoleInsertRequest;
import edu.sylymonka.theater.dto.role.RoleUpdateRequest;

public class RoleUtils {
    public static void validateInsertRequest(RoleInsertRequest request){
        validateName(request.getName());
        validateTypeOfRole(request.getType());
        validateAge(request.getAge());
        validateGender(request.getSex());
    }
    public static void validateUpdateRequest(RoleUpdateRequest request){
        validateName(request.getName());
        validateTypeOfRole(request.getType());
        validateAge(request.getAge());
        validateGender(request.getSex());
    }


    private static void validateGender(String sex) {
        if(sex==null || sex.isEmpty()){
            throw new IllegalArgumentException("Actor gender cannot be null or empty");
        }
        if(!sex.equalsIgnoreCase("male") && !sex.equalsIgnoreCase("female")){
            throw new IllegalArgumentException("Actor gender must be 'male' or 'female'");
        }
    }

    private static void validateAge(int age) {
        if (age<=0){
            throw new IllegalArgumentException("Actor age cannot be negative or zero");
        }
    }

    private static void validateTypeOfRole(String typeOfRole){
        if (typeOfRole==null || typeOfRole.isEmpty()){
            throw new IllegalArgumentException("Role cannot be null or empty");
        }
        if (!typeOfRole.equalsIgnoreCase("main") && !typeOfRole.equalsIgnoreCase("secondary") ){
            throw new IllegalArgumentException("Role type must be 'main' or 'secondary'");
        }
    }

    private static void validateName(String name){
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if(name.length() > 50 || name.length() < 2){
            throw new IllegalArgumentException("Name must be between 2 and 50 characters");
        }
    }
}
