package mainapp;

import utils.CredentialsHelper;

public class MainApp {

	public static void main(String[] args) {

		CredentialsHelper.readUserDB();
		
		CredentialsHelper.readPasswordrDB();

	}

}
