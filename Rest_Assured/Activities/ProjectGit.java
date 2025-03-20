package liveProject;

import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

import java.util.HashMap;
import java.util.Map;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;

public class ProjectGit {
	
	RequestSpecification requestspec;
	ResponseSpecification responsespec;
	int sshKeyId = 0;
	String sshKey = " ";
  
	@BeforeClass
	  public void setUp() {
		
		//Request specifications
				requestspec = new RequestSpecBuilder().
						setBaseUri("https://api.github.com").
						addHeader("Authorization"," ").
						addHeader("Content-Type","application/json").
						build();
				
				
				
	  }
	
	//POST
  @Test(priority=1)
  public void addSshKey() {
	  
	  Map<String,Object> reqBody = new HashMap<>();
	  	
		reqBody.put("title", "TestAPIKey");
		reqBody.put("key", sshKey);
		
		Response response = given().
				spec(requestspec).
				body(reqBody).
			when().
				post("/user/keys");
		
		//Extract sshKeyId
		sshKeyId = response.then().extract().path("id");
		//sshKeyId = response.jsonPath().getInt("id");
				
				//Assertion
				response.then().statusCode(201);
  }
  
//GET
  @Test(priority=2)
  public void getSshKey() {
	  
		given().
				spec(requestspec).pathParam("sshKeyId", sshKeyId).
			when().
				get("/user/keys/{sshKeyId}").
			then().
				statusCode(200).
				log().all();
		
  }
  
//DELETE
  @Test(priority=3)
  public void deleteSshKey() {
	  
		given().
				spec(requestspec).pathParam("sshKeyId", sshKeyId).
			when().
				delete("/user/keys/{sshKeyId}").
			then().
				statusCode(204).
				log().all();
		
  }
  

}
