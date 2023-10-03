package com.example.FeignClient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.FeignClient.bo.PersonBo;
import com.example.FeignClient.eo.PersonEo;
import com.example.FeignClient.model.PersonVo;
@Component
public class PersonServiceImpl implements PersonService {
	@Autowired
	private PersonBo personBo;
	public ResponseEntity<String> getRestTemplate() throws Exception
	{
		if (Math.random() < 0.5) {
		    throw new Exception("Simulated failure");
		}
		return new ResponseEntity(personBo.getRestTemplate(),HttpStatus.OK);
	}
	public ResponseEntity<List<PersonVo>> getFeignPerson(){
		return personBo.getFeignPerson();
	
}
}