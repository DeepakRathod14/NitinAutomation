package nitin.automation.pageobjects.apiLearning.jackson;

import java.util.Iterator;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.restassured.RestAssured;

/*
 * JsonNode
 * { ...... } --> Object Node
 * [ { .... } , {.... } ] --> ArrayNode
 */
/*
 * {
    "firstname" : "Jim",
    "lastname" : "Brown",
    "totalprice" : 111,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "2018-01-01",
        "checkout" : "2019-01-01"
    },
    "additionalneeds" : "Breakfast"
}
 * ObjectMapper is class of JEKSON lib. we added it into POM.xml
 * JEKSON: High performance Json processor lib. [ read/write/serialized/deserialized/etc support provide ]
 */
public class _17_ObjectMapperExample {

	private static ObjectMapper objectMapper;
	private static ObjectNode bookingDetails;

	public static void main(String[] args) throws JsonProcessingException {
		example1();
		//example2();
		//example3();
		//example4();
		example5();
		example6();
		example7();
	}

	// Consider json structured as example16.json
	public static void example1() throws JsonProcessingException {
		objectMapper = new ObjectMapper();
		
		// Creating Node that maps to JSON Object structures in JSON content
		bookingDetails = objectMapper.createObjectNode();
		// It is similar to map put method. put method is overloaded to accept different
		// types of data
		// String as field value
		bookingDetails.put("firstname", "Jim");
		bookingDetails.put("lastname", "Brown");
		// integer as field value
		bookingDetails.put("totalprice", 111);
		// boolean as field value
		bookingDetails.put("depositpaid", true);
		bookingDetails.put("additionalneeds", "Breakfast");
		// Duplicate field name. Will override value
		bookingDetails.put("additionalneeds", "Lunch");
		// To print created json object
		String createdPlainJsonObject = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(bookingDetails);
		System.out.println("Created plain JSON Object is : \n" + createdPlainJsonObject);

		System.out.println("----------------------------------------------------------");

		ObjectNode bookingDateDetails = objectMapper.createObjectNode();
		bookingDateDetails.put("checkin", "2021-07-01");
		bookingDateDetails.put("checkout", "2021-07-01");

		// Since 2.4 , put(String fieldName, JsonNode value) is deprecated. So use
		// either set(String fieldName, JsonNode value) or replace(String fieldName,
		// JsonNode value)
		bookingDetails.set("bookingdates", bookingDateDetails);

		// To get the created json object as string. Use
		// writerWithDefaultPrettyPrinter() for proper formatting
		String createdNestedJsonObject = objectMapper.writerWithDefaultPrettyPrinter()
				.writeValueAsString(bookingDetails);
		System.out.println("Created nested JSON Object is : \n" + createdNestedJsonObject);
	}

	// Example of: get(String fieldName);
	public static void example2() {
// We can retrieve field value by passing field name. Since it is string, use asText().
		String firstName = bookingDetails.get("firstname").asText("NotFound");
		System.out.println("First name is : " + firstName);

// We can use asText() as well but return type will be string
		boolean depositpaid = bookingDetails.get("depositpaid").asBoolean();
		System.out.println("deposit paid is : " + depositpaid);

// To retrieve value of nested ObjectNode
		String chk = bookingDetails.get("bookingdates").get("checkin").asText();
		System.out.println("Checkin date is : " + chk);
		 System.out.println("Path : "+bookingDetails.path("bookingdates").get("checkin").asText());
		 System.out.println("At : "+bookingDetails.at("/bookingdates/checkin").asText());
	}

	/*
	 * Example of fieldNames() --> return Iterator<String> Retrieve all field names
	 * from JSON Object or Object Node
	 */
	public static void example3() {
		
		System.out.println("Count of fields in ObjectNode : " + bookingDetails.size());
		Iterator<String> allFieldNames = bookingDetails.fieldNames();//Retrive Kyes only
		System.out.println("Fields (Keys) are : ");
		while (allFieldNames.hasNext()) {
			System.out.println(allFieldNames.next());
		}
	}

	/*
	 * Retrieve all field values from from JSON Object or ObjectNode To retrieve all
	 * field values from an ObjectNode, use elements()
	 */
	public static void example4() {
		Iterator<JsonNode> allFieldValues = bookingDetails.elements(); //will retrieves values only
		System.out.println("Fields values are : ");
		while (allFieldValues.hasNext()) {
			System.out.println(allFieldValues.next());
		}
	}
	
	/*
	 * Retrieve all key-value pair from JSON Object or ObjectNode
	 * fields() -> Iterator<Entry<String,JsonNode>>
	 */
	public static void example5() {
		Iterator<Entry<String, JsonNode>> allFieldsAndValues = bookingDetails.fields(); //key-value pair
		System.out.println("All fields and their values are : ");
		while(allFieldsAndValues.hasNext())
		{
			Entry<String, JsonNode> node = allFieldsAndValues.next();
			System.out.println("Key is : "+node.getKey()+" and its value is : "+node.getValue());
		}
	}
	
	/*
	 * Remove a field from JSON Object or ObjectNode
	 * remove(String fieldName) --> return value of the field, if not exist return null;
	 */
	public static void example6() throws JsonProcessingException {
		//remove a field
		String removedFieldValue = bookingDetails.remove("firstname").asText();
		System.out.println("Value of Removed field is " + removedFieldValue);
		String removedJsonObject = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(bookingDetails);
		System.out.println("After removing field , JSON Object is : \n"+ removedJsonObject);
	}
	
	/*
	 * Update a field from JSON Object or ObjectNode
	 * We need to use put() method to update a field value if fieldValue is not another ObjectNode.
	 * If fieldValue is an ObjectNode use set() or replace() method.
	 */
	public static void example7() throws JsonProcessingException {
		// To replace a field value, use put() method for non ObjectNode type and replace() or set() for ObjectNode
		bookingDetails.put("firstname", "Amod");
		bookingDetails.put("firstname", "Aaditya");
		String updatedJsonObject = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(bookingDetails);
		System.out.println("After updating field , JSON Object is : \n"+ updatedJsonObject);
	}
}
