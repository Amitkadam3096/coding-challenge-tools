package com.FoodTruck.Repository;

import com.FoodTruck.Entities.TruckRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TruckRepository extends JpaRepository<TruckRegistration,Integer> {




}
