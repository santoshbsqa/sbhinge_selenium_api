package framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static String projectPath;

	@BeforeTest
	public void setUp() throws IOException {
		setProjectPath();
		prop = PropertiesReader.getProperties();
		if (prop.getProperty("execute.browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					projectPath + "\\src\\test\\resources\\driver\\chrome\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		} else {
			System.setProperty("webdriver.gecko.driver",
					projectPath + "\\src\\test\\resources\\driver\\firefox\\geckodriver.exe");
			// driver = new GeckoDriver();
		}

		driver.get(prop.getProperty("application.url"));
	}

	public void setProjectPath() {
		String externalPath = "resources";
		projectPath = new File(externalPath).getAbsolutePath().replace("\\resources", "");
	}

	@AfterTest
	public void tearDown() throws InterruptedException {
		System.out.println("AfterTest: tearDown()");
		Thread.sleep(10000);
		driver.quit();
	}

	public WebDriver getDriver() {
		return driver;
	}

	@DataProvider(name = "ExcelMaps")
	public Object[] getExcelMaps() throws FileNotFoundException, IOException {
		/* file object */
		HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(
				projectPath + "\\src\\test\\resources\\testdata\\TD_TestData.xls"));

		/* specific sheet object */
		HSSFSheet sheetTestData = workbook.getSheet("testdata");

		int totalRows = sheetTestData.getPhysicalNumberOfRows();

		HSSFRow rowHeader = sheetTestData.getRow(0);

		int totalColumns = rowHeader.getPhysicalNumberOfCells();

		Object object[] = new Object[totalRows - 1];

		// first loop Iterating for all numbers of rows
		for (int rowCounter = 1; rowCounter < totalRows; rowCounter++) {

			HashMap<String, String> hashMap = new HashMap<String, String>();

			HSSFRow row = sheetTestData.getRow(rowCounter);

			// second loop iterates for all the column for that specific row
			for (int columnCounter = 0; columnCounter < totalColumns; columnCounter++) {

				String headerData = rowHeader.getCell(columnCounter).getStringCellValue();

				String rowData = row.getCell(columnCounter).getStringCellValue();

				hashMap.put(headerData, rowData);

			}

			object[rowCounter - 1] = hashMap;
		}
		return object;
	}
	
}
