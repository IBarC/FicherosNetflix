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

	public boolean loginEmail(Usuario usuario) {
		final String QUERY = "SELECT email, password from users where " + "email = '" + usuario.getEmail() + "' and "
				+ "password = '" + usuario.getPassword() + "'";

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
		final String INSERT = "INSERT INTO users (password, email) VALUES ('" + usuario.getPassword() + "', '"
				+ usuario.getEmail() + "')";

		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(INSERT);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertCode(String code, String email) {
		final String INSERT = "UPDATE users SET id = '" + code + "' WHERE email = '" + email + "'";

		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(INSERT);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean buscarCodigo(String email) {
		final String SELECT = "SELECT id from users where email = '" + email + "';";

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
