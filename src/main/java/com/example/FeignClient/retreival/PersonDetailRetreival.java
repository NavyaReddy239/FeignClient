package com.example.FeignClient.retreival;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.FeignClient.model.PersonVo;

@FeignClient(value="feignclient",url="http://localhost:8080/persons")
public interface PersonDetailRetreival {
	String url = "http://localhost:8080/persons" ;

	@GetMapping("/get")
	public ResponseEntity<List<PersonVo>> getPersonVo();
}
