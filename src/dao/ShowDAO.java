package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.Show;

public class ShowDAO {

	final String DB_URL = "jdbc:mysql://localhost/ficherosNetflix";
	final String USER = "Irene"; // Nombre de usuario que se crea en users and privileges
	final String PASS = "irene";

	public void insertShows(Show show) {
		final String INSERT = "INSERT INTO shows VALUES ('" + show.getShow_id() + "', '" + show.getType() + "', '"
				+ show.getTitle() + "', '" + show.getDirector() + "', '" + show.getCast() + "', '" + show.getCountry()
				+ "', '" + show.getDate_added() + "', '" + show.getRelease_year() + "', '" + show.getRating() + "', '"
				+ show.getDuration() + "', '" + show.getListed_in() + "', '" + show.getDescription() + "');";

		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(INSERT);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Show> search(String searchFilter, String txtABuscar) {

		final String SELECT = "SELECT show_id, type, title, director, cast, country, date_added, release_year, rating, duration, listed_in, description from shows where "
				+ searchFilter + " like '%" + txtABuscar + "%'";
		// Hago la select con el where '" + searchFilter + "' like '%" + txtABuscar +
		// "%'";
		ArrayList<Show> showsBuscados = new ArrayList<Show>();
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT);
			while (rs.next()) {
				// Display values

				String show_id = rs.getString("show_id");
				String type = rs.getString("type");
				String title = rs.getString("title");
				String director = rs.getString("director");
				String cast = rs.getString("cast");
				String country = rs.getString("country");
				String date_added = rs.getString("date_added");
				String release_year = rs.getString("release_year");
				String rating = rs.getString("rating");
				String duration = rs.getString("duration");
				String listed_in = rs.getString("listed_in");
				String description = rs.getString("description");

				Show s = new Show(show_id, type, title, director, cast, country, date_added, release_year, rating,
						duration, listed_in, description);
				showsBuscados.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return showsBuscados;
	}

}
