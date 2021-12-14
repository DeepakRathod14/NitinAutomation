package nitin.automation.pageobjects.apiLearning;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import nitin.automation.beans.Authentication;

public class PostRequest4 {
	public static void main(String[] args) {
		//non_BDD_Style_Post_Request();
		serializedExample();
	}

	public static String non_BDD_Style_Post_Request() {

		String token = "";
		// There is no need to add escape character manually. Just paste string within
		// double
		// quotes. It will automatically add escape sequence as required.
		String jsonString = "{\"username\" : \"admin\",\"password\" : \"password123\"}";

		// Create a request specification
		RequestSpecification request = RestAssured.given();

		// Setting content type to specify format in which request payload will be sent.
		// ContentType is an ENUM.
		request.contentType(ContentType.JSON);
		// Adding URI
		request.baseUri("https://restful-booker.herokuapp.com");
		request.basePath("/auth");
		// Adding body as string
		request.body(jsonString);

		// Calling POST method on URI. After hitting we get Response
		Response response = request.post();

		// Printing Response as string
		token = response.body().asString();
		System.out.println(token);

		// Get Validatable response to perform validation
		ValidatableResponse validatableResponse = response.then();

		// Validate status code as 200
		validatableResponse.statusCode(200);

		// Validate token field is null
		// SInce response is one to one mapping so passing key name will give you value.
		// Below method validates that value of token is not null.
		validatableResponse.body("token", Matchers.notNullValue());

		// Validate token length is 15
		validatableResponse.body("token.length()", Matchers.is(15));

		// Validate token is an alphanumeric value
		validatableResponse.body("token", Matchers.matchesRegex("^[a-z0-9]+$"));

		return token;
	}

	public static void bdd_Style_Post_Request() {
		// There is no need to add escape character manually. Just paste string within
		// double
		// quotes. It will automatically add escape sequence as required.
		String jsonString = "{\"username\" : \"admin\",\"password\" : \"password123\"}";
		
		// GIVEN
		RestAssured
			.given()
				.baseUri("https://restful-booker.herokuapp.com/auth")
				.contentType(ContentType.JSON)
				.body(jsonString)
			
			// WHEN
			.when()
				.post()			
				
			// THEN
			.then()
				.assertThat()
				.statusCode(200)
				.body("token", Matchers.notNullValue())
				.body("token.length()", Matchers.is(15))
				.body("token", Matchers.matchesRegex("^[a-z0-9]+$"));
	}

	public static String getToken() {
		String token = non_BDD_Style_Post_Request();
		token = token.replace("{", "");
		token = token.replace("}", "");
		String[] tokenArray = token.split(":");
		return tokenArray[1].replace("\"", "");
	}
	
	public static void serializedExample() {
		Authentication a = Authentication.newBuilder();//new Authentication();
		a.setUsername("admin");
		a.setPassword("password123");
		
		Authentication a1 = Authentication.newBuilder()
				.setPassword("xyz")
				.setUsername("abc");
		
		Authentication a2 = Authentication.newBuilder().build();
		ObjectMapper objectMapper = new ObjectMapper();
		System.out.println();
//--------------------------------------------------------------------------------		
		JSONObject obj = new JSONObject(); //Simple Json Object [NotRecommended]
		obj.put("username", "admin");
		obj.put("password", "password123");
		System.out.println(obj.toJSONString());
//		RestAssured
//		.given()
//			.baseUri("https://restful-booker.herokuapp.com/auth")
//			.contentType(ContentType.JSON)
//			.body(obj.toJSONString())
//		
//		// WHEN
//		.when()
//			.post().andReturn().then().log().all();	
	}
}
