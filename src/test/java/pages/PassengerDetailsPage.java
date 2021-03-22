package pages;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.GenericLibrary;

/**
 * Created by Santosh Bhinge 21 Mar 2021.
 */
public class PassengerDetailsPage {

	private GenericLibrary genericLibrary;
	private int explicitTimeOut;

	@FindBy(xpath = "//descendant::h2")
	WebElement purchasePageTitle;

	@FindBy(name = "inputName")
	WebElement name;

	@FindBy(name = "address")
	WebElement address;

	@FindBy(name = "city")
	WebElement city;

	@FindBy(name = "state")
	WebElement state;

	@FindBy(name = "zipCode")
	WebElement zipCode;

	@FindBy(name = "cardType")
	WebElement cardType;

	@FindBy(name = "creditCardNumber")
	WebElement cardNumber;

	@FindBy(name = "creditCardMonth")
	WebElement month;

	@FindBy(name = "creditCardYear")
	WebElement year;

	@FindBy(name = "nameOnCard")
	WebElement cardName;

	@FindBy(name = "rememberMe")
	WebElement rememberMeCheckBox;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement purchaseFlight;

	public PassengerDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		genericLibrary = new GenericLibrary();
	}

	public void enterPassengerDetails(HashMap<String, String> testData) {
		enterPassengerName(testData.get("Name"));
		enterPassengerAddress(testData.get("Address"));
		enterPassengerCity(testData.get("City"));
		enterPassengerState(testData.get("State"));
		enterPassengerZipCode(testData.get("ZipCode"));
		enterPassengerCardNumber(testData.get("CardNumber"));
		enterPassengerCardMonth(testData.get("CardMonth"));
		enterPassengerCardYear(testData.get("CardYear"));
		enterPassengerCardName(testData.get("CardName"));
		clickPurchaseFlights();
	}

	public void verifyPurchasePageDisplayed() {
		genericLibrary.isElementVisible(purchasePageTitle, explicitTimeOut);
		purchasePageTitle.isDisplayed();
	}

	public void enterPassengerName(String value) {
		genericLibrary.isElementVisible(name, explicitTimeOut);
		name.clear();
		name.sendKeys(value);
	}

	public void enterPassengerAddress(String value) {
		genericLibrary.isElementVisible(address, explicitTimeOut);
		address.clear();
		address.sendKeys(value);
	}

	public void enterPassengerCity(String value) {
		genericLibrary.isElementVisible(city, explicitTimeOut);
		city.clear();
		city.sendKeys(value);
	}

	public void enterPassengerState(String value) {
		genericLibrary.isElementVisible(state, explicitTimeOut);
		state.clear();
		state.sendKeys(value);
	}

	public void enterPassengerZipCode(String value) {
		genericLibrary.isElementVisible(zipCode, explicitTimeOut);
		zipCode.clear();
		zipCode.sendKeys(value);
	}

	public void enterPassengerCardType(String value) {
		genericLibrary.isElementVisible(cardType, explicitTimeOut);
		genericLibrary.selectByValue(cardType, value);
	}

	public void enterPassengerCardNumber(String value) {
		genericLibrary.isElementVisible(cardNumber, explicitTimeOut);
		cardNumber.clear();
		cardNumber.sendKeys(value);
	}

	public void enterPassengerCardMonth(String value) {
		genericLibrary.isElementVisible(month, explicitTimeOut);
		month.clear();
		month.sendKeys(value);
	}

	public void enterPassengerCardYear(String value) {
		genericLibrary.isElementVisible(year, explicitTimeOut);
		year.clear();
		year.sendKeys(value);
	}

	public void enterPassengerCardName(String value) {
		genericLibrary.isElementVisible(cardName, explicitTimeOut);
		cardName.clear();
		cardName.sendKeys(value);
	}

	public void enableRememberMeCheckBox() {
		genericLibrary.isElementVisible(rememberMeCheckBox, explicitTimeOut);
		if (!rememberMeCheckBox.isSelected())
			rememberMeCheckBox.click();
	}

	public void disableRememberMeCheckBox() {
		genericLibrary.isElementVisible(rememberMeCheckBox, explicitTimeOut);
		if (rememberMeCheckBox.isSelected())
			rememberMeCheckBox.click();
	}

	public void clickPurchaseFlights() {
		genericLibrary.isElementVisible(purchaseFlight, explicitTimeOut);
		purchaseFlight.click();
	}

}
