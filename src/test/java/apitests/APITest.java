package apitests;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class APITest {
	@Test
	public void sampleServiceTest() {
		String url = "https://api.spacexdata.com/v4/launches/latest";

		JSONUtil jSONUtil = new JSONUtil();
		Client client = Client.create();
		WebResource webResource = client.resource(url);

		ClientResponse response = webResource.header("Authorization", "").header("apikey", "").header("username", "")
				.header("password", "").type("application/json").accept("application/json").get(ClientResponse.class);
		int statusCode = response.getStatus();
		Assert.assertEquals(statusCode, 200, "Status code");
		Reporter.log("Status code " + statusCode + " " + 200, true);
		String entity = response.getEntity(String.class);
		if (entity.contains("Data Not Found")) {
			Reporter.log("Data not found.", true);
		} else {
			JSONObject jsonObj;
			try {
				jsonObj = new JSONObject(entity);

				Reporter.log("flight_number " + jsonObj.get("flight_number").toString() + " "
						+ jSONUtil.getTestData("flight_number"), true);
				Assert.assertEquals(jsonObj.get("flight_number").toString(), jSONUtil.getTestData("flight_number"),
						"flight number");
				Reporter.log("_____________________________________________________", true);

				Assert.assertEquals(jsonObj.get("date_utc").toString(), jSONUtil.getTestData("date_utc"), "date_utc");
				Reporter.log("date_utc " + jsonObj.get("date_utc").toString() + " "
						+ jSONUtil.getTestData("date_utc"), true);
				Reporter.log("_____________________________________________________", true);

				Reporter.log("date_precision " + jsonObj.get("date_precision").toString() + " "
						+ jSONUtil.getTestData("date_precision"), true);
				Assert.assertEquals(jsonObj.get("date_precision").toString(), jSONUtil.getTestData("date_precision"),
						"date_precision");
				Reporter.log("_____________________________________________________", true);

				Reporter.log("date_local " + jsonObj.get("date_local").toString() + " "
						+ jSONUtil.getTestData("date_local"), true);
				Assert.assertEquals(jsonObj.get("date_local").toString(), jSONUtil.getTestData("date_local"),
						"date_local");
				Reporter.log("_____________________________________________________", true);

				Reporter.log("launchpad " + jsonObj.get("launchpad").toString() + " "
						+ jSONUtil.getTestData("launchpad"), true);
				Assert.assertEquals(jsonObj.get("launchpad").toString(), jSONUtil.getTestData("launchpad"),
						"launchpad");
				Reporter.log("_____________________________________________________", true);

				Reporter.log("auto_update " + jsonObj.get("auto_update").toString() + " "
						+ jSONUtil.getTestData("auto_update"), true);
				Assert.assertEquals(jsonObj.get("auto_update").toString(), jSONUtil.getTestData("auto_update"),
						"auto_update");
				Reporter.log("_____________________________________________________", true);

				Reporter.log("launch_library_id " + jsonObj.get("launch_library_id").toString() + " "
						+ jSONUtil.getTestData("launch_library_id"), true);
				Assert.assertEquals(jsonObj.get("launch_library_id").toString(),
						jSONUtil.getTestData("launch_library_id"), "launch_library_id");
				Reporter.log("_____________________________________________________", true);

				Reporter.log("flight_number " + jsonObj.get("flight_number").toString() + " "
						+ jSONUtil.getTestData("flight_number"), true);
				Assert.assertEquals(jsonObj.get("flight_number").toString(), jSONUtil.getTestData("flight_number"),
						"flight_number");
				Reporter.log("_____________________________________________________", true);

				Reporter.log("name " + jsonObj.get("name").toString() + " "
						+ jSONUtil.getTestData("name"), true);
				Assert.assertEquals(jsonObj.get("name").toString(), jSONUtil.getTestData("name"), "name");
				Reporter.log("_____________________________________________________", true);

				Reporter.log("date_utc " + jsonObj.get("date_utc").toString() + " "
						+ jSONUtil.getTestData("date_utc"), true);
				Assert.assertEquals(jsonObj.get("date_utc").toString(), jSONUtil.getTestData("date_utc"), "date_utc");
				Reporter.log("_____________________________________________________", true);

				Reporter.log("date_unix " + jsonObj.get("date_unix").toString() + " "
						+ jSONUtil.getTestData("date_unix"), true);
				Assert.assertEquals(jsonObj.get("date_unix").toString(), jSONUtil.getTestData("date_unix"),
						"date_unix");
				Reporter.log("_____________________________________________________", true);

				Reporter.log("date_local " + jsonObj.get("date_local").toString() + " "
						+ jSONUtil.getTestData("date_local"), true);
				Assert.assertEquals(jsonObj.get("date_local").toString(), jSONUtil.getTestData("date_local"),
						"date_local");
				Reporter.log("_____________________________________________________", true);

				Reporter.log("date_precision " + jsonObj.get("date_precision").toString() + " "
						+ jSONUtil.getTestData("date_precision"), true);
				Assert.assertEquals(jsonObj.get("date_precision").toString(), jSONUtil.getTestData("date_precision"),
						"date_precision");
				Reporter.log("_____________________________________________________", true);

				Reporter.log("upcoming " + jsonObj.get("upcoming").toString() + " "
						+ jSONUtil.getTestData("upcoming"), true);
				Assert.assertEquals(jsonObj.get("upcoming").toString(), jSONUtil.getTestData("upcoming"), "upcoming");
				Reporter.log("_____________________________________________________", true);

				Reporter.log("id " + jsonObj.get("id").toString() + " "
						+ jSONUtil.getTestData("id"), true);
				Assert.assertEquals(jsonObj.get("id").toString(), jSONUtil.getTestData("id"), "id");
				Reporter.log("_____________________________________________________", true);

			} catch (JSONException e) {
				e.printStackTrace();
			}

		}

	}
}
