package nitin.automation.pageobjects.apiLearning.extra_examples.excersice;

import java.util.Iterator;
import java.util.Map.Entry;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/*
 * [
  {
    "firstName": "Amod",
    "lastName": "Mahajan",
    "address": [
      {
        "0": "Permanent",
        "1": "Bengaluru",
        "2": "Karnataka"
      },
      {
        "0": "Communication",
        "1": "Katihar",
        "2": "Bihar"
      }
    ]
  },
  {
    "firstName": "Animesh",
    "lastName": "Prashant",
    "address": [
      {
        "0": "Permanent",
        "1": "Delhi",
        "2": "Delhi"
      },
      {
        "0": "Communication",
        "1": "Indore",
        "2": "MP"
      }
    ]
  }
]
 */

public class FetchValueFromJsonArray {

	
	@Test
	public void parseJsonArrayToReadValues() throws JsonMappingException, JsonProcessingException
	{
		String jsonArray = "[\r\n" + 
				"  {\r\n" + 
				"    \"firstName\": \"Amod\",\r\n" + 
				"    \"lastName\": \"Mahajan\",\r\n" + 
				"    \"address\": [\r\n" + 
				"      {\r\n" + 
				"        \"type\": \"Permanent\",\r\n" + 
				"        \"city\": \"Bengaluru\",\r\n" + 
				"        \"state\": \"Karnataka\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"type\": \"Communication\",\r\n" + 
				"        \"city\": \"Katihar\",\r\n" + 
				"        \"state\": \"Bihar\"\r\n" + 
				"      }\r\n" + 
				"    ]\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"firstName\": \"Animesh\",\r\n" + 
				"    \"lastName\": \"Prashant\",\r\n" + 
				"    \"address\": [\r\n" + 
				"      {\r\n" + 
				"        \"type\": \"Permanent\",\r\n" + 
				"        \"city\": \"Delhi\",\r\n" + 
				"        \"state\": \"Delhi\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"type\": \"Communication\",\r\n" + 
				"        \"city\": \"Indore\",\r\n" + 
				"        \"state\": \"MP\"\r\n" + 
				"      }\r\n" + 
				"    ]\r\n" + 
				"  }\r\n" + 
				"]";

		// Creating an instance of ObjectMapper class
		ObjectMapper objectMapper = new ObjectMapper();
		// Get tree representation of json
		JsonNode jsonTree = objectMapper.readTree(jsonArray);
		
		jsonTree.elements().forEachRemaining(index -> {
			//index.fieldNames().forEachRemaining(field -> System.out.println("Fields = "+field));
		});
		Iterator<Entry<String, JsonNode>> list = jsonTree.fields();
		list.forEachRemaining(entry -> {
			System.out.println("Key - "+entry.getKey());
			System.out.println("Val - "+entry.getValue().asText());
		});
		// Using get method
		System.out.println(jsonTree.get(0).get("firstName").asText());
		System.out.println(jsonTree.get(0).get("address").get(0).get("type").asText());
		
		// Using at() method
		// Printing details of first indexed node
		System.out.println(jsonTree.at("/0/firstName").asText());
		System.out.println(jsonTree.at("/0/address/0/type").asText());
		System.out.println(jsonTree.at("/0/address/1/type").asText());
		
		// Printing details of second indexed node
		System.out.println(jsonTree.at("/1/firstName").asText());
		System.out.println(jsonTree.at("/1/address/0/type").asText());
		System.out.println(jsonTree.at("/1/address/1/type").asText());
				
	}
	

	/**
	 * [
  [
    {
      "firstName": "Amod",
      "lastName": "Mahajan",
      "age": 28,
      "isMarried": false,
      "salary": 23456.54
    },
    {
      "firstName": "Rahul",
      "lastName": "Arora",
      "age": 32,
      "isMarried": true,
      "salary": 33456.54
    }
  ],
  [
    {
      "firstName": "Amod",
      "lastName": "Mahajan",
      "age": 28,
      "isMarried": false,
      "salary": 23456.54
    },
    {
      "firstName": "Rahul",
      "lastName": "Arora",
      "age": 32,
      "isMarried": true,
      "salary": 33456.54
    }
  ]
]
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */
	public void example2() throws JsonMappingException, JsonProcessingException {
		String jsonArray = "[\r\n" + 
				"  {\r\n" + 
				"    \"firstName\": \"Amod\",\r\n" + 
				"    \"lastName\": \"Mahajan\",\r\n" + 
				"    \"age\": 28,\r\n" + 
				"    \"isMarried\": false,\r\n" + 
				"    \"salary\": 23456.54\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"firstName\": \"Rahul\",\r\n" + 
				"    \"lastName\": \"Arora\",\r\n" + 
				"    \"age\": 32,\r\n" + 
				"    \"isMarried\": true,\r\n" + 
				"    \"salary\": 33456.54\r\n" + 
				"  }\r\n" + 
				"]";
		
		// Creating an instance of ObjectMapper class
		ObjectMapper objectMapper = new ObjectMapper();
		// Get tree representation of json
		JsonNode jsonTree = objectMapper.readTree(jsonArray);
		
		// To know if tree is a JSON object or JSON array
		//JsonNode is parent of ObjectNode = ( {...} ) and ArrayNode = ( [ {...},{...} ] )
		System.out.println("Is parsed JSOn tree a JSON Object?"+ Boolean.toString(jsonTree instanceof ObjectNode));
		System.out.println("Is parsed JSOn tree a JSON Array?"+ Boolean.toString(jsonTree instanceof ArrayNode));
	
		// Get first json object and storing 
		JsonNode firstJsonObject = jsonTree.get(0);
		// Get second json object and storing 
		JsonNode secondJsonObject = jsonTree.get(1);
		
		// Get value of firstName as string
		String firstName = firstJsonObject.get("firstName").asText();
		String lastName = firstJsonObject.get("lastName").asText();
		// Get value of married as boolean
		int age = firstJsonObject.get("age").asInt();
		boolean married = firstJsonObject.get("isMarried").asBoolean();
		double salary = firstJsonObject.get("salary").asLong();
		
		System.out.println("FirstName is : "+firstName);
		System.out.println("LastName is  : "+lastName);
		System.out.println("Age is   : "+age);
		System.out.println("Maritial status is    : "+married);
		System.out.println("Salary is: "+salary);
		
		
		// Get value of firstName as string
		firstName = secondJsonObject.get("firstName").asText();
		lastName = secondJsonObject.get("lastName").asText();
		// Get value of married as boolean
		age = secondJsonObject.get("age").asInt();
		married = secondJsonObject.get("isMarried").asBoolean();
		salary = secondJsonObject.get("salary").asLong();
		
		System.out.println("FirstName is : "+firstName);
		System.out.println("LastName is  : "+lastName);
		System.out.println("Age is   : "+age);
		System.out.println("Maritial status is    : "+married);
		System.out.println("Salary is: "+salary);

	}
}
