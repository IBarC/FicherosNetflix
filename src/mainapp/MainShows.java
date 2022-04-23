package mainapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import dao.ShowDAO;
import models.Show;

/**
 * Clase para insertar todos los shows en la base de datos
 * 
 * @author Irene
 *
 */
public class MainShows {

	public static void main(String[] args) {
		ShowDAO showdao = new ShowDAO();
		File f = new File("netflix_titles.csv");
		Scanner sc = null;
		
		String [] trozos = new String[12];

		try {
			sc = new Scanner(f, "UTF-8");
			sc.nextLine();// cabecera

			while (sc.hasNextLine()) {
				String s = sc.nextLine();
				// var trozos = s.split(",");
				// Omite las cadenas internas ""
				trozos = s.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)", -1);

				String id = trozos[0];
				String type = trozos[1].replace('"', '^');
				String title = trozos[2].replace('"', '^');
				String director = trozos[3].replace('"', '^');
				String cast = trozos[4].replace('"', '^');
				String country = trozos[5].replace('"', '^');
				String date_added = trozos[6].replace('"', '^');
				String release_year = trozos[7].replace('"', '^');
				String rating = trozos[8].replace('"', '^');
				String duration = trozos[9].replace('"', '^');
				String listed_in = trozos[10].replace('"', '^');
				String description = trozos[11].replace('"', '^');

				Show showAInsertar = new Show(id, type, title, director, cast, country, date_added, release_year,
						rating, duration, listed_in, description);
				System.out.println(showAInsertar);
				showdao.insertShows(showAInsertar);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		sc.close();
	}

}
