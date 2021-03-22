package pages;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import framework.GenericLibrary;

public class FindFlightPage {
	GenericLibrary genericLibrary;

	WebDriver driver;

	@FindBy(name = "fromPort")

	WebElement lst_DepartureCity;

	@FindBy(name = "toPort")

	WebElement lst_DestinationCity;

	@FindBy(tagName = "input")

	WebElement btn_FindFlights;

	public FindFlightPage(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);
		genericLibrary = new GenericLibrary();

	}

	/**
	 * =========================================================================
	 * <br>
	 * Test/Function Name : findFlightsByRouting <br>
	 * Description : find flights by routing <br>
	 * Author Name : Santosh Bhinge<br>
	 * Arguments : NA <br>
	 * Return Value : <br>
	 * Created Date : 27 AUG 2019<br>
	 * Reviewed By : Santosh Bhinge (Santi) <br>
	 * Reviewed Date : <br>
	 * Modified By : <br>
	 * Modified Date : <br>
	 * Used At : <br>
	 * =========================================================================
	 * <br>
	 */
	public void findFlightsByRouting(Map<String, String> testData) throws InterruptedException {
		selectDepartureCity(testData.get("DepartureCity"));
		selectDestinationCity(testData.get("DestinationCity"));
		clickFindFlight();
	}

	public void selectDepartureCity(String value) {
		genericLibrary.selectByValue(lst_DepartureCity, value);
	}

	public void selectDestinationCity(String value) {
		genericLibrary.selectByValue(lst_DestinationCity, value);
	}

	public void clickFindFlight() {
		btn_FindFlights.click();
	}
}
