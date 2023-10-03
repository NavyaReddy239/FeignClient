package step.defination;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.Method;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.FeignClient;

import io.cucumber.junit.Cucumber;
import io.cucumber.spring.CucumberContextConfiguration;

import com.example.FeignClient.bo.PersonBoImpl;
import com.example.FeignClient.retreival.PersonDetailRetreival;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

@CucumberContextConfiguration
@RunWith(Cucumber.class)

@SpringBootTest(classes = FeignClient.class)
public class ExampleDefination {

    private Response response;
    private WireMockServer wireMockServer;
  
    @Before
    public void setUpWireMock() {
        wireMockServer = new WireMockServer(WireMockConfiguration.options().port(8080)); // Use the port your application expects
        wireMockServer.start();
        configureWireMockForRestTemplate();
       
    }

 

	@After
    public void tearDownWireMock() {
        wireMockServer.stop();
    }

    private void configureWireMockForRestTemplate() {
        stubFor(
        		get(urlEqualTo("/persons/get/persons/get/retreive/template")) 
        		.willReturn(
        		aResponse()
        		.withStatus(200)
        		.withHeader("Content-Type", "application/json")
        		.withBody("{\"name\":\"John\",\"id\":\"no1\"}")
        		 
                )
        );
    }

   

    @Given("Get Call to url")
    public void getCallToUrl() {
        RestAssured.baseURI = PersonBoImpl.url; 
        RequestSpecification httpRequest = RestAssured.given();
        response = httpRequest.request(Method.GET, "/persons/get/retreive/template");
        System.out.println("Get person data from WireMock");
    
    }
   

    @Then("Response Code status is validated")
    public void responseCodeStatusIsValidated() {
        int responseStatus = response.getStatusCode();
        System.out.println("Get the status code: " + responseStatus);
        Assert.assertEquals(200, responseStatus);
    }

    @Then("verify response content type is {string}")
    public void verifyResponseContentTypeIs(String contentType) {
        Assertions.assertTrue(response.getContentType().contains(contentType));
    }

    @Then("print out the response body to console")
    public void printOutTheResponseBodyToConsole() {
        String responseBody = response.getBody().asString();
        System.out.println("ResponseBody: " + responseBody);
    }


}
