package nitin.automation.pageobjects.api;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


/*
 * https://reqres.in/
 * https://gorest.co.in/
 * https://apipheny.io/free-api/
 * 
 * https://www.baeldung.com/rest-assured-authentication
 */
public class RestAPI {
	
	@BeforeTest
	public void config() {
		baseURI="https://reqres.in";
		basePath="/api";
		
	}
	
	@Test
	public void getListUsersConfig() {
		given()
		.get("/users?page=2")
		.body()
		.prettyPrint();
	}
	
	@Test
	public void example2() {
		given()
		.get("/users/2")
		.getHeaders().forEach(header -> System.out.println(header));
	}
	
	//@Test
	public void getListUsers(String streamID, String label) {
		given()
			.get("https://reqres.in/api/users?page=2")
			.body()
			.prettyPrint();
		
		given()
		.get("https://reqres.in/api/users?page=2")
		.getHeaders()
		.asList()
		.forEach(header -> System.out.println(header.getName() +" = "+header.getValue()));
		
		int code = given()
		.get("https://reqres.in/api/users?page=2")
		.getStatusCode();
		System.out.println("It should be : 200 == "+code);
		
		String sLine = given()
		.get("https://reqres.in/api/users?page=2")
		.getStatusLine();
		System.out.println("Status line : "+sLine);
	}

	//@Test
	public void verifyGetListUsers() {
//		Object[] exp = {7,8,9};
//		List<Integer> al = new ArrayList<>();
//		al.add(7);
//		al.add(8);
//		al.add(9);
//		given()
//			.get("https://reqres.in/api/users?page=2")
//			.then()
//			.body("data.id", hasItem(al));
		
		given()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.header("report-to", containsString("endpoints"));
		

		given()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200);
		
//		String sLine = given()
//		.get("https://reqres.in/api/users?page=2")
//		.getStatusLine();
//		System.out.println("Status line : "+sLine);
	}
	
	
	public static void variables() {
		System.out.println("Defautl Auth : "+DEFAULT_AUTH.toString());
		System.out.println("DEFAULT_BODY_ROOT_PATH : "+DEFAULT_BODY_ROOT_PATH);
		System.out.println("DEFAULT_PATH : "+DEFAULT_PATH);
		System.out.println("DEFAULT_PORT : "+DEFAULT_PORT);
		System.out.println("DEFAULT_SESSION_ID_VALUE : "+DEFAULT_SESSION_ID_VALUE);
		System.out.println("DEFAULT_URI : "+DEFAULT_URI);
		System.out.println("DEFAULT_URL_ENCODING_ENABLED : "+DEFAULT_URL_ENCODING_ENABLED);
		
		baseURI="https://www.google.com";
		port=6969;
		basePath="/map";
		sessionId="DeepakIRathod";
		urlEncodingEnabled=false;
		defaultParser = defaultParser.JSON;
		
		System.out.println(defaultParser.name());
		System.out.println("Defautl Auth : "+DEFAULT_AUTH.toString());
		System.out.println("DEFAULT_BODY_ROOT_PATH : "+DEFAULT_BODY_ROOT_PATH);
		System.out.println("DEFAULT_PATH : "+basePath);
		System.out.println("DEFAULT_PORT : "+port);
		System.out.println("DEFAULT_SESSION_ID_VALUE : "+sessionId);
		System.out.println("DEFAULT_URI : "+baseURI);
		System.out.println("DEFAULT_URL_ENCODING_ENABLED : "+DEFAULT_URL_ENCODING_ENABLED);
	}
}
