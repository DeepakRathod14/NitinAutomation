package nitin.automation.pageobjects.apiLearning.buildPattern3;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RestAssuredExample {

	public static void main(String[] args) {
		
	}
	
	public static void noMethodChaining() {
		RequestSpecification req= RestAssured.given();
		req= req.accept(ContentType.JSON);
		req= req.auth().preemptive().basic("username", "password");
		req= req.header("headername", "headervalue");
		req= req.param("paramname", "paramvalue");
		req= req.cookie("cookieName", "value");
	
		RestAssured.given(req).get("some_url");
	}
	
	public static void methodChaninig() {
		RequestSpecification req= RestAssured.given()
		.accept(ContentType.JSON)
		.auth().preemptive().basic("username", "password")
		.header("headername", "headervalue")
		.param("paramname", "paramvalue")
		.cookie("cookieName", "value");
		
		RestAssured.given().spec(req).get("some_url");
	}
}
