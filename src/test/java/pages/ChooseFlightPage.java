package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Santosh bhinge 23 Mar 2021.
 */
public class ChooseFlightPage {

	private int explicitTimeOut;

	@FindBy(xpath = "//input[@value='Choose This Flight']")
	WebElement btn_FirstFlight;

	public ChooseFlightPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickFirstFlight() {
		btn_FirstFlight.click();
	}

}
