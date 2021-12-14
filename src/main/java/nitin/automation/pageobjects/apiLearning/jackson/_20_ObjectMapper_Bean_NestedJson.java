package nitin.automation.pageobjects.apiLearning.jackson;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import nitin.automation.beans.Example20Beans;

//Simple example of bean is present here
//http://makeseleniumeasy.com/2020/06/18/rest-assured-tutorial-31-how-to-create-pojo-classes-of-a-nested-json-payload/
public class _20_ObjectMapper_Bean_NestedJson {
	public static void main(String[] args) throws IOException {
		example1();
		//example2();
	}
	
	public static void example1() throws JsonProcessingException {
		Example20Beans bean = Example20Beans.newBuilder().build();
		ObjectMapper objectMapper = new ObjectMapper();
		String nestedJsonPayload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(bean);
		System.out.println(nestedJsonPayload);
	}
	
	//Instead of print JSON on console print it into file
	//1. read POJO --> seriallized it --> write it into file
	public static void example2() throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		Example20Beans bean = Example20Beans.newBuilder().build();
		
		String userDir = System.getProperty("user.dir");
		File outputJsonFile = new File(userDir+ "\\src\\main\\resources\\Payload\\Example20_EmployeePayload.json");
		objectMapper.writerWithDefaultPrettyPrinter().writeValue(outputJsonFile, bean);
	}
	
	public static void example3() throws JsonMappingException, JsonProcessingException {
		//Deserialized (JSON file --> to --> Java object)
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.readValue("File/Path", Example20Beans.class);
	}
}
