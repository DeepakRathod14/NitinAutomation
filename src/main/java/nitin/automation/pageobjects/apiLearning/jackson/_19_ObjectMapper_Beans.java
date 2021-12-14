package nitin.automation.pageobjects.apiLearning.jackson;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import nitin.automation.beans.Employee;
import nitin.automation.beans.Employee2;

/*
 * Example-2 payload looks like this
 * [
  {
    "EmployeeID": 1,
    "EmployeeName": "Deepak",
    "EmployeeAddress": "Pune",
    "EmployeeContact": 9173668187,
  },
  {
    "EmployeeID": 2,
    "EmployeeName": "Nitin",
    "EmployeeAddress": "Ahmedabad",
    "EmployeeContact": 12345678,
  },
  {
    "EmployeeID": 3,
    "EmployeeName": "Tarun",
    "EmployeeAddress": "Bhavnagar",
    "EmployeeContact": 87654321,
  }
]
 */
public class _19_ObjectMapper_Beans {

	private static String allEmployeeJson;
	
	public static void main(String[] args) throws JsonProcessingException {
		//example1();
		example2();
	}
	
	public static void example1() throws JsonProcessingException {
		Employee e = Employee.newBuilder();
		e.setEmployeeID(1);
		e.setEmployeeName("Deepak");
		e.setEmployeeAddress("Pune");
		e.setEmployeeContactNumber(9173668187l);
	
		ObjectMapper om = new ObjectMapper();
		String json = om.writerWithDefaultPrettyPrinter().writeValueAsString(e);
		System.out.println("Serialized Example ");
		System.out.println(json);
	
		// Converting EMployee json string to Employee class object
		Employee2 e2 = om.readValue(json, Employee2.class);
		System.out.println("Deserialized Example");
		System.out.println("EID : "+e2.getEmployeeID());
		System.out.println("EName : "+e2.getEmployeeName());
		System.out.println("EAdd  : "+e2.getEmployeeAddress());
		System.out.println("ENum  : "+e2.getEmployeeContactNumber());
		System.out.println("Extra : "+e2.getExtra());
	}
	
	public static void example2() throws JsonProcessingException {
		Employee e1 = Employee.newBuilder().setEmployeeName("Deepak");
		Employee e2 = Employee.newBuilder().setEmployeeName("Nitin");
		Employee e3 = Employee.newBuilder().setEmployeeName("tarun");
	
		List<Employee> allEMployees = new ArrayList<Employee>();
		allEMployees.add(e1);
		allEMployees.add(e2);
		allEMployees.add(e3);
		// Converting a Java class object to a JSON Array payload as string
		ObjectMapper objectMapper = new ObjectMapper();
		allEmployeeJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(allEMployees);
		System.out.println(allEmployeeJson);
		
		List<Employee> allEmploeesDetails = objectMapper.readValue(allEmployeeJson, new TypeReference<List<Employee>>() {});
		allEmploeesDetails.forEach( emp -> {
			System.out.println("ID : "+emp.getEmployeeID());
			System.out.println("Name : "+emp.getEmployeeName());
			System.out.println("Address : "+emp.getEmployeeAddress());
			System.out.println("Mobile  : "+emp.getEmployeeContactNumber());
		});
	}
	
}
