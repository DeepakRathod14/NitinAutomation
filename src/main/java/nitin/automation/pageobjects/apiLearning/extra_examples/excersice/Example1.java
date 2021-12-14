package nitin.automation.pageobjects.apiLearning.extra_examples.excersice;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import nitin.automation.pageobjects.apiLearning.extra_examples.beans.EmployeePojoWithSetterMethodsOnly;
import nitin.automation.pageobjects.apiLearning.extra_examples.beans.EmployeeWithGetterMethodsOnly;

/*
 * Demonstration of what happen if we don't have getter/setter methods available while serialized/deserialized.
 * serialized = internally call, getter
 * deserialized = internally call, setter
 */
public class Example1 {

	/**
	 * Example-1 : with getter & setter (serialized + deserialized) : output = works fine
	 * Example-2 : without setter
	 * 	serialized: with default values (null, 0, false, etc)
	 * 	deserialized: work correctly.
	 * Example-3 : without getter
	 * 	serialized: Exception: InvalidDefinitionException
	 * 	deserialize:  
	 * @throws JsonProcessingException
	 */
	@Test(description = "while serialization, it internally call getter methods."
			+ "generate output with default values of premitive values")
	public void serializeWithGetterOnly() throws JsonProcessingException {
		// Just create an object of Pojo class but we can set values as we do not have
		// any setter methods
		EmployeeWithGetterMethodsOnly employeeWithGetterMethodsOnly = new EmployeeWithGetterMethodsOnly();

		// Converting a Java class object to a JSON payload as string
		ObjectMapper objectMapper = new ObjectMapper();
		String employeeJson = objectMapper.writerWithDefaultPrettyPrinter()
				.writeValueAsString(employeeWithGetterMethodsOnly);
		System.out.println("Serialization...");
		System.out.println(employeeJson);
	}
	
	@Test(description = "while descrialization, it internally call setter and works correctly"
			+ "I think it should assigned values to direct variables")
	public void deserializeWithGetterOnly() throws JsonProcessingException {
		String jsonString = "{\r\n" + 
				"  \"firstName\" : \"Amod\",\r\n" + 
				"  \"lastName\" : \"Mahajan\",\r\n" + 
				"  \"gender\" : \"Male\",\r\n" + 
				"  \"age\" : 29,\r\n" + 
				"  \"salary\" : 12323.56,\r\n" + 
				"  \"married\" : false\r\n" + 
				"}";
		
		System.out.println("Deserialization...");
		ObjectMapper objectMapper = new ObjectMapper();
		EmployeeWithGetterMethodsOnly employeeWithGetterMethodsOnly = objectMapper.readValue(jsonString, EmployeeWithGetterMethodsOnly.class);
		
		System.out.println("First name :- "+employeeWithGetterMethodsOnly.getFirstName());
		System.out.println("Last name :- "+employeeWithGetterMethodsOnly.getLastName());
		System.out.println("Age :- "+employeeWithGetterMethodsOnly.getAge());
		System.out.println("Gender :- "+employeeWithGetterMethodsOnly.getGender());
		System.out.println("Salary :- "+employeeWithGetterMethodsOnly.getSalary());
		System.out.println("Married :- "+employeeWithGetterMethodsOnly.getMarried());
	}

	//@Test(description = "It will throw and exception, InvalidDefinitionException because no getter methods")
	public void serializeWithSetterOnly() throws JsonProcessingException {
		// Just create an object of Pojo class
		EmployeePojoWithSetterMethodsOnly employeePojoWithSetterMethodsOnly = new EmployeePojoWithSetterMethodsOnly();
		employeePojoWithSetterMethodsOnly.setFirstName("Amod");
		employeePojoWithSetterMethodsOnly.setLastName("Mahajan");
		employeePojoWithSetterMethodsOnly.setAge(29);
		employeePojoWithSetterMethodsOnly.setGender("Male");
		employeePojoWithSetterMethodsOnly.setSalary(12323.56);
		employeePojoWithSetterMethodsOnly.setMarried(false);
		
		// Converting a Java class object to a JSON payload as string
		System.out.println("Serialization...");
		ObjectMapper objectMapper = new ObjectMapper();
		String employeeJson = objectMapper.writerWithDefaultPrettyPrinter()
				.writeValueAsString(employeePojoWithSetterMethodsOnly);
		System.out.println(employeeJson);
	}
	
	@Test(description = "deserializeWithSetterOnly: works correctly because it required only setter methods")
	public void deserializeWithSetterOnly() throws JsonProcessingException {
		String jsonString = "{\r\n" + 
				"  \"firstName\" : \"Amod\",\r\n" + 
				"  \"lastName\" : \"Mahajan\",\r\n" + 
				"  \"gender\" : \"Male\",\r\n" + 
				"  \"age\" : 29,\r\n" + 
				"  \"salary\" : 12323.56,\r\n" + 
				"  \"married\" : false\r\n" + 
				"}";
		
		System.out.println("Deserialization...");
		ObjectMapper objectMapper = new ObjectMapper();
		EmployeePojoWithSetterMethodsOnly employeePojoWithSetterMethodsOnly = objectMapper.readValue(jsonString, EmployeePojoWithSetterMethodsOnly.class);
	}
}
