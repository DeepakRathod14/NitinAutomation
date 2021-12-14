package nitin.automation.pageobjects.apiLearning.buildPattern3;

import org.openqa.selenium.By;

public class NoBuildPattern {
	
	public void M1() {
		System.out.println("M1");
	}

	public void M2(String str) {
		System.out.println("Pass string is " + str);
	}

	public void M3() {
		System.out.println("M3");
	}

	public static void main(String[] args) {

		NoBuildPattern nbp = new NoBuildPattern();
		nbp.M1();
		nbp.M2("Amod");
		nbp.M3();
		
		nbp
			.M4()
			.M5()
			.M1();
		
		nbp.M4();
		nbp.M5();
		nbp.M1();
		
		System.out.println(nbp.demo().toLowerCase());
	}
	
	public String demo() {
		return "Hello";
	}
	
	public NoBuildPattern M4() {
		System.out.println("Builder pattern by M4");
		return this;
	}
	
	public NoBuildPattern M5() {
		System.out.println("Builder pattern by M5");
		return this;
	}
}
