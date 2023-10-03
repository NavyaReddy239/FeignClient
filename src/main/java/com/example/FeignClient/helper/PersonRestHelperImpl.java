package com.example.FeignClient.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PersonRestHelperImpl implements PersonRestHelper {
	
	Logger logger = LoggerFactory.getLogger(PersonRestHelper.class);
	 @Bean
     public RestTemplate getRestTemplate() {
        return new RestTemplate();
     }
}

