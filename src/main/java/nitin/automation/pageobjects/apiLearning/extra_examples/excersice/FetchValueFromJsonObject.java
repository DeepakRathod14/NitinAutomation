package nitin.automation.pageobjects.apiLearning.extra_examples.excersice;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FetchValueFromJsonObject {

	/**
	 * get("key") -> return value and need to parse into correct format (if we parse into wrong format it will not throw error.
	 * Eg. get(key).asText() -> string
	 * Eg. get(key).asBoolean(), asLong(), etc will be parse data respectively and return it.
	 * get(KeyNotFound).asText("defaultVal); --> return NullPointerException if key not found
	 * 
	 * get(key).asBoolean(); but if String -> "true/false" as str, If (object) default it return false, if Num>0 = true, if num==0 false
	 * get(key).asLong(); if val=string -> Long.Parse(str), if not able to convert then default return 0
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */
	@Test
	public void parseJsonObjectToReadValues() throws JsonMappingException, JsonProcessingException
	{
		String jsonObject = "{\r\n" + 
				"  \"firstName\": \"Amod\",\r\n" + 
				"  \"lastName\": \"Mahajan\",\r\n" + 
				"  \"married\": false,\r\n" + 
				"  \"salary\": 2000.54,\r\n" + 
				"  \"addressPin\": 45324\r\n" + 
				"}";
		// Creating an instance of ObjectMapper class
		ObjectMapper objectMapper = new ObjectMapper();
		// Get tree representation of json
		JsonNode jsonTree = objectMapper.readTree(jsonObject);
		// Get value of firstName as string
		String firstName = jsonTree.get("firstName").asText();
		String lastName = jsonTree.get("lastName").asText();
		// Get value of married as boolean
		boolean married = jsonTree.get("married").asBoolean();
		double salary = jsonTree.get("salary").asDouble();
		long addressPin = jsonTree.get("addressPin").asLong();
		
		System.out.println("FirstName is : "+firstName);
		System.out.println("LastName is  : "+lastName);
		System.out.println("Married is   : "+married);
		System.out.println("Salary is    : "+salary);
		System.out.println("Addresspin is: "+addressPin);
		
		System.out.println("----------------Different expriments -------------------");
		System.out.println("asBoolean() : "+jsonTree.get("firstName").asBoolean());
		System.out.println("asBoolean(true) : "+jsonTree.get("firstName").asBoolean(true));
		System.out.println("asDouble() : "+jsonTree.get("firstName").asDouble());
		System.out.println("asInt() : "+jsonTree.get("firstName").asInt());
		System.out.println("asLong() : "+jsonTree.get("firstName").asLong());
		System.out.println("asToken() : "+jsonTree.get("firstName").asToken());
		System.out.println("findValuesAsText() : "+jsonTree.get("firstName").findValuesAsText("abc").size());
		
		System.out.println("====================== DIFFERENCE BETWEEN PATH & GET ========================");
		// Retrieving value of non-existing key using path
		String s1 = jsonTree.path("nonExistingNode").asText("Default value");
		System.out.println(s1);
		//Below code will throw NullPointerException
		//System.out.println("Exception will raise : "+jsonTree.get("WrongKeyName").asText());
		
		System.out.println("----------------- verify which dataType ----------------------");
		System.out.println(jsonTree.get("firstName").isTextual());
		System.out.println(jsonTree.get("lastName").isTextual());
		System.out.println(jsonTree.get("married").isBoolean());//false=0 
		System.out.println(jsonTree.get("salary").isDouble());
		System.out.println(jsonTree.get("addressPin").isLong());
		
	}
}
