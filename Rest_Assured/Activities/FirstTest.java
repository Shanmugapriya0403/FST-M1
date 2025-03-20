package examples;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;

public class FirstTest {
	
	//GET https://petstore.swagger.io/v2/pet/findByStatus?status=alive
  @Test
  public void getRequestWithQueryParam() {

	  //Create response object
	  
	  Response response = 
			  given(). //Request specifications
				  baseUri("https://petstore.swagger.io/v2/pet").
				  header("Content-Type","application/json").
				  queryParam("status", "alive").
			  when(). //Send request and receive response
			  		get("/findByStatus");
	  
	  //Print response body
	  System.out.println(response.getBody().asString());
	  System.out.println(response.getBody().asPrettyString());
	  
	  //Print response headers
	  System.out.println(response.getHeaders().asList());
	  System.out.println(response.getStatusCode());
	  System.out.println(response.getStatusLine());
	  
	  //Extract values from response
	  String petStatus = response.then().extract().path("[0].status");
	  
	  
	  //Print and assert the pet status TestNg
	  assertEquals(petStatus,"alive");
	  
	  //Restassured assertion
	  response.then().statusCode(200).body("[0].status",equalTo("alive"));
	  
  }
  //GET https://petstore.swagger.io/v2/pet/{petId}
  @Test
  public void getRequestWithPathParam() {
	  
	  //Send request, receive response and perform assertion
	  given().
		  baseUri("https://petstore.swagger.io/v2/pet"). 
		  header("Content-Type","application/json").
		  pathParam("petId",77232).
		  log().all().
	  when().
	  		get("/{petId}").
	  then().
	  		statusCode(200).
	  		body("name", equalTo("Hansel")).
	  		log().all();
	  		
	  
	  
	  
  }
  
}
