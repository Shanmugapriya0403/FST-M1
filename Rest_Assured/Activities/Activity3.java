package activities;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

public class Activity3 {
	
	RequestSpecification requestspec;
	ResponseSpecification responsespec;
	int petId = 0;
  
  @BeforeClass
  public void beforeClass() {
	  
	//Request specifications
		requestspec = new RequestSpecBuilder().
				setBaseUri("https://petstore.swagger.io/v2/pet").
				addHeader("Content-Type","application/json").
				build();
		
		//Response specifications
		responsespec = new ResponseSpecBuilder().
				expectStatusCode(200).
				expectContentType("application/json").
				expectResponseTime(lessThanOrEqualTo(3000L)).
				expectBody("status",equalTo("alive")).
				build();
		
  }
  
  @DataProvider(name = "petInfo")
  public Object[][] petInfoProvider(){
	  
	// Setting parameters to pass to test case
	  Object[][] testData = new Object[][] {
		{ 77232, "Naks", "alive" }, 
		{ 77233, "Losh", "alive" } 
	  };
	  return testData;
  }
  
  //POST
  @Test(priority=1, dataProvider = "petInfo")
  public void addPets(int petId, String petName, String petStatus) {
	  
	  Map<String, Object> reqBody = new HashMap<>();
		reqBody.put("id", petId);
		reqBody.put("name", petName);
		reqBody.put("status", petStatus);
		
		given().spec(requestspec).body(reqBody).when().post().
		then().spec(responsespec).body("name", equalTo(petName));
  }
  
  //GET
  @Test( priority=2, dataProvider = "petInfo")
	public void getPets(int petId, String petName, String petStatus) {
		given().spec(requestspec) 
			.pathParam("petId", petId) // Add path parameter
			.log().all() // Log for request details
		.when()
			.get("/{petId}") // Send GET request
		.then().spec(responsespec) // Assertions using responseSpec
		    .body("name", equalTo(petName)) // Additional Assertion
		    .log().all(); // Log for request details
	}
  
  //DELETE
  @Test(priority=3, dataProvider = "petInfo")
	public void deletePets(int petId, String petName, String petStatus) {
		given().spec(requestspec) // Use requestSpec
			.pathParam("petId", petId) // Add path parameter
		.when()
			.delete("/{petId}") // Send GET request
		.then()
			.body("code", equalTo(200))
			.body("message", equalTo(""+petId)); // Assertions using responseSpec
	}

}
