package nitin.automation.pageobjects.apiLearning.gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import nitin.automation.beans.Employee;

public class _21_Serialized_Example {

	public static void main(String[] args) throws IOException {
		//pojoToJson();
		jsonToPojo();
	}
	
	public static void pojoToJson() throws IOException {
		Employee employeeObject = Employee.newBuilder().build();
		
		// Create a Gson object
		Gson gson = new Gson();
		
		// toJson(Object src) method converts Java object to JSON object
		String employeeJsonSring = gson.toJson(employeeObject);
		// Printing json string. It will be pretty print 
		System.out.println("Non-pretty JSON String :- ");
		System.out.println(employeeJsonSring);
		
		// We can create a configurable Gson instance using GsonBuilder class
		Gson gsonBuilder = new GsonBuilder().setPrettyPrinting().create();
		String employeeJsonSringUsingJsonBuilder = gsonBuilder.toJson(employeeObject);
		System.out.println("Pretty JSON String :- ");
		System.out.println(employeeJsonSringUsingJsonBuilder);
		
		// To write Json object in to a file, we need to pass a FileWriter object which is in direct implementation of 
		// Appendable interface. Make sure you call flush() method otherwise json file will be empty.
		String userDir = System.getProperty("user.dir");
		File outputJsonFile = new File(userDir+ "\\src\\main\\resources\\gson\\EmployeePayloadUsingGson.json");
		FileWriter fileWriter = new FileWriter(outputJsonFile);
		gsonBuilder.toJson(employeeObject,fileWriter);
		fileWriter.flush();
	}
	
	public static void jsonToPojo() throws FileNotFoundException {
		Gson gson = new Gson();
		// Pass JSON string and the POJO class
		String userDir = System.getProperty("user.dir");
		File outputJsonFile = new File(userDir+ "\\src\\main\\resources\\gson\\EmployeePayloadUsingGson.json");
		FileReader reader = new FileReader(outputJsonFile);
		Employee employeeObject = gson.fromJson(reader, Employee.class);
		
		System.out.println(employeeObject.getEmployeeID());
		System.out.println(employeeObject.getEmployeeName());
		System.out.println(employeeObject.getEmployeeAddress());
		System.out.println(employeeObject.getEmployeeContactNumber());
	}
}
