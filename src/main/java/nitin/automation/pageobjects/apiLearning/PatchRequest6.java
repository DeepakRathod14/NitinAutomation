package nitin.automation.pageobjects.apiLearning;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

/**
1. We need to pass booking id for which you want to update details in URI. E.g. https://restful-booker.herokuapp.com/booking/1 where "1" is booking id.
2. Authentication token need to pass as cookie. Cookie name is "token" and value is generated auth token. 'Cookie: token=<generatedToken>'.
3. Pass the fields which you want to update in body with new value. Remember it is a PATCH request where you no need to pass whole body. 
 * @param args
 */
public class PatchRequest6 {
	
	public static void main(String[] args) {
		no_Bdd_Style_PatchRequest();
	}
	
	public static void no_Bdd_Style_PatchRequest() {
		 
		// There is no need to add escape character manually. Just paste string within
		// double
		// quotes. It will automatically add escape sequence as required.
		String jsonString = "{\r\n" + 
				"    \"firstname\" : \"Amod\",\r\n" + 
				"    \"lastname\" : \"Mahajan\"}";
 
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
 
		// Calling PATCH method on URI. After hitting we get Response
		Response response = request.patch();
 
		// Printing Response as string
		System.out.println(response.asString());
 
		// Get Validatable response to perform validation
		ValidatableResponse validatableResponse = response.then();
 
		// Validate status code as 200
		validatableResponse.statusCode(200);
 
		// Validate value of firstName is updated
		validatableResponse.body("firstname", Matchers.equalTo("Amod"));
 
		// Validate value of lastName is updated
		validatableResponse.body("lastname", Matchers.equalTo("Mahajan"));
	}
	
	public static void bdd_Style_Patch_Request() {
		// There is no need to add escape character manually. Just paste string within
		// double
		// quotes. It will automatically add escape sequence as required.
		String jsonString = "{\r\n" + 
				"    \"firstname\" : \"Amod\",\r\n" + 
				"    \"lastname\" : \"Mahajan\"}";
		//GIVEN
		RestAssured
			.given()
					.baseUri("https://restful-booker.herokuapp.com/booking/1")
					.cookie("token", "6608dc75eedd44f")
					.contentType(ContentType.JSON)
					.body(jsonString)
			// WHEN
			.when()
					.patch()
			// THEN
			.then()
					.assertThat()
					.statusCode(200)
					.body("firstname", Matchers.equalTo("Deepak"))
					.body("lastname", Matchers.equalTo("Rathod"));
 
	}
}
