package com.FoodTruck.Service;

import com.FoodTruck.CustomizedException.EmailNotFoundException;
import com.FoodTruck.Entities.UserRegistration;
import com.FoodTruck.Repository.UserRepo;
import org.antlr.v4.runtime.InputMismatchException;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ResetUserPassword {

    @Autowired
    private UserRepo userRepo;

    public Boolean userCheckEmail(String emailId) {

        try {
            UserRegistration checkEmailId = userRepo.findByEmailId(emailId);

            if (checkEmailId.getEmailId().equals(emailId)) {
                return true;
            } else {
                return false;
            }
        } catch (NullPointerException NPE) {
            System.out.println("Email Id not exist");
        }
        return false;
    }

    public String passwordReset(String emailId, String newPassword, String confirmPassword) {
        if (newPassword.equals(confirmPassword)) {
            UserRegistration userRegistered = userRepo.findByEmailId(emailId);

            userRegistered.setPassword(newPassword);
            userRepo.save(userRegistered);

            return "Password Changed Successfully " + newPassword;
        }
        return "new Password and Confirm Password should be same";
    }

}