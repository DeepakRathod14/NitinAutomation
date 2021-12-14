package nitin.automation.pageobjects.apiLearning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
public class ParametersExample {

	/**
	 * select * from users where page=2
	 */
	public void queryParam() {
		RestAssured
		.given()
		.log().body()
		.get("https://reqres.in/api/users?page=2&page=3");
		
		//Way-1
		RestAssured
			.given()
			.queryParam("page", 2)
			.queryParam("page", 3)
			.get("https://reqres.in/api/users");
		
		//Way-2
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("page", 2);
		RestAssured
		.given()
		.queryParams(map)
		.get("https://reqres.in/api/users");

		//way-3
//		List<Integer> l = new ArrayList<>();
//		l.add(1);
//		l.add(2);
//		l.add(3);
		
		List<Integer> list = Collections.emptyList();
		Collections.addAll(list, 1,2,3);
		
		RestAssured
		.given()
		.queryParam("page", list)
		.get("https://reqres.in/api/users");
		
		//Way-4
		RestAssured
		.given()
		.queryParams("page", 1, "page",2);
	}
	
	@Test
	public void pathParam() {
		RestAssured
			.given()
			.log().body()
			.get("https://reqres.in/api/users/2");
		
		//Way-1
		RestAssured
			.given()
			.pathParam("nitin", 3)
			.pathParam("abc", 3)
			.log().all()
			.get("https://reqres.in/api/users/{nitin}");
		
		//Way-2
		Map<String, Integer> path = new HashMap<>();
		path.put("nitin", 3);
		
		RestAssured.given().pathParams(path).get("https://reqres.in/api/users/{nitin}");
		
		//way-3
		RestAssured.given().pathParams("nitin",3,"abc",4,"xyz",10).get("https://reqres.in/api/users/{nitin}");
		
		//Way-4
		//RestAssured.get("https://reqres.in/api/users/{nitin}", path);
		//RestAssured.get("https://reqres.in/api/users/{nitin}/{nitin2}", 3,4);

	}
	
	
	
}
