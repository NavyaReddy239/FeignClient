package com.example.FeignClient.eo;

import org.springframework.web.client.RestTemplate;

public interface PersonEo {
	public RestTemplate getRestTemplate();
}
