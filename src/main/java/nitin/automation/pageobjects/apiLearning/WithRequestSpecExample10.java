package nitin.automation.pageobjects.apiLearning;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class WithRequestSpecExample10 {
	//RequestSpecification requestSpecification;

	@BeforeClass
	public void setupRequestSpecification() {
		requestSpecification = RestAssured
				.given()
				.baseUri("https://restful-booker.herokuapp.com")
				.basePath("/booking");
	}

	@Test
	public void getAllBookings() {
		// Given
		//RestAssured.given(requestSpecification).when().get().then().statusLine("");//way-1
		//requestSpecification.get().then().statusCode(200); //way-2
		RestAssured.given().spec(requestSpecification)//way-3
				// When
				.when().get()
				// Then
				.then().statusLine("HTTP/1.1 200 OK");

	}

	@Test
	public void getBookingDetailsWithInvalidFirstName() {
		// Given
		RestAssured.given(requestSpecification).param("firstName", "Rahul")
				// When
				.when().get()
				// Then
				.then().statusLine("HTTP/1.1 200 OK");
	}
	
	private void multiple_ways_to_set_requestSpecification() {
		//Way-1
		requestSpecification = given()
				.accept(ContentType.JSON)
				.baseUri("http://www.demo.com")
				.basePath("/demo")
				.port(90);
		requestSpecification.get();
		
		//Way-2
		given(requestSpecification)
			.get();
		
		//way-3
		given().spec(requestSpecification).get();
		
		//way-4
		requestSpecification = given().with()
				.accept(ContentType.JSON)
				.baseUri("http://www.demo.com")
				.basePath("/demo")
				.port(90);
		requestSpecification.get();
	}
}
