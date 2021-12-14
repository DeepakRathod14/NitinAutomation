package nitin.automation.pageobjects.apiLearning.jackson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class _16_PostPayload_As_Object {

	//@Test
	public void simpleObject() {
		Map<String, String> authPayload = new HashMap<String, String>();
		authPayload.put("username", "admin");
		authPayload.put("password", "password123");

		// GIVEN
		RestAssured.given().baseUri("https://restful-booker.herokuapp.com/auth").contentType(ContentType.JSON)
				.body(authPayload).log().all()
				// WHEN
				.when().post()
				// THEN
				.then().assertThat().statusCode(200).log().all();
	}
	
	//@Test
	public void complexObject() {
		Map<String,Object> jsonBodyUsingMap = new HashMap<String,Object>();
		jsonBodyUsingMap.put("firstname", "Jim");
		jsonBodyUsingMap.put("lastname", "Brown");
		jsonBodyUsingMap.put("totalprice", 111);
		jsonBodyUsingMap.put("depositpaid", true);
		
		Map<String,String> bookingDatesMap = new HashMap<>();
		bookingDatesMap.put("checkin", "2021-07-01");
		bookingDatesMap.put("checkout", "2021-07-01");
		
		jsonBodyUsingMap.put("bookingdates", bookingDatesMap);
		jsonBodyUsingMap.put("additionalneeds", "Breakfast");
		
		
		//GIVEN
		RestAssured
		   .given()
			  .baseUri("https://restful-booker.herokuapp.com/booking")
			  .contentType(ContentType.JSON)
			  .body(jsonBodyUsingMap)
			  .log()
			  .all()
		// WHEN
		   .when()
			   .post()
		// THEN
		   .then()
			   .assertThat()
			   .statusCode(200)
			   .log()
			   .all();
	}
	
	@Test(enabled = true, description = "This example is not supported by API, but it's just for demo purpose "
			+ "that how can we create json array and pass it to body. Response = '500 Internal Server Error'")
	public void jsonArrayExample() {
		// JSON Object for first guest
				Map<String,Object> bookingOne = new HashMap<String,Object>();
				bookingOne.put("firstname", "Amod");
				bookingOne.put("lastname", "Mahajan");
				bookingOne.put("totalprice", 222);
				bookingOne.put("depositpaid", true);
				
				Map<String,String> bookingDatesMapForAmod = new HashMap<>();
				bookingDatesMapForAmod.put("checkin", "2021-08-01");
				bookingDatesMapForAmod.put("checkout", "2021-08-02");
				
				bookingOne.put("bookingdates", bookingDatesMapForAmod);
				bookingOne.put("additionalneeds", "Breakfast");
				
				// JSON Object for second guest
				Map<String,Object> bookingTwo = new HashMap<String,Object>();
				bookingTwo.put("firstname", "Animesh");
				bookingTwo.put("lastname", "Prashant");
				bookingTwo.put("totalprice", 111);
				bookingTwo.put("depositpaid", true);
				
				Map<String,String> bookingDatesMapForAnimesh = new HashMap<>();
				bookingDatesMapForAnimesh.put("checkin", "2021-07-01");
				bookingDatesMapForAnimesh.put("checkout", "2021-07-01");
				
				bookingTwo.put("bookingdates", bookingDatesMapForAnimesh);
				bookingTwo.put("additionalneeds", "Breakfast");
				
				// Creating JSON array to add both JSON objects
				List<Map<String,Object>> jsonArrayPayload = new ArrayList<>();
				
				jsonArrayPayload.add(bookingOne);
				jsonArrayPayload.add(bookingTwo);
				
				
				
				//GIVEN
				RestAssured
				   .given()
					  .baseUri("https://restful-booker.herokuapp.com/booking")
					  .contentType(ContentType.JSON)
					  .body(jsonArrayPayload)
					  .log()
					  .all()
				// WHEN
				   .when()
					   .post()
				// THEN
				   .then()
					   .assertThat()
					   // Asserting status code as 500 as it does not accept json array payload
					   .statusCode(500)
					   .log()
					   .all();
	}
}
