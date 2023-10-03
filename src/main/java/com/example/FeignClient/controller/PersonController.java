package com.example.FeignClient.controller;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.FeignClient.model.PersonVo;
import com.example.FeignClient.service.PersonService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.micrometer.core.ipc.http.HttpSender.Response;
@RestController
@RequestMapping("/retreive")
public class PersonController {
@Autowired
private PersonService personService;

@GetMapping("/template")
@CircuitBreaker(name = "restTemplateCircuit", fallbackMethod = "fallbackRestTemplate")
public ResponseEntity<String> getRestTemplate() throws Exception
{
	return new ResponseEntity(personService.getRestTemplate(),HttpStatus.OK);
}



@GetMapping("/feign")
@CircuitBreaker(name = "feignPersonCircuit", fallbackMethod = "fallbackFeignPerson")
public ResponseEntity<List<PersonVo>> getFeignPerson(){
	return new ResponseEntity(personService.getFeignPerson(),HttpStatus.OK);
}
public ResponseEntity<String> fallbackRestTemplate(Throwable throwable) {
    // Handle the fallback behavior (e.g., return a default response)
    return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
        .body("Service is temporarily unavailable. Please try again later.");
}

public ResponseEntity<List<PersonVo>> fallbackFeignPerson(Throwable throwable) {
    // Handle the fallback behavior for the feignPerson method
    return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
        .body(Collections.emptyList());
}
}