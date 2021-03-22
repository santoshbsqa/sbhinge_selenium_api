package testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import framework.TestBase;
import pages.ChooseFlightPage;
import pages.FindFlightPage;
import pages.PassengerDetailsPage;

public class BlazeDemoBookingCreateTest extends TestBase {
	/**
	 * =========================================================================
	 * <br>
	 * Test/Function Name : BlazeDemoBookingCreateTest <br>
	 * Description : Make a booking on Blaze Demo application payment <br>
	 * Author Name : Santosh Bhinge<br>
	 * Arguments : NA <br>
	 * Return Value : <br>
	 * Created Date : 21 MAR 2021<br>
	 * Reviewed By : Santosh Bhinge (Santi) <br>
	 * Reviewed Date : <br>
	 * Modified By : <br>
	 * Modified Date : <br>
	 * Used At : <br>
	 * =========================================================================
	 * <br>
	 */
	@Test(dataProvider = "ExcelMaps")
	public void createNewBookingTest(HashMap<String, String> testData) throws Exception {
		FindFlightPage findFlightPage = new FindFlightPage(driver);
		findFlightPage.findFlightsByRouting(testData);

		ChooseFlightPage chooseFlight = new ChooseFlightPage(driver);
		chooseFlight.clickFirstFlight();

		PassengerDetailsPage passengerDetails = new PassengerDetailsPage(driver);
		passengerDetails.enterPassengerDetails(testData);
	}

}
