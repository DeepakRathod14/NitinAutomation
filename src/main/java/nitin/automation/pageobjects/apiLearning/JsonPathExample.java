package nitin.automation.pageobjects.apiLearning;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import io.restassured.path.json.JsonPath;

public class JsonPathExample {
	public static void main(String[] args) {
		//example1();
		example2();
	}
	
	public static void example1() {
		String jsonString = "{\r\n" + 
				"  \"firstName\": \"Amod\",\r\n" + 
				"  \"lastName\": \"Mahajan\"\r\n" + 
				"}";
		
		//Get JsonPath instance of above JSON string
		JsonPath jsonPath = JsonPath.from(jsonString);
		LinkedHashMap<String,String> root = jsonPath.get("");
		LinkedHashMap<String,String>  root1 = jsonPath.get("$");
		
		System.out.println(root);
		System.out.println(root1);
		
		String str = jsonPath.getString("firstName");
		System.out.println(str);
	}
	
	public static void example2() {
		String jsonString = "{\r\n" + 
				"  \"firstName\": \"Amod\",\r\n" + 
				"  \"lastName\": \"Mahajan\",\r\n" + 
				"  \"address\": {\r\n" + 
				"    \"houseNo\": 404,\r\n" + 
				"    \"buildingName\": \"Not Found\",\r\n" + 
				"    \"streetName\": \"Gumnam gali\",\r\n" + 
				"    \"city\": \"Bengaluru\",\r\n" + 
				"    \"state\": \"Karnataka\",\r\n" + 
				"    \"country\": \"India\"\r\n" + 
				"  },\r\n" + 
				"  \"skills\": {\r\n" + 
				"    \"language\": {\r\n" + 
				"      \"name\": \"Java\",\r\n" + 
				"      \"proficiency\": \"Medium\"\r\n" + 
				"    }\r\n" + 
				"  }\r\n" + 
				"}";
		
		String jsonArrayString = "{\r\n" + 
				"  \"firstName\": \"Amod\",\r\n" + 
				"  \"lastName\": \"Mahajan\",\r\n" + 
				"  \"address\": [\r\n" + 
				"    {\r\n" + 
				"      \"type\": \"permanent\",\r\n" + 
				"      \"city\": \"Bengaluru\",\r\n" + 
				"      \"state\": \"KA\"\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"type\": \"temp\",\r\n" + 
				"      \"city\": \"Bhopal\",\r\n" + 
				"      \"state\": \"MP\"\r\n" + 
				"    }\r\n" + 
				"  ]\r\n" + 
				"}";
		
		//Get JsonPath instance of above JSON string
		JsonPath path = JsonPath.from(jsonString);
		int num = path.getInt("address.houseNo");
		System.out.println(num);
		System.out.println("country : "+path.getString("address.country"));
		System.out.println("Skill.langiage : "+path.getString("skills.language.name"));
		
		path = JsonPath.from(jsonArrayString);
		// Since address holds a JSON array we can get particular indexed element using index
		String addressType1 = path.getString("address[0].type");
		System.out.println("Address type is : "+addressType1);
		
		String addressType2 = path.getString("address[1].type");
		System.out.println("Another address type is : "+addressType2);
		
		// We can get address types as a list as well
		List<String> allAddressTypes = path.getList("address.type");
		System.out.println(allAddressTypes);
		
		// We can get complete address array as List
		// Since it holds Json objects which can be a Map
		List<Map<String,Object>> allAddress = path.getList("address");
		for(Map<String,Object> address : allAddress)
		{
			System.out.println(address);
		}
	}
}	
