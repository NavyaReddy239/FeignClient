package com.example.FeignClient.eo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.FeignClient.helper.PersonRestHelper;

@Component
public class PersonEoImpl implements PersonEo {
	@Autowired 
	private PersonRestHelper personRestHelper;
	Logger logger = LoggerFactory.getLogger(PersonRestHelper.class);
	public RestTemplate getRestTemplate()
	{
		return personRestHelper.getRestTemplate();
	}
}
