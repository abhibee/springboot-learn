package com.abhishek.example.restfulwebservice.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Autowired
	private MessageSource messageSource;
	
	@GetMapping(path="/hello")
	public String hello() {
		return "Hello!!";
	}

//	@GetMapping(path="/message")
//	public String GM_internalized(@RequestHeader(name="Accept-Language", required=false) Locale locale) {
//		return messageSource.getMessage("good.morning.message", null, locale);
//	}

	@GetMapping(path="/message")
	public String GM_internalized() {
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}


	@GetMapping(path="/hello-bean")
	public HelloBean hellobean() {
		return new HelloBean("Hello!!");
	}

	@GetMapping(path="/path-variable/{name}")
	public HelloBean hellopathvar(@PathVariable String name) {
		return new HelloBean(String.format("Hello %s!!",name));
	}


}
