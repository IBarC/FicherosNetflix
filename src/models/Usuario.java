package models;

public class Usuario {
	
	private int id;
	private String password;
	private String email;
	
	
	public Usuario(String password, String email) {
		super();
		this.password = password;
		this.email = email;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", password=" + password + ", email=" + email +"]";
	}
}
