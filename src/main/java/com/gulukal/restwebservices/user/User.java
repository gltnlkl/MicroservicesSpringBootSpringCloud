package com.gulukal.restwebservices.user;

import lombok.*;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private int id =0;

    @Size(min=2,message="Name should have atlleast 2 characters") //min iki karakterli olmasi // massage = http custom message
    private String name;
    @Past  //gecmis zaman olmasi
    private Date birthdate;


}
