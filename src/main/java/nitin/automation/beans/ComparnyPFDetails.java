package nitin.automation.beans;

import java.util.Random;

import org.apache.commons.lang.RandomStringUtils;

public class ComparnyPFDetails {
	private String pfName;
	private String pfCity;
	private int pfYear;
	private int noOfEmployees;
	
	private ComparnyPFDetails() {
	}
	
	public static ComparnyPFDetails newBuilder() {
		return new ComparnyPFDetails();
	}
	
	public ComparnyPFDetails build() {
		setPfName(RandomStringUtils.random(3, true, false));
		setPfCity(RandomStringUtils.random(5, true, false));
		setPfYear(new Random().nextInt(4));
		setNoOfEmployees(new Random().nextInt(3));
		return this;
	}
	
	public String getPfName() {
		return pfName;
	}
	public ComparnyPFDetails setPfName(String pfName) {
		this.pfName = pfName;
		return this;
	}
	public String getPfCity() {
		return pfCity;
	}
	public ComparnyPFDetails setPfCity(String pfCity) {
		this.pfCity = pfCity;
		return this;
	}
	public int getPfYear() {
		return pfYear;
	}
	public ComparnyPFDetails setPfYear(int pfYear) {
		this.pfYear = pfYear;
		return this;
	}
	public int getNoOfEmployees() {
		return noOfEmployees;
	}
	public ComparnyPFDetails setNoOfEmployees(int noOfEmployees) {
		this.noOfEmployees = noOfEmployees;
		return this;
	}
}
