package nitin.automation.pageobjects.api;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

public class GET_API_Class {

	@BeforeTest
	public void configuration() {
		baseURI = "https://reqres.in";
		basePath = "/api";
		responseSpecification = new ResponseSpecBuilder()
				.expectStatusCode(200)
			     .expectStatusLine("HTTP/1.1 200 OK")
				.expectContentType(ContentType.JSON)
				.expectResponseTime(Matchers.lessThan(5000L))	
				.build();
		requestSpecification = given();
	}

	
	@Test
	public void example1_pathParam() {
		requestSpecification
			.when()
				.get("/users/{page}", 2)
			.then()
				.spec(responseSpecification);
	}
	
	@Test
	public void example1_queryParam() {
		requestSpecification.queryParam("page", "2");
		given(requestSpecification,responseSpecification)
				.get("/users");
	}
	
	
}
