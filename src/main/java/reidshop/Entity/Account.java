package reidshop.Entity;

public class Account {
	int id;
	String username;
	String password;
	int role;
	public Account() {
		super();
	}
	
	public Account(int id,String username,String password,int role)
	{
		this.id=id;
		this.username=username;
		this.password = password;
		this.role = role;
	}
	public Account(String username,String password,int role)
	{

		this.username=username;
		this.password = password;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}
}
