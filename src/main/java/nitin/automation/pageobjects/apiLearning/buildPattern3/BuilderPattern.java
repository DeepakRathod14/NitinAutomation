package nitin.automation.pageobjects.apiLearning.buildPattern3;

public class BuilderPattern {
	// Change return type of each method as Class type
	// "this" always points to current/calling object. Returning the same to
	// have same reference
	public BuilderPattern M1() {
		System.out.println("M1");
		return this;
	}

	public BuilderPattern M2(String str) {
		System.out.println("Pass string is " + str);
		return this;
	}

	public BuilderPattern M3() {
		System.out.println("M3");
		return this;
	}

	public static void main(String[] args) {

		BuilderPattern nbp = new BuilderPattern();
		nbp.M1().M2("Amod").M3();
	}
}
