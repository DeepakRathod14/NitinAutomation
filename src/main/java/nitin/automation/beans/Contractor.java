package nitin.automation.beans;

import org.apache.commons.lang.RandomStringUtils;

public class Contractor {

	private String firstName;
	private String lastName;
	private String contractFrom;
	private String contractTo;
	
	private Contractor() {
		this.firstName = RandomStringUtils.random(10, true, false);
		this.lastName = RandomStringUtils.random(10, true, false);
		this.contractFrom = RandomStringUtils.randomNumeric(8);
		this.contractTo = RandomStringUtils.randomNumeric(8);
	}

	public Contractor build() {
		setFirstName(this.firstName);
		setLastName(this.lastName);
		setContractFrom(this.contractFrom);
		setContractTo(this.contractTo);
		return this;
	}
	
	public static Contractor newBuilder() {
		return new Contractor();
	}
	
	public String getFirstName() {
		return firstName;
	}
	public Contractor setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	public String getLastName() {
		return lastName;
	}
	public Contractor setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	public String getContractFrom() {
		return contractFrom;
	}
	public Contractor setContractFrom(String contractFrom) {
		this.contractFrom = contractFrom;
		return this;
	}
	public String getContractTo() {
		return contractTo;
	}
	public Contractor setContractTo(String contractTo) {
		this.contractTo = contractTo;
		return this;
	}
}
