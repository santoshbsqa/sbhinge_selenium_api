package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

/**
 * Created by Santosh Bhinge 21 Mar 2021
 */
public class ConfirmationPage {

	public ConfirmationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "/descendant::h1")
	WebElement confirmationPageTitle;

	@FindBy(xpath = "//td[text()='Id']/following-sibling::td")
	WebElement lbl_Id;

	public void verifyConfirmationPageDisplayed() {

		confirmationPageTitle.isDisplayed();

		String confirmationMessage = confirmationPageTitle.getText();

		Assert.assertEquals(confirmationMessage, "confirmationMessage", "Confirmation message");

		String confirmationId = lbl_Id.getText();

		Reporter.log("confirmationId: " + confirmationId, true);

	}
}
