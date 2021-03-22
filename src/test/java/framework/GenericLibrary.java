package framework;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class GenericLibrary extends TestBase {
	
	public void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public Boolean isElementVisible(WebElement element, final long timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (ElementNotVisibleException e) {
			Reporter.log("not found on the page. Here are the exception details: ");
			Reporter.log(String.valueOf(e));
		}
		return false;
	}

}
