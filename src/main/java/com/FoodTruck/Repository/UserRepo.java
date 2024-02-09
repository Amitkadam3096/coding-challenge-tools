package com.FoodTruck.Repository;

import com.FoodTruck.Entities.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepo extends JpaRepository<UserRegistration,Integer> {


   @Query(value="select * from  UserRegistration  where emailId='emailId'",nativeQuery = true)
    List<UserRegistration> findByEmailIdUser(@Param("emailId") String emailId);


   UserRegistration findByEmailId(String emailId);


}
