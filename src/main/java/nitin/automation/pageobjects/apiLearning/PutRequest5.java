package nitin.automation.pageobjects.apiLearning;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static nitin.automation.pageobjects.apiLearning.StaticMembers_1.*;

/*
 * 1. GET: https://restful-booker.herokuapp.com/booking/1
 * 2. Verify response and identify which fields needs to update
 * 3. Generate token 
 * 4. PUT: request with updated fields
 */
public class PutRequest5 {

	public static void main(String[] args) {
		non_Bdd_Style_PutRequest();
	}
	
	public static void non_Bdd_Style_PutRequest() {
		// There is no need to add escape character manually. Just paste string within
		// double
		// quotes. It will automatically add escape sequence as required.
		String jsonString = "{\r\n" + "    \"firstname\" : \"Deepak\",\r\n" + "    \"lastname\" : \"Rathod\",\r\n"
				+ "    \"totalprice\" : 111,\r\n" + "    \"depositpaid\" : true,\r\n" + "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n" + "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n" + "    \"additionalneeds\" : \"Breakfast\"\r\n" + "}";
 
		// Create a request specification
		RequestSpecification request = RestAssured.given();
 
		// Setting content type to specify format in which request payload will be sent.
		// ContentType is an ENUM.
		request.contentType(ContentType.JSON);
		// Setting a cookie for authentication as per API documentation
		request.cookie("token", PostRequest4.getToken());
		// Adding URI
		request.baseUri("https://restful-booker.herokuapp.com/booking/1");
		// Adding body as string
		request.body(jsonString);
 
		// Calling PUT method on URI. After hitting we get Response
		Response response = request.put();
 
		// Printing Response as string
		System.out.println(response.asString());
 
		// Get Validatable response to perform validation
		ValidatableResponse validatableResponse = response.then();
 
		// Validate status code as 200
		validatableResponse.statusCode(200);
 
		// Validate value of firstName is updated
		validatableResponse.body("firstname", Matchers.equalTo("Deepak"));
 
		// Validate value of lastName is updated
		validatableResponse.body("lastname", Matchers.equalTo("Rathod"));

	}
	
	public static void bdd_Style_PutRequest() {
		// There is no need to add escape character manually. Just paste string within
		// double
		// quotes. It will automatically add escape sequence as required.
		String jsonString = "{\r\n" + "    \"firstname\" : \"Deepak\",\r\n" + "    \"lastname\" : \"Rathod\",\r\n"
				+ "    \"totalprice\" : 111,\r\n" + "    \"depositpaid\" : true,\r\n" + "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n" + "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n" + "    \"additionalneeds\" : \"Breakfast\"\r\n" + "}";
 
		//GIVEN
		RestAssured
			.given()
					.baseUri("https://restful-booker.herokuapp.com/booking/1")
					.cookie("token", "e88375c0fde687a")
					.contentType(ContentType.JSON)
					.body(jsonString)
			// WHEN
			.when()
					.put()
			// THEN
			.then()
					.assertThat()
					.statusCode(200)
					.body("firstname", Matchers.equalTo("Deepak"))
					.body("lastname", Matchers.equalTo("Rathod"));
	}
}
