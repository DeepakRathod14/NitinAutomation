package nitin.automation.pageobjects.apiLearning.extra_examples.excersice;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
{
  "firstName": "Amod",
  "lastName": "Mahajan",
  "married": false,
  "salary": 2000.54,
  "addressPin": 45324,
  "skill" :{
    "Java" :"Intermediate",
    "Selenium" :"Intermediate",
    "Javascript" :"Beginner"
  }
}
 * @author Deepak.Rathod
 *
 */
public class FetchValueFromNestedJsonObject {
	@Test
	public void parseJsonObjectToReadValues() throws JsonMappingException, JsonProcessingException
	{
		String jsonObject = "{\r\n" + 
				"  \"firstName\": \"Amod\",\r\n" + 
				"  \"lastName\": \"Mahajan\",\r\n" + 
				"  \"married\": false,\r\n" + 
				"  \"salary\": 2000.54,\r\n" + 
				"  \"addressPin\": 45324,\r\n" + 
				"  \"skills\" :{\r\n" + 
				"    \"Java\" :\"Intermediate\",\r\n" + 
				"    \"Selenium\" :\"Intermediate\",\r\n" + 
				"    \"Javascript\" :\"Beginner\"\r\n" + 
				"  }\r\n" + 
				"}";
		// Creating an instance of ObjectMapper class
		ObjectMapper objectMapper = new ObjectMapper();
		// Get tree representation of json
		JsonNode jsonTree = objectMapper.readTree(jsonObject);
		
		// Using chaining of get() methods
		String javaLevel = jsonTree.get("skills").get("Java").asText();
		System.out.println(javaLevel);
		
		// Using chaining of path() methods
		String javaLevel2 = jsonTree.path("skills").path("Java").asText();
		System.out.println(javaLevel2);
		
		// Using pattern expression with at()
		//at() : never return null if path not found, instead it return isMissingNode() -> true
		String javaLevel3 = jsonTree.at("/skills/Java").asText();
		System.out.println(javaLevel3);
		
	}
}
