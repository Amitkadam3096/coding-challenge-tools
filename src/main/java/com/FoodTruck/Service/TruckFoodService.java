package com.FoodTruck.Service;

import com.FoodTruck.Entities.TruckRegistration;
import com.FoodTruck.Repository.TruckRepository;
import org.springframework.stereotype.Service;

@Service
public class TruckFoodService {

    private TruckRepository truckRepository;

    public TruckFoodService(TruckRepository truckRepository) {
        this.truckRepository = truckRepository;
    }


    public TruckRegistration saveTruck(TruckRegistration truckRegistration ) {
        TruckRegistration savedTruck = truckRepository.save(truckRegistration);
        return savedTruck;
    }



}
