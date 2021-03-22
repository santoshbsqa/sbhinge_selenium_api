package apitests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONUtil {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException, JSONException {

		JSONUtil jSONUtil = new JSONUtil();

		jSONUtil.getTestData("id");

		jSONUtil.getTestData("flight_number");

		jSONUtil.getTestData("date_utc");

		jSONUtil.getTestData("date_precision");

		jSONUtil.getTestData("date_local");

		jSONUtil.getTestData("launchpad");

		jSONUtil.getTestData("auto_update");

		jSONUtil.getTestData("launch_library_id");

		jSONUtil.getTestData("flight_number");

		jSONUtil.getTestData("name");

		jSONUtil.getTestData("date_utc");

		jSONUtil.getTestData("date_unix");

		jSONUtil.getTestData("date_local");

		jSONUtil.getTestData("date_precision");

		jSONUtil.getTestData("upcoming");

		jSONUtil.getTestData("id");

	}

	public String getTestData(String key) {
		Object obj;
		String projectPath = new File("resources").getAbsolutePath().replace("\\resources", "");
		String value = "";
		try {
			obj = new JSONParser()
					.parse(new FileReader(projectPath + "\\src\\test\\resources\\testdata\\TestData.json"));
			JSONObject jo = (JSONObject) obj;
			value = (String) jo.get(key);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return value;

	}

}
