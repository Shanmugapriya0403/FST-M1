package activities;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Activity1 {
	
  @Test(priority=1)
  public void postRequest() {
	  
	Map<String,Object> reqBody = new HashMap<>();
	reqBody.put("id", 77444);
	reqBody.put("name", "Naks");
	reqBody.put("status", "alive");
	
	Response response = given().
			baseUri("https://petstore.swagger.io/v2/pet"). 
			  header("Content-Type","application/json").
			  body(reqBody).
			  when().post();
	
	//Assertion
	response.then().body("id",equalTo(77444));
	response.then().body("name",equalTo("Naks"));
	response.then().body("status",equalTo("alive"));
	  
  }
  
  @Test(priority=2)
  public void getRequest() {
	  
	//Send request, receive response and perform assertion
	  given().
		  baseUri("https://petstore.swagger.io/v2/pet"). 
		  header("Content-Type","application/json").
		  pathParam("petId",77444).
		  log().all().
	  when().
	  		get("/{petId}").
	  then().
	  		statusCode(200).
	  		body("name", equalTo("Naks")).
	  		log().all();
	  
  }
  
  @Test(priority=3)
  public void deleteRequest() {
	  
	  
	  
	  
	  Response response = given().
		  baseUri("https://petstore.swagger.io/v2/pet"). 
		  header("Content-Type","application/json").
		  pathParam("petId",77444).
		  log().all().
	  when().delete("/{petId}");
	  
	  response.then().body("code", equalTo(200));
	  response.then().body("message", equalTo("77444"));
	  
  }
}
