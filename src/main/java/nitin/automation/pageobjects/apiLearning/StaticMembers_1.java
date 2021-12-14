package nitin.automation.pageobjects.apiLearning;

public class StaticMembers_1 {
	public static int number = 10;
	public static final String REST_ASSURED = "RestAssured";
	
	public static void staticGet() {
		System.out.println("Number : "+number);
		System.out.println("Rest Assured : "+REST_ASSURED);
	}
}
