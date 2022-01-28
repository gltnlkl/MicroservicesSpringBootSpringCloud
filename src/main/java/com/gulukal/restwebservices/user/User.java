package com.gulukal.restwebservices.user;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY) //--> no need to give id to create new role even if you give id it will be ignore and go on
    private int id = 0;
    //filter
    @Size(min = 2, message = "Name should have atlleast 2 characters")
    //min iki karakterli olmasi // massage = http custom message
    private String name;
    //filter
    @Past  //gecmis zaman olmasi
    private Date birthdate;


}
