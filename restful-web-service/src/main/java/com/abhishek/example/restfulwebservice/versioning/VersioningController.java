package com.abhishek.example.restfulwebservice.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningController {

	
@GetMapping(path="/v1/name")
public PersonV1 getName() {
	return new PersonV1("Abhi Shar");
}
@GetMapping(path="/v2/name")
public PersonV2 getName2() {
	return new PersonV2("Abhi","Shar");
}

//Param
@GetMapping(path="/name", params="version=1")
public PersonV1 getName3() {
	return new PersonV1("Abhi Shar");
}
@GetMapping(path="/name", params="version=2")
public PersonV2 getName4() {
	return new PersonV2("Abhi","Shar");
}

//Header
@GetMapping(path="/name", headers="version=1")
public PersonV1 getName5() {
	return new PersonV1("Abhi Shar");
}
@GetMapping(path="/name", headers="version=2")
public PersonV2 getName6() {
	return new PersonV2("Abhi","Shar");
}

//Header-producers(mime)
@GetMapping(path="/name", produces="application/techzaar.company.app-v1+json")
public PersonV1 getName7() {
	return new PersonV1("Abhi Shar");
}
@GetMapping(path="/name", produces="application/techzaar.company.app-v2+json")
public PersonV2 getName8() {
	return new PersonV2("Abhi","Shar");
}


}
