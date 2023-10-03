package com.example.FeignClient.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.FeignClient.model.PersonVo;

public interface PersonService {
	public ResponseEntity<String> getRestTemplate() throws Exception;
	public ResponseEntity<List<PersonVo>> getFeignPerson();
}
