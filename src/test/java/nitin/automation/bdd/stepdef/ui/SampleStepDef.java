package nitin.automation.bdd.stepdef.ui;

import java.util.List;
import java.util.Map;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;

public class SampleStepDef {

	@Then("^verify list of options should be display$")
	public void verify_list_of_options_should_be_display(DataTable table) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
		// E,K,V must be a scalar (String, Integer, Date, enum etc)

		/**
		 * //Example-1 of converting DataTable into List [ should be == 1 column ]
		 * List<String> list = table.asList(String.class); for(String s : list) {
		 * System.out.println("Conversion : "+s); }
		 **/
		/**
		 * //Example-2 of converting DataTable into Map [ should be == 2 columns ]
		 * Map<String, String> map = table.asMap(String.class, String.class);
		 * map.forEach( (k,v) -> System.out.println("Key = "+k+ ": value ="+v));
		 **/
		// Example-3 of converting DataTable into Row, column, cell [ Should >= 3
		// columns ]
		List<DataTableRow> dtr = table.getGherkinRows();
		for (DataTableRow row : dtr) {
			List<String> cells = row.getCells();
			System.out.println("------ String of Row ------");
			for (String cell : cells) {
				System.out.println("Cell Data : " + cell);
			}
			System.out.println("------ End of Row ------");
		}
	}

	@When("^parameter of integer is (\\d+) and float is (\\d+)\\.(\\d+) and char 'a'$")
	public void itCouldBeAnything(int arg1, float arg2, char arg3) throws Throwable {
		System.out.println(arg1 + "is Integer? ");
		System.out.println(arg2 + "is Integer? ");
		System.out.println(arg3 + "is Integer? ");
	}

	@Then("^close Browser$")
	public void close_Browser() {
		System.out.println("Close browser");
	}
}
