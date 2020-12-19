package pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class commonPage extends PageObject {

	////////////////// FORM VALIDATOR ERRORS /////////////////////////
	@FindBy(xpath = "//*[@class=\"mat-error ng-star-inserted\"]")
	private List<WebElementFacade> error_msg;

	/////////////////////////////////////////////////////////////////

	/////////////////// ERROR RETRIEVE METHODS ///////////////////////////
	public boolean getResultTitles(String errormessage) {
		List<String> all_error_msgs = error_msg.stream().map(element -> element.getText()).collect(Collectors.toList());
		System.out.println(all_error_msgs);
		if (all_error_msgs.contains(errormessage)) {
			return true;
		} else {
			return false;
		}
	}
	/////////////////////////////////////////////////////////////////////
}
