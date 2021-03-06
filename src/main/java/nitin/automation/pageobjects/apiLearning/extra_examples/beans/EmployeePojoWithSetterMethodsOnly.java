package nitin.automation.pageobjects.apiLearning.extra_examples.beans;

public class EmployeePojoWithSetterMethodsOnly {

	// private variables or data members of pojo class
	private String firstName;
	private String lastName;
	private String gender;
	private int age;
	private double salary;
	private boolean married;

	public void setFirstName(String firstName) {
		System.out.println("Setter - First Name : " + firstName);
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		System.out.println("Setter - Last Name : " + lastName);
		this.lastName = lastName;
	}

	public void setGender(String gender) {
		System.out.println("Setter - Gender : " + gender);
		this.gender = gender;
	}

	public void setAge(int age) {
		System.out.println("Setter - Age : " + age);
		this.age = age;
	}

	public void setSalary(double salary) {
		System.out.println("Setter - Salary : " + salary);
		this.salary = salary;
	}

	public void setMarried(boolean married) {
		System.out.println("Setter - Married : " + married);
		this.married = married;
	}

}
