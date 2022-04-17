package utils;

import com.google.gson.JsonParser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import com.google.gson.JsonObject;

//Lee las credenciales
public class CredentialsHelper {

	private final static String appSettingsFile = "appsettings.json";

	public static String readUserDB() {
		return readFromSettingsFile("userDB");

	}
	
	public static String readPasswordrDB() {
		return readFromSettingsFile("passwordDB");

	}

	private static String readFromSettingsFile(String keyword) {
		List<String> list;

		try {
			list = Files.readAllLines(new File(appSettingsFile).toPath());

			String appsettingsContent = "";

			for (var l : list) {
				appsettingsContent += l;
			}

			JsonObject jsonObject = JsonParser.parseString(appsettingsContent).getAsJsonObject();

			System.out.println(jsonObject.get(keyword).getAsString());

			return jsonObject.get(keyword).getAsString();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null; // no es correcto del todo
	}

}
