package com.gulukal.restwebservices.exception;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExceptionResponse {

    //timestamp
    private Date timestamp;
    //message
    private String message;
    //detail
    private String details;



}
