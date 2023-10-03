package com.example.FeignClient.bo;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.FeignClient.eo.PersonEo;
import com.example.FeignClient.model.PersonVo;
import com.example.FeignClient.retreival.PersonDetailRetreival;

@Service
public class PersonBoImpl implements PersonBo {
 public static String url= "http://localhost:8080/persons/get";
@Autowired
private PersonEo personEo;
@Autowired 
private PersonDetailRetreival orderDetailRetreival;
@Autowired
RestTemplate restTemplate;

public  ResponseEntity<String> getRestTemplate() {
	 HttpHeaders headers = new HttpHeaders();
     headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
     HttpEntity <String> entity = new HttpEntity<String>(headers);
    String response= restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();
    return new ResponseEntity<String>(response,HttpStatus.OK);
      }
public ResponseEntity<List<PersonVo>>getFeignPerson(){
	return  orderDetailRetreival.getPersonVo();
	
}
}
