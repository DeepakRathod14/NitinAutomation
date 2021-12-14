package nitin.automation.pageobjects.apiLearning.jackson;

import java.io.File;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class _15_PostPayload_As_File {

	//@Test
	public void payloadForJson() {
		// Creating a File instance
		File jsonDataInFile = new File("./src/main/resources/Payload/AuthPayload.json");
		// GIVEN
		RestAssured.given().baseUri("https://restful-booker.herokuapp.com/auth").contentType(ContentType.JSON)
				.body(jsonDataInFile)
				// WHEN
				.when().post()
				// THEN
				.then()
				.assertThat()
				.statusCode(200)
				.body("token", Matchers.notNullValue())
				.body("token.length()", Matchers.is(15))
				.body("token", Matchers.matchesRegex("^[a-z0-9]+$"));
	}

	@Test
	public void payloadForXml() {
		// Creating a File instance 
		File jsonDataInFile = new File("./src/main/resources/Payload/AuthPayload.xml");
		//GIVEN
		RestAssured
		    .given()
				.baseUri("https://restful-booker.herokuapp.com/auth")
				// Since I am passing payload as xml. Anyway it is optional as Rest Assured automatically identifies.
				.contentType(ContentType.XML)
				.body(jsonDataInFile)
		// WHEN
			.when()
				.post()
				// THEN
			.then()
				.assertThat()
				.statusCode(200);
	}
}
