package com.gulukal.restwebservices.helloWorld;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@ToString
public class HelloWorldBean {

    private String massage;

    public HelloWorldBean(String massage){
        this.massage = massage;
    }
    public void setMassage(String massage){
        this.massage = massage;
    }


}
