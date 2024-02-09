package com.FoodTruck.Service;

import com.FoodTruck.Entities.UserRegistration;
import com.FoodTruck.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;



@Service
public class NewUserRegistration {

    private UserRepo userRepo;


    public NewUserRegistration(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    public UserRegistration newUserAdd(UserRegistration newUserRegister){

       return  userRepo.save(newUserRegister);

    }




}
