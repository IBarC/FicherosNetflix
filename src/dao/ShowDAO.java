package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
	
	

}
