package com.abhishek.example.restfulwebservice.filtering;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringResource {

@GetMapping(path="/static-filter")
public FieldObjectStatic getFieldObject() {
	return new FieldObjectStatic("field1","field2","field3");
}

@GetMapping(path="/dyna-filter1")
public MappingJacksonValue getFieldObject2() {

	FieldObjectDynamic myobj = new FieldObjectDynamic("field1","field2","field3");
	MappingJacksonValue  mapping = new MappingJacksonValue(myobj);
	SimpleBeanPropertyFilter filter= SimpleBeanPropertyFilter.filterOutAllExcept("field1");
	FilterProvider filters = new SimpleFilterProvider().addFilter("firstFilter", filter);
	mapping.setFilters(filters);
	
	
	return mapping;
	
}
	
@GetMapping(path="/dyna-filter2")
public MappingJacksonValue getFieldObject3() {

	FieldObjectDynamic myobj = new FieldObjectDynamic("field1","field2","field3");
	MappingJacksonValue  mapping = new MappingJacksonValue(myobj);
	SimpleBeanPropertyFilter filter= SimpleBeanPropertyFilter.filterOutAllExcept("field3");
	FilterProvider filters = new SimpleFilterProvider().addFilter("firstFilter", filter);
	mapping.setFilters(filters);
	
	
	return mapping;
	
}

}
