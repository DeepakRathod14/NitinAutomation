package nitin.automation.pageobjects.apiLearning;

import static org.hamcrest.Matchers.*;

import org.hamcrest.Matchers;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public class GetRequest_2 {

	public static void main(String[] args) {
		non_Bdd_Style_GetRequest();
		//bdd_Style_GetRequest();
	}
	
	public static void non_Bdd_Style_GetRequest() {
		// Create a request specification 
		RequestSpecification request= RestAssured.given();
		
		//Adding URI
		request.baseUri("https://restful-booker.herokuapp.com");
		request.basePath("/booking");
		
		// Calling GET method on URI. After hitting we get Response
		Response response = request.get();//way-1
		//RestAssured.given(request).get();//way-2
		//RestAssured.given().spec(request).get();//Way-3
		
		// Let's print response body.
		String resString = response.asString();
		System.out.println("Respnse Details : " + resString);
 
		/*
		 * To perform validation on response like status code or value, we need to get
		 * ValidatableResponse type of response using then() method of Response
		 * interface. ValidatableResponse is also an interface.
		 */
		ValidatableResponse valRes = response.then();
		// It will check if status code is 200
		valRes.statusCode(200);
		// It will check if status line is as expected
		valRes.statusLine("HTTP/1.1 200 OK");
	}

	public static void bdd_Style_GetRequest() {
		// Given
		RestAssured.given()
			.baseUri("https://restful-booker.herokuapp.com")
		// When
		.when()
			.get("/booking")
		// Then
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.log().body();
			// To verify booking count
			//.body("bookingid.sum()", Matchers.hasSize(351));
			// To verify booking id at index 3
			//.body("bookingid[3]", Matchers.equalTo(1));	
	}
	
	public static void bdd_Style_GetRequest_StaticImport() {
		// Given
		given()
			.baseUri("https://restful-booker.herokuapp.com")
		// When
		.when()
			.get("/booking")
		// Then
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			// To verify booking count
			.body("bookingid", Matchers.hasSize(10))
			// To verify booking id at index 3
			.body("bookingid[3]", equalTo(1));			
	}
}
