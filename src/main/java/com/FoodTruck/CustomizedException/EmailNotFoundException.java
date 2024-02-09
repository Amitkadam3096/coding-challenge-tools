package com.FoodTruck.CustomizedException;

public class EmailNotFoundException extends RuntimeException{

    public EmailNotFoundException(String message){
        super(message);
    }



}
