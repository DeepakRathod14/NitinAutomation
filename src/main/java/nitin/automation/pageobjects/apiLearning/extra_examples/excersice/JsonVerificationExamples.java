package nitin.automation.pageobjects.apiLearning.extra_examples.excersice;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.internal.mapping.Jackson1Mapper;
import io.restassured.mapper.ObjectMapperType;
import nitin.automation.beans.BookingBean;
import nitin.automation.beans.BookingInfo;

public class JsonVerificationExamples {

	private static final String PAYLOAD = "{\r\n" + 
			"    \"firstname\" : \"Jim\",\r\n" + 
			"    \"lastname\" : \"Brown\",\r\n" + 
			"    \"totalprice\" : 111,\r\n" + 
			"    \"depositpaid\" : true,\r\n" + 
			"    \"bookingdates\" : {\r\n" + 
			"        \"checkin\" : \"2018-01-01\",\r\n" + 
			"        \"checkout\" : \"2019-01-01\"\r\n" + 
			"    },\r\n" + 
			"    \"additionalneeds\" : \"Breakfast\"\r\n" + 
			"}";
	
	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		//convertToMap(); // { name:abc, id:12, add:ijejk } --> [{ name:abc, id:12, add:ijejk }, { name:abc, id:12, add:ijejk }]
		convertToListMap(); //List[0] -> Map<String,Object>
		//convertToMapClass();
		//convertToListOfMapClass();
		//convertToListOfClass(); //List<Class> -> List[0] -> class object
		//convertToClass(); //{ name:abc, id:12, add:ijejk } -> class { private name, id, add + getter/setter}
		//convertToJsonObject();
	}

	private static void convertToMap() {
		Map<String, Object> responseBody = null;
		responseBody = RestAssured.given().baseUri("https://restful-booker.herokuapp.com/").basePath("booking")
				.contentType(ContentType.JSON).body(PAYLOAD).when().post().then().extract().body()
				// Extract response as Map<String,Object>
				.as(new TypeRef<Map<String, Object>>() {});

		// To print booking id
		System.out.println("Booking id is : " + responseBody.get("bookingid"));

		// If we do not use below annotation then also no problem. As we are directly
		// casting without checking
		// so I have used it to surpass warning.
		@SuppressWarnings("unchecked")
		// Since "booking" key holds another JSON Object to parsing it again as Map.
		Map<String, Object> bookingDetails = (Map<String, Object>) responseBody.get("booking");
		System.out.println("First name is " + bookingDetails.get("firstname"));
	}
	
	private static void convertToListMap() {
		List<Map<String, Object>> responseBody = null;
		responseBody = RestAssured.given().baseUri("https://restful-booker.herokuapp.com/").basePath("booking")
				.when().get().then().extract().body()
				.as(new TypeRef<List<Map<String,Object>>>() {});
		
		responseBody.forEach(map -> {
			System.out.println("Map : "+map);
		});
	}
	
	private static void convertToMapClass() {
		 @SuppressWarnings("unchecked")
		Map<String,Object> response = RestAssured.given().baseUri("https://restful-booker.herokuapp.com/").basePath("booking")
			.contentType(ContentType.JSON).body(PAYLOAD).when().post().then().extract().body()
			.as(Map.class);
		
		 response.forEach((k,v) -> {
			 System.out.print("Key = "+k+"\t");
			 System.out.print("  val = "+v);
			 System.out.println("");
		 });
	}
	
	private static void convertToListOfMapClass() {
		@SuppressWarnings("unchecked")
		List<Object> list = RestAssured.given().baseUri("https://restful-booker.herokuapp.com/").basePath("booking")
				.when().get().then().extract().body()
				.as(List.class);
		list.forEach( val -> {
			if(val instanceof Map) {
				System.out.println("Object belongs to Map : "+val);
				Map<String,Object> map = (Map<String, Object>) val;
				System.out.println("-------------------------------");
				map.forEach((k,v) -> System.out.println("Key = "+k+" -- val = "+v));
			}
		});
	}
	
	private static void convertToListOfClass() {
		List<BookingBean> bookings = RestAssured.given().baseUri("https://restful-booker.herokuapp.com/").basePath("booking")
		.when().get().then().extract().body()
		.as(new TypeRef<List<BookingBean>>() {});
		
		bookings.forEach(book -> {
			System.out.println("BookingID : "+book.getBookingid());
		});
	}
	
	private static void convertToClass() {
		BookingInfo booking = RestAssured.given().baseUri("https://restful-booker.herokuapp.com/").basePath("booking")
		.contentType(ContentType.JSON).body(PAYLOAD).when().post().then().extract().body()
		// Extract response as Map<String,Object>
		.as(BookingInfo.class);
		
		System.out.println(booking.getBookingid());
		System.out.println(booking.getBooking().getFirstname());
		System.out.println(booking.getBooking().getLastname());
		System.out.println(booking.getBooking().getDepositpaid());
		System.out.println(booking.getBooking().getTotalprice());
		System.out.println(booking.getBooking().getBookingdates().getCheckin());
		System.out.println(booking.getBooking().getBookingdates().getCheckout());
	}

	private static void convertToJsonObject() throws JsonMappingException, JsonProcessingException {
		String body = RestAssured.given().baseUri("https://restful-booker.herokuapp.com/").basePath("booking")
		.contentType(ContentType.JSON).body(PAYLOAD).when().post().then().extract().body().asString();
		
		ObjectMapper object = new ObjectMapper();
		BookingInfo bookingInfo = object.readValue(body, BookingInfo.class);
		System.out.println(bookingInfo.getBooking().getFirstname());
		
		ObjectNode object2 = RestAssured.given().baseUri("https://restful-booker.herokuapp.com/").basePath("booking")
		.contentType(ContentType.JSON).body(PAYLOAD).when().post().then().extract().body()
		.as(ObjectNode.class);
		
		object2.fields().forEachRemaining(entry -> {
			System.out.println("Key -> "+entry.getKey());
			System.out.println("val -> "+entry.getValue());
		});
	}
}
