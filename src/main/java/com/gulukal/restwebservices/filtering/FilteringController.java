package com.gulukal.restwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    //field1 and field2
    @GetMapping("/filtering-static")
    public SomeBean retrieveSomeBeanFilterStatic() {
        SomeBean someBean = new SomeBean("value1", "value2", "value3");

        return someBean;

    }

    //dynamic filter
    //field1 and field2
    @GetMapping("/filtering-dynamic")
    public MappingJacksonValue retrieveSomeBeanDynamic() {
        SomeBean someBean = new SomeBean("value1", "value2", "value3");

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");

        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(someBean);

        mapping.setFilters(filters);

        return mapping;

    }

    //field2 and field3
    //static filter
    @GetMapping("/filtering-list-static")
    public List<SomeBean> retrieveListSomeBeanStatic() {
        return Arrays.asList(new SomeBean("value1", "value2", "value3"),
                new SomeBean("value12", "value22", "value32"));
    }

    //field2 and field3
    //dynamic filter
    @GetMapping("/filtering-list-dynamic")
    public MappingJacksonValue retrieveListSomeBeanDynamic() {

        List<SomeBean> list = Arrays.asList(new SomeBean("value1", "value2", "value3"),
                new SomeBean("value12", "value22", "value32"));


        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");

        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(list);

        mapping.setFilters(filters);

        return mapping;
    }

}
