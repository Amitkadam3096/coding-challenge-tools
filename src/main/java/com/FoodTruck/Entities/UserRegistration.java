package com.FoodTruck.Entities;
import jakarta.persistence.*;
import lombok.*;



@Setter
@Getter
@AllArgsConstructor
@ToString
@Entity()
@Table(name = "user_tab")
public class UserRegistration {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;


    @Column(name = "loginId")
    String loginId;

    @Column(name = "loginType")
    String loginType;

    @Column(name = "password")
    private String password;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;


    @Column(name = "emailId")
    private String emailId;


    @Column(name = "mobileNumber")
    private String mobileNumber;

    public UserRegistration() {

    }
    public UserRegistration(
            String loginType,
            String loginId,
            String password,
            String firstName,
            String lastName,
            String emailId,
            String mobileNumber) {
        super();
        this.loginType = loginType;
        this.loginId = loginId;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.mobileNumber = mobileNumber;
    }



}