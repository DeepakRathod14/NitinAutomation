package nitin.automation.beans;

import java.util.Random;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

public class Employee2 {

	private int emp = 0;
	private int id = 1;
	private String employeeName = "";
	private String employeeAddress = "";
	private long employeeContactNumber = 0;
	
	public int getExtra() {
		return emp;
	}

	public void setExtra(int emp) {
		this.emp = emp;
	}
	
	public int getEmployeeID() {
		return id;
	}
	public Employee2 setEmployeeID(int id) {
		this.id = id;
		return this;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public Employee2 setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
		return this;
	}
	public String getEmployeeAddress() {
		return employeeAddress;
	}
	public Employee2 setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
		return this;
	}
	public long getEmployeeContactNumber() {
		return employeeContactNumber;
	}
	public Employee2 setEmployeeContactNumber(long employeeContactNumber) {
		this.employeeContactNumber = employeeContactNumber;
		return this;
	}
}
