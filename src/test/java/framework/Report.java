package framework;

import org.testng.Assert;
import org.testng.Reporter;

public class Report {

	public static void stepLog(boolean booleanStatus, String info) {
		String status;
		status = booleanStatus ? "PASSED" : "FAILED";
		Reporter.log(status + " : " + info, true);
		Assert.assertTrue(booleanStatus, info);
	}

}
