package nitin.automation.pageobjects.apiLearning;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class WithoutRequestSpecExample10 {

	@Test
	public void getAllBookings()
	{
		// Given
		RestAssured
		  .given()
		  // Common baseURI and basePath
			 .baseUri("https://restful-booker.herokuapp.com")
			 .basePath("/booking")
		// When
		   .when().get()
		// Then
		   .then()
		   .statusLine("HTTP/1.1 200 OK");	
		
	}
	
	@Test
	public void getBookingDetailsWithInvalidFirstName()
	{
		// Given
		RestAssured
		  .given()
		  // Common baseURI and basePath
			 .baseUri("https://restful-booker.herokuapp.com")
			 .basePath("/booking")
			 .param("firstName", "Rahul")
		// When
		   .when().get()
		// Then
		   .then()
		   .statusLine("HTTP/1.1 200 OK");		
	}
}
