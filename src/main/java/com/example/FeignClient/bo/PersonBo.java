package com.example.FeignClient.bo;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.FeignClient.model.PersonVo;

public interface PersonBo {
	public ResponseEntity<String> getRestTemplate();
	public ResponseEntity<List<PersonVo>> getFeignPerson();
}
