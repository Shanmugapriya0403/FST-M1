package liveProject;
import static io.restassured.RestAssured.given;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.hamcrest.Matchers.equalTo;

import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;

@ExtendWith(PactConsumerTestExt.class)
public class ConsumerTest {
	
	//Set the headers
	Map<String,String> headers = new HashMap<>();
	
	//Create the contract pact
	@Pact(consumer="UserConsumer",provider="UserProvider")
	public RequestResponsePact createPact(PactDslWithProvider builder) {
		//Set the headers
		headers.put("Content-Type","application/json");
		
		//request and response body
		DslPart reqResBody = new PactDslJsonBody().
				numberType("id",1234).
				stringType("firstName","Shanmugapriya").
				stringType("lastName","Murugan").
				stringType("email","abc@gmail.com");
		
		
		//Create the pact
		return builder.given("POST Request")
				.uponReceiving("A request to create a user")
				.method("POST")
				.path("/api/users")
				.headers(headers)
				.body(reqResBody)
			.willRespondWith()
				.status(201)
				.body(reqResBody)
			.toPact();
	}
	
	//consumer test with mock provider
  @Test
  @PactTestFor(providerName="UserProvider", port="8181")
  public void postRequestTest() {
	  
	  //create request body
	  Map<String,Object> reqBody = new HashMap<>();
	  reqBody.put("id", 1234);
	  reqBody.put("firstName", "Shanmugapriya");
	  reqBody.put("lastName", "Murugan");
	  reqBody.put("email", "abc@gmail.com");
	  
	  //send request , get response and add assertions
	  given().
	  	baseUri("http://localhost:8181/api/users").
	  	headers(headers).
	  	body(reqBody).
	  	log().all().
	  when().post().
	  then().statusCode(201).
	  	body("firstName", equalTo("Shanmugapriya")).
	  	log().all();
  }
}
