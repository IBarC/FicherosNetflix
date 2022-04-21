package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import models.Usuario;

public class UsuarioDAO {
	
	final String DB_URL = "jdbc:mysql://localhost/ficherosNetflix";
	final String USER = "Irene"; // Nombre de usuario que se crea en users and privileges
	final String PASS = "irene";

	public void Consulta() {
		final String QUERY = "SELECT usersname, password from users";

		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(QUERY);) {
			while (rs.next()) {
				// Display values
				System.out.println("Username: " + rs.getString("usersname"));
				System.out.println(", Password: " + rs.getString("password"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean login(Usuario usuario) {
		final String QUERY = "SELECT username, password from users where " + "username = '" + usuario.getUsername()
				+ "' and " + "password = '" + usuario.getPassword() + "'";

		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(QUERY);) {
			return rs.next();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void register(Usuario usuario) {
		final String INSERT = "INSERT INTO users (username, password, email) VALUES ('" + usuario.getUsername() + "', '"
				+ usuario.getPassword() + "', " + usuario.getEmail() + ")";

		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(INSERT);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean buscarNombre(String usuario) {
		final String SELECT = "SELECT usersname from users where usersname = '" + usuario + "';";

		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(SELECT);) {
			return rs.next();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean buscarEmail(String email) {
		final String SELECT = "SELECT email from users where email = '" + email + "';";

		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(SELECT);) {
			return rs.next();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
}
