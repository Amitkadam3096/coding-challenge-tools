package com.FoodTruck.Controller;
import com.FoodTruck.Entities.TruckRegistration;
import com.FoodTruck.Entities.UserRegistration;
import com.FoodTruck.Repository.LogInRepo;
import com.FoodTruck.Repository.TruckRepository;
import com.FoodTruck.Repository.UserRepo;
import com.FoodTruck.Service.NewUserRegistration;
import com.FoodTruck.Service.ResetUserPassword;
import com.FoodTruck.Service.TruckFoodService;
import com.FoodTruck.Service.UserLogInService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    public class UserRegistrationController {

        @Autowired
        private UserRepo userRepo;
        @PersistenceContext
        private EntityManager entityManager;
        @Autowired(required = true)
        private LogInRepo logInRepo;

        @Autowired
        private TruckRepository truckRepository;
        @Autowired
        private TruckFoodService truckFoodService;

        @Autowired
        private NewUserRegistration newUserRegistration;
        @Autowired
        private ResetUserPassword resetUserPassword;
        @Autowired
        private UserLogInService userLogInService;

        @GetMapping("/users")
        public List<UserRegistration> retriveAllUsers() {
            return userRepo.findAll();

        }

        @GetMapping("/foodtrucks")
        public Iterable<TruckRegistration> retriveAllFoodTrucks() {
            return truckRepository.findAll();

        }

        @GetMapping("/login/{loginId}")
        public List<UserRegistration> checkUsers(@PathVariable String loginId) {

            System.out.println("LoginId ::: " + loginId);
            List<UserRegistration> users =  userLogInService.findByLoginId(loginId);

            if (users == null)
                System.out.println("Its null ...");
            else
                System.out.println("Not null");

            return users;

        }

        @PostMapping("/users")
        public String addNewUser(@RequestBody UserRegistration newUser) {

            UserRegistration saveUser = newUserRegistration.newUserAdd(newUser);
            return "You Are Registered Successfully " + saveUser.getEmailId();
        }

        @PostMapping("/foodTruckRegistration")
        public String addFoodTruck(@RequestBody TruckRegistration truckRegistration) {

            TruckRegistration savedTruck = truckFoodService.saveTruck(truckRegistration);

            return "Truck Details Saved " + savedTruck.getTruckId();
        }

        @PatchMapping("/passwordReset/{emailId}")
        public String passwordResetUser(@PathVariable String emailId, @RequestParam String newPassword,
                                                       @RequestParam String confirmPassword) {

            if(resetUserPassword.userCheckEmail(emailId)) {
               return resetUserPassword.passwordReset(emailId,newPassword,confirmPassword);
            }
            return "Entered Email Id is not correct";
        }
    }

