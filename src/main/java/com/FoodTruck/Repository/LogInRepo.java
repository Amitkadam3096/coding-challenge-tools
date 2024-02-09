package com.FoodTruck.Repository;

import com.FoodTruck.Entities.UserRegistration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import java.util.List;

@Repository
public interface LogInRepo extends JpaRepository<UserRegistration,Integer> {

    List<UserRegistration> findByLoginId(String loginId);
}
