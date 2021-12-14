package nitin.automation.pageobjects.api;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.velocity.exception.MathException;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;


// https://reqres.in/
public class RestAPIPractise {

	@BeforeTest
	public void config() {
		requestSpecification = new RequestSpecBuilder()
				.setAccept(ContentType.JSON)
				.setBasePath("/api")
				.setBaseUri("https://reqres.in")
				.build();
	}
	
	@Test
	public static void getAPI() {
		given(requestSpecification)
			.get("/users?page=2")
			.then()
			.statusCode(200)
			.rootPath("data")
			.body("id", Matchers.contains(1,2,3));
			//.body("support.url", Matchers.equalTo("https://reqres.in/#support-heading"))
			//.body("data.avatar", Matchers.startsWith("https://reqres.in"));
	}
	
	//@Test
	public static void postAPI() {
		Response response = given().spec(requestSpecification)
			.body("{\r\n" + 
					"    \"name\": \"morpheus\",\r\n" + 
					"    \"job\": \"leader\",\r\n" + 
					"    \"id\": \"35\",\r\n" + 
					"    \"createdAt\": \"2021-11-24T03:20:43.759Z\"\r\n" + 
					"}")
			.post("/users")
			.andReturn();
			
		System.out.println(response.asPrettyString());
		response.then()
			.statusCode(201)
			.contentType(ContentType.JSON)
			.time(Matchers.lessThan(4000l));
	}
	
	//@Test
	public static void PutAPI() {
//		List<Header> listH = new ArrayList<Header>();
//		Header h1 = new Header("header1", "HeaderValue1");
//		Header h2 = new Header("header2", "HeaderValue2");
//		
//		listH.add(h1);
//		listH.add(h2);
//		
//		Headers h = new Headers(h1,h2);
//		Headers hh1 = new Headers(listH);
		
		Response response = given()
			//.header(h1).and().header(h2)//way-1
			//.header("h11", "hv11", "h22","hv22","h33","hv33")//way-2
			//.headers(h)//way-3
			//.headers(hh1)//way-4
			.spec(requestSpecification)
			.body("{\r\n" + 
					"    \"name\": \"morpheus\",\r\n" + 
					"    \"job\": \"zion resident\",\r\n" + 
					"    \"updatedAt\": \"2021-11-24T03:34:09.435Z\"\r\n" + 
					"}")
			
			.pathParam("userIndex", 2)
			.put("/users/{userIndex}")
			.andReturn();
	
		System.out.println(response.asPrettyString());
		response.then()
			.time(Matchers.lessThan(6000l))
			.statusCode(200);
	}

	public static void PatchAPI() {
		
	}

	@Test
	public static void DeleteAPI() {
		Response response = given()
			.spec(requestSpecification)
			.pathParam("userIndex", 2)
			.delete("/users/{userIndex}")
			.andReturn();
		
		System.out.println(response.asPrettyString());
		response.then()
			.statusCode(204);
	}

}
