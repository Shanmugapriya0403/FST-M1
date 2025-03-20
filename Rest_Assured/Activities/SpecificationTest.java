package examples;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class SpecificationTest {
	
	RequestSpecification requestspec;
	ResponseSpecification responsespec;
	int petId = 0;
	
	@BeforeClass
	public void setUp() {
		
		//Request specifications
		requestspec = new RequestSpecBuilder().
				setBaseUri("https://petstore.swagger.io/v2/pet").
				addHeader("Content-Type","application/json").
				build();
		
		//Response specifications
		responsespec = new ResponseSpecBuilder().
				expectStatusCode(200).
				expectResponseTime(lessThanOrEqualTo(3000L)).
				build();
		
	}
	
	// POST 
	@Test(priority=1)
	  public void postRequest() {
		  
		Map<String,Object> reqBody = new HashMap<>();
		reqBody.put("id", 77444);
		reqBody.put("name", "Naks");
		reqBody.put("status", "alive");
		
		Response response = given().
								spec(requestspec).
								body(reqBody).
							when().
								post();
		//Extract petID
		petId = response.then().extract().path("id");
		//Assertion
		response.then().spec(responsespec).body("name", equalTo("Naks"));
		  
	  }
	  
	//GET
	  @Test(priority=2)
	  public void getRequest() {
		  
		//Send request, receive response and perform assertion
		  given().spec(requestspec).pathParam("petId", petId).
		  when().
		  		get("/{petId}").
		  then().spec(responsespec).body("name", equalTo("Naks"));
		  		
		  
	  }
	  
	  @Test(priority=3)
	  public void deleteRequest() {
		  
		   given().
				  spec(requestspec).
				  pathParam("petId", petId).
		  when().
		  			delete("/{petId}").
		  then().
		  			spec(responsespec).
		  			body("message", equalTo(""+petId));
		   //petId is coming as string in response so converting it to string here
	  }
}
