package utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import models.Show;

public class ShowsHelper {

	public void aniadirFavs(String nombreFichero, String separador, Show s) {

		try {
			File f = new File("src/assets/files/" + nombreFichero + ".csv");
			FileWriter fw = new FileWriter(f, true);
			boolean esta = false;

			String linea = s.getShow_id() + separador + s.getType() + separador + s.getTitle() + separador
					+ s.getDirector() + separador + s.getCast() + separador + s.getCountry() + separador
					+ s.getDate_added() + separador + s.getRelease_year() + separador + s.getRating() + separador
					+ s.getDuration() + separador + s.getListed_in() + separador + s.getDescription() + "\n";

			Scanner sc = null;

			sc = new Scanner(f, "UTF-8");

			if (sc.hasNextLine()) {
				while (sc.hasNextLine()) {
					String scanner = sc.nextLine();
					String[] trozos = scanner.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)", -1);
					if (trozos[0].equals(s.getShow_id())) {
						esta = true;
					}

				}
				if (!esta) {
					fw.write(linea);
				}
				fw.flush();
			} else {
				fw.write(linea);
				fw.flush();
			}
			sc.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
