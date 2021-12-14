package nitin.automation.beans;

import java.util.List;
import java.util.Random;

import org.apache.commons.lang.RandomStringUtils;

import edu.emory.mathcs.backport.java.util.Arrays;

public class Example20Beans {

	private String companyName;
	private String companyHOCity;
	private String companyCEO;
	private List<String> supportedSalaryBanks;
	private List<Integer> pincodesOfCityOffice;
	ComparnyPFDetails companyPFDeails;
	List<Employee> employee;
	List<Contractor> contractors;
	
	private Example20Beans() {
		String [] banks = {"ICICI","AXIS","SBI"};
		Integer[] pins = {new Random().nextInt(6), new Random().nextInt(6), new Random().nextInt(6)};
		Employee[] employees = {Employee.newBuilder().build(), Employee.newBuilder().build(), Employee.newBuilder().build()};
		Contractor[] contractors = {Contractor.newBuilder().build(), Contractor.newBuilder().build(), Contractor.newBuilder().build()};
		
		this.companyName = RandomStringUtils.random(10, true, false);
		this.companyCEO = RandomStringUtils.random(5, true, false);
		this.companyHOCity = RandomStringUtils.random(10, true, false);
		this.companyPFDeails = ComparnyPFDetails.newBuilder().build();
		this.supportedSalaryBanks = Arrays.asList(banks);
		this.pincodesOfCityOffice = Arrays.asList(pins);
		this.employee = Arrays.asList(employees);
		this.contractors = Arrays.asList(contractors);
	} 
	
	public static Example20Beans newBuilder() {
		return new Example20Beans();
	}

	public Example20Beans build() {
		setCompanyName(this.companyName);
		setCompanyCEO(this.companyCEO);
		setCompanyHOCity(this.companyHOCity);
		setCompanyPFDeails(this.companyPFDeails);
		setSupportedSalaryBanks(this.supportedSalaryBanks);
		setPincodesOfCityOffice(this.pincodesOfCityOffice);
		setEmployee(this.employee);
		setContractors(this.contractors);
		return this;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	public Example20Beans setCompanyName(String companyName) {
		this.companyName = companyName;
		return this;
	}
	public String getCompanyHOCity() {
		return companyHOCity;
	}
	public Example20Beans setCompanyHOCity(String companyHOCity) {
		this.companyHOCity = companyHOCity;
		return this;
	}
	public String getCompanyCEO() {
		return companyCEO;
	}
	public Example20Beans setCompanyCEO(String companyCEO) {
		this.companyCEO = companyCEO;
		return this;
	}
	public List<String> getSupportedSalaryBanks() {
		return supportedSalaryBanks;
	}
	public Example20Beans setSupportedSalaryBanks(List<String> supportedSalaryBanks) {
		this.supportedSalaryBanks = supportedSalaryBanks;
		return this;
	}
	public List<Integer> getPincodesOfCityOffice() {
		return pincodesOfCityOffice;
	}
	public Example20Beans setPincodesOfCityOffice(List<Integer> pincodesOfCityOffice) {
		this.pincodesOfCityOffice = pincodesOfCityOffice;
		return this;
	}
	
	public List<Employee> getEmployee() {
		return employee;
	}
	public Example20Beans setEmployee(List<Employee> employee) {
		this.employee = employee;
		return this;
	}
	public List<Contractor> getContractors() {
		return contractors;
	}
	public Example20Beans setContractors(List<Contractor> contractors) {
		this.contractors = contractors;
		return this;
	}
	public ComparnyPFDetails getCompanyPFDeails() {
		return companyPFDeails;
	}
	public Example20Beans setCompanyPFDeails(ComparnyPFDetails companyPFDeails) {
		this.companyPFDeails = companyPFDeails;
		return this;
	}
}

