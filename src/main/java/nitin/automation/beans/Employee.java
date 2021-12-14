package nitin.automation.beans;

import java.util.Random;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

public class Employee {

	private int employeeID = 1;
	private String employeeName = "";
	private String employeeAddress = "";
	private long employeeContactNumber = 0;
	
	private Random r = new Random();
	RandomUtils ra = new RandomUtils();
	
	private Employee() {
		this.employeeID = r.nextInt(2);
		this.employeeContactNumber = r.nextLong();
		this.employeeAddress = RandomStringUtils.random(5, true, false);
		this.employeeName = RandomStringUtils.random(10, true, false);
	}

	public Employee build() {
		setEmployeeID(this.employeeID);
		setEmployeeName(this.employeeName);
		setEmployeeContactNumber(this.employeeContactNumber);
		setEmployeeAddress(this.employeeAddress);
		return this;
	}
	
	public static Employee newBuilder() {
		return new Employee();
	}
	
	public int getEmployeeID() {
		return employeeID;
	}
	public Employee setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
		return this;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public Employee setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
		return this;
	}
	public String getEmployeeAddress() {
		return employeeAddress;
	}
	public Employee setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
		return this;
	}
	public long getEmployeeContactNumber() {
		return employeeContactNumber;
	}
	public Employee setEmployeeContactNumber(long employeeContactNumber) {
		this.employeeContactNumber = employeeContactNumber;
		return this;
	}
	
}
