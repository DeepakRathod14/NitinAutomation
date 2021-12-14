package nitin.automation.pageobjects.apiLearning.jackson;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class _18_ObjectMapper_JsonArray {
	private static ObjectMapper objectMapper;
	private static ArrayNode parentArray;
	
	public static void main(String[] args) throws IOException {
		example1();
		exampel2();
		example3();
	}
	
	public static void example1() throws JsonProcessingException {
		objectMapper = new ObjectMapper();
		
		// Create an array which will hold two JSON objects --> [ ]
		parentArray =  objectMapper.createArrayNode();

		System.out.println("----------------------------CREATING 1ST NODE ---------------------------------");
		// Creating Node that maps to JSON Object structures in JSON content --> { }
		ObjectNode firstBookingDetails = objectMapper.createObjectNode();
				
		// It is similar to map put method. put method is overloaded to accept different types of data
		// String as field value
		firstBookingDetails.put("firstname", "Jim");
		firstBookingDetails.put("lastname", "Brown");
		// integer as field value
		firstBookingDetails.put("totalprice", 111);
		// boolean as field value
		firstBookingDetails.put("depositpaid", true);
		firstBookingDetails.put("additionalneeds", "Breakfast");
				
		// Since requirement is to create a nested JSON Object
		ObjectNode firstBookingDateDetails = objectMapper.createObjectNode();
		firstBookingDateDetails.put("checkin", "2021-07-01");
		firstBookingDateDetails.put("checkout", "2021-07-01");
				
		// Since 2.4 , put(String fieldName, JsonNode value) is deprecated. So use either set(String fieldName, JsonNode value) or replace(String fieldName, JsonNode value)
		firstBookingDetails.set("bookingdates", firstBookingDateDetails);
		String jsonArrayAsString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(firstBookingDetails);
		System.out.println("Created 1st Json Node is : ");
		System.out.println(jsonArrayAsString);
		System.out.println("----------------------------CREATING 2ND NODE ---------------------------------");
		
		// Creating Node that maps to JSON Object structures in JSON content
		ObjectNode secondBookingDetails = objectMapper.createObjectNode();
		// It is similar to map put method. put method is overloaded to accept different types of data
		// String as field value
		secondBookingDetails.put("firstname", "Amod");
		secondBookingDetails.put("lastname", "Mahajan");
		// integer as field value
		secondBookingDetails.put("totalprice", 222);
		// boolean as field value
		secondBookingDetails.put("depositpaid", true);
		secondBookingDetails.put("additionalneeds", "Breakfast");
				
		// Since requirement is to create a nested JSON Object
		ObjectNode secondBookingDateDetails = objectMapper.createObjectNode();
		secondBookingDateDetails.put("checkin", "2022-07-01");
		secondBookingDateDetails.put("checkout", "2022-07-01");
				
		// Since 2.4 , put(String fieldName, JsonNode value) is deprecated. So use either set(String fieldName, JsonNode value) or replace(String fieldName, JsonNode value)
		secondBookingDetails.set("bookingdates", secondBookingDateDetails);
		jsonArrayAsString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(secondBookingDetails);
		System.out.println("Created 1st Json Node is : ");
		System.out.println(jsonArrayAsString);

		//[ { OBJ-1 }, {OBJ-2} ]
		System.out.println("-------------------------------- ADD BOTH NODE TO ARRAY ---------------------------------------");
		parentArray.add(firstBookingDetails);
		parentArray.add(secondBookingDetails);
		jsonArrayAsString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(parentArray);
		System.out.println("Created 1st Json Node is : ");
		System.out.println(jsonArrayAsString);
	}

	//Retrieving JSON Object from JSON array using index
	public static void exampel2() throws IOException {
		// To get json array element using index
		System.out.println("-----------------------------------------------------------------");
		JsonNode firstElement = parentArray.get(0);
		String s = parentArray.at("/0/firstname").asText();
		System.out.println(parentArray.get(0).get("firstname"));
		System.out.println(parentArray.path(1).get("firstname").asText());
		System.out.println("---> "+s);
		System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(firstElement));
	}
	
	//Remove a JSON Object from JSON Array
	public static void example3() throws JsonProcessingException {
		System.out.println("___________________REMOVE____________________");
		parentArray.remove(0);
		System.out.println("After removing first element from array : "+ objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(parentArray));

		parentArray.removeAll();
		System.out.println("After removing first element from array : "+ objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(parentArray));
	
	}
}
