package com.gulukal.restwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
//static filtering
//   //@JsonIgnore yerine bu sekilde kullanabilirsin    //@JsonIgnore icin bu anotationa gerek yok
//@JsonIgnoreProperties(value = {"field1", "field2"})
//@JsonIgnoreProperties
//burada filtreleme icin eklememiz gerekir dynamic filter icin
@JsonFilter("SomeBeanFilter")
public class SomeBean {

    private String field1;

    //secure field static filtering
    //@JsonIgnore
    private String field2;

    //secure field static filtering
    //@JsonIgnore
    private String field3;
}
