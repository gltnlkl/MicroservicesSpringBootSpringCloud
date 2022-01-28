package com.gulukal.restwebservices.user;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //--> no need to give id to create new role even if you give id it will be ignore and go on
    private int id = 0;
    //filter min iki karakterli olmasi // massage = http custom message
    @Size(min = 2, message = "Name should have atlleast 2 characters")
    private String name;
    //filter
    @Past //filter Birth date should be in the past
    private Date birthdate;
    //one to many relation from one side
    @OneToMany(mappedBy = "user")
    private List<Post> posts;


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
