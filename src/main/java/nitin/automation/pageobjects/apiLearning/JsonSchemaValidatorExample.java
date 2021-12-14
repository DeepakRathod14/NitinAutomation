package nitin.automation.pageobjects.apiLearning;

import java.io.File;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

public class JsonSchemaValidatorExample {

	public static void main(String[] args) {
		schemaValidator();
	}

	public static void schemaValidator() {
		File f = new File("src/main/resources/Payload/JsonSchemaValidator.json");
		System.out.println(f.getAbsolutePath());
		JsonSchemaValidator.matchesJsonSchema(f);
		String jsonStringPayload = "{\"username\" : \"admin\",\"password\" : \"password123\"}";

		// GIVEN
		RestAssured.given().baseUri("https://restful-booker.herokuapp.com/auth").contentType(ContentType.JSON)
				.body(jsonStringPayload)
				// WHEN
				.when().log().all().post()
				// THEN
				.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(f));
	}

	public static void example2() {
		// http://makeseleniumeasy.com/2020/10/30/rest-assured-tutorial-56-json-schema-validation-without-rest-assured/
	}
}
