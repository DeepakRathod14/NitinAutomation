package nitin.automation.pageobjects.apiLearning;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.path.json.JsonPath;
import nitin.automation.beans.Employee;

public class JsonPathExample2 {

	@Test
	public void example1() {
		File jsonArrayFile = new File("src\\main\\resources\\Payload\\JsonPathExample60.json");
		System.out.println(jsonArrayFile.getAbsolutePath());
		JsonPath jsonPath = JsonPath.from(jsonArrayFile);
		
		/*
		 * To get a specific field value of an indexed element [0] will give you first
		 * element in an array and using dot operator we are retrieving value of
		 * firstName
		 */
		System.out.println("First name is first employee :"+ jsonPath.getString("[0].first_name"));
		
		// To get whole indexed element
		System.out.println("All details of first employee : " +jsonPath.getJsonObject("[0]"));
		
		/*
		 * To get first names of all employees Since it is a JSON array and we are not
		 * specifying index then it will pick firstName from each element and return as
		 * a list.
		 */
		System.out.println("First name of all employees" + jsonPath.getList("first_name"));
		
		/* To get all first name of all females only 
		 * If we want to filter records based on conditions we can use find or findAll expression.
		 * findAll will iterate through each element in array and match condition. "it" represent current element.
		 * For each element it will check if gender is "female". If yes then take firstName of current element. 
		 * findAl returns a List. */
		//System.out.println("First name of all female employees : "+jsonPath.param("nitin", "[*]").getList("findAll{nitin.gender == 'Female'}.first_name"));
		System.out.println("First name of all female employees : "+jsonPath.getList("findAll{nitin -> nitin.gender == 'Female'}.first_name"));
		
		/* To get first female name 
		 * If we want to get firstName of first female employee we can use find expression.*/
		System.out.println("First name of first female employee : "+jsonPath.getString("find{nitin -> nitin.gender == 'Female'}.first_name"));
		
		/*
		 * We can also use relational operator like first name of all employees whose id is 5 or more
		 */
		System.out.println("First name of all employees whose id is 5 or more : " + jsonPath.getList("findAll{nitin -> nitin.id >= 5}.first_name"));
		
		// we can use use and (&) operator - logical
		System.out.println("First name of all employees whose id is 5 or more but less than 8 : " + jsonPath.getList("findAll{nitin -> nitin.id >= 5 & nitin.id < 8}.first_name"));
		
		// We can also use or (|) operator
		System.out.println("First name of all employees whose id is greater than 9 or gender is female : " + jsonPath.getList("findAll{nitin -> nitin.id >= 9 | nitin.gender == 'Female'}.first_name"));
		
		// We can get size of array using size() or size
		System.out.println("Total number of employees : " + jsonPath.getString("size()"));
		
	}
	
	@Test
	public void example2() {
		String jsonObject = "[{\r\n" + 
				"  \"id\": 1,\r\n" + 
				"  \"first_name\": \"Lothaire\",\r\n" + 
				"  \"last_name\": \"Benazet\",\r\n" + 
				"  \"email\": \"lbenazet0@tinyurl.com\",\r\n" + 
				"  \"gender\": \"Male\"\r\n" + 
				"}, {\r\n" + 
				"  \"id\": 2,\r\n" + 
				"  \"first_name\": \"Shellie\",\r\n" + 
				"  \"last_name\": \"Cowser\",\r\n" + 
				"  \"email\": \"scowser1@163.com\",\r\n" + 
				"  \"gender\": \"Female\"\r\n" + 
				"}]";
		JsonPath path = JsonPath.from(jsonObject);
		path.getObject("[0]", Employee.class);
		
		List<Employee> list = new ArrayList<>();
		path.getObject("$", (TypeRef<List<Employee>>) list);
	}
}
