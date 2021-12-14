package nitin.automation.pageobjects.apiLearning.jackson;

import nitin.automation.beans.Employee;
import nitin.automation.beans.Employee2;

public class BulderPattern {
	public static void main(String[] args) {
		//withoutBuilder();
		withBuilder();
	}
	
	public static void withoutBuilder() {
		Employee2 e = new Employee2();

		e.setEmployeeID(1);
		e.setEmployeeName("ABC");
		e.setEmployeeAddress("ifjksdajfdsk");
		e.setEmployeeContactNumber(123909459409l);
		
		System.out.println(e.getEmployeeID());
		System.out.println(e.getEmployeeName());
		System.out.println(e.getEmployeeAddress());
		System.out.println(e.getEmployeeContactNumber());
	}
	
	public static void withBuilder() {
		Employee e = Employee.newBuilder();
		e.setEmployeeID(1);
		System.out.println(e.getEmployeeID());
		System.out.println(e.getEmployeeName());
		System.out.println(e.getEmployeeAddress());
		System.out.println(e.getEmployeeContactNumber());
	}
}
