package com.FoodTruck.Service;

import com.FoodTruck.Controller.UserRegistrationController;
import com.FoodTruck.Entities.UserRegistration;
import com.FoodTruck.Repository.LogInRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserLogInService {


    @Autowired
    LogInRepo logInRepo;


    @Transactional
    public List<UserRegistration> findByLoginId(String loginId) {
        List<UserRegistration> user = logInRepo.findByLoginId(loginId);

        return user;
    }

}
