package com.FoodTruck.Entities;


import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity()
@Table(name = "food_truck_tab")
public class TruckRegistration  {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "truckId")
    public int truckId;

    @Column(name = "bulkOrderFlag")
    public boolean bulkOrderFlag;

    @Column(name = "truckName")
    public String truckName;

    @Column(name = "loginId")
    public String loginId;

    @Column(name = "days")
    public String days;

    @Column(name = "timeSlot1")
    public String timeSlot1;

    @Column(name = "timeSlot2")
    public String timeSlot2;

    @Column(name = "timeSlot3")
    public String timeSlot3;

    @Column(name = "location1")
    public String location1;

    @Column(name = "location2")
    public String location2;

    @Column(name = "location3")
    public String location3;



}
