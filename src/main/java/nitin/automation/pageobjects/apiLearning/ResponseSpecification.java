package nitin.automation.pageobjects.apiLearning;

import org.hamcrest.Matchers;
import org.openqa.selenium.Cookie;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ResponseSpecification {

	public static void main(String[] args) {
		
	}

	public static void responseSpecSetup() {
		//RestAssured.requestSpecification = RestAssured.given();
		//RestAssured.requestSpecification = RestAssured.with();
		
		//Create Request Specification
		RequestSpecBuilder request = new RequestSpecBuilder();
		request.setContentType(ContentType.JSON);
		request.addCookie("Tsting");
		request.addHeader("some", "value");
		RequestSpecification req = request.build();
		
		//Create Response Specification
		//io.restassured.specification.ResponseSpecification res1 = RestAssured.expect(); --> way-1 to create ResponseSpecification
		ResponseSpecBuilder respose = new ResponseSpecBuilder(); //Way-2
		respose.expectCookie("testing");
		respose.expectContentType(ContentType.JSON);
		respose.expectBody(Matchers.not("Testing"));
		
		io.restassured.specification.ResponseSpecification res =  respose.build();
		
		//Set Request Specification
		RestAssured.given(req);//1
		RestAssured.given().spec(req);//2
		
		//Set Response Specification
		RestAssured.given(req).post().then().spec(res);//1
		RestAssured.given(req, res).post().then();//2
	}

	public static void responseSpecBuilder() {
		RequestSpecification request = RestAssured.given();//.with();
		request.accept(ContentType.JSON);
		
		io.restassured.specification.ResponseSpecification respose = RestAssured.expect();
		respose.cookie("testing");
		respose.contentType(ContentType.JSON);
		respose.body(Matchers.not("Testing"));
		
		RestAssured.given().post().then().spec(respose);//3
		RestAssured.given(request, respose).get();//1
		RestAssured.given().spec(request).get().then().spec(respose);//2
		
	}
}
