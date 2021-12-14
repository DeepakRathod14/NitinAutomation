package nitin.automation.pageobjects.apiLearning;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

/**
 * 1. We need to pass booking id which you want to delete in URI. E.g. https://restful-booker.herokuapp.com/booking/1 where "1" is booking id.
 * 2. Authentication token need to pass as cookie. Cookie name is "token" and value is generated auth token. 'Cookie: token=<generatedToken>'.
 * 3. You don’t required to pass body to DELETE request.
 * @author Deepak.Rathod
 */
public class DeleteRequest7 {

	public static void main(String[] args) {
		bdd_Style_DeleteRequest();
	}
	
	public static void no_Bdd_Style_DeleteRequest() {
		// Create a request specification
		RequestSpecification request = RestAssured.given();
 
		// Setting a cookie for authentication as per API documentation
		request.cookie("token", "f4e70e7b9bbcd05");
		// Adding URI
		request.baseUri("https://restful-booker.herokuapp.com/booking/1");
		
		// Calling PUT method on URI. After hitting we get Response
		Response response = request.delete();
 
		// Printing Response as string
		System.out.println(response.asString());
 
		// Get Validatable response to perform validation
		ValidatableResponse validatableResponse = response.then();
 
		// Validate status code as 201 as per API documentation
		validatableResponse.statusCode(201);
 
		// Validate if booking is actually deleted. 
		RequestSpecification getRequestSpec = RestAssured.given();
		
		// Adding URI
		getRequestSpec.baseUri("https://restful-booker.herokuapp.com/booking/1");
		
		// Calling GET request
		Response res = getRequestSpec.get();
		
		// Get Validatable response to perform validation
		ValidatableResponse valRes = res.then();
		
		// It will check if status code is 404 as booking id should not be found
		valRes.statusCode(404);
	}

	public static void bdd_Style_DeleteRequest() {
		// Delete Booking
		//GIVEN
		RestAssured
			.given()
					.baseUri("https://restful-booker.herokuapp.com/booking/1")
					.cookie("token", PostRequest4.getToken())
			// WHEN
			.when()
					.delete()
			// THEN
			.then()
					.assertThat() //Optional
					.statusCode(201);
		
		// Verifying booking is deleted
		// Given
		RestAssured
		    .given()
				    .baseUri("https://restful-booker.herokuapp.com/booking/1")
		// When
			.when()
					.get()
		// Then
			.then()
					.statusCode(404);
	}
}
