package jdbc;

public class Users {
	
	private int user_id;
	private String first_name;
	private String username;
	private String email;
	private String password;
	private Roles role_id;
	private long phone_no;
	
	public Users(int user_id, String first_name, String username, String email, String password, Roles role_id,
			long phone_no) {
		super();
		this.user_id = user_id;
		this.first_name = first_name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.role_id = role_id;
		this.phone_no = phone_no;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Roles getRole_id() {
		return role_id;
	}

	public void setRole_id(Roles role_id) {
		this.role_id = role_id;
	}

	public long getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(long phone_no) {
		this.phone_no = phone_no;
	}

	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", first_name=" + first_name + ", username=" + username + ", email="
				+ email + ", password=" + password + ", role_id=" + role_id + ", phone_no=" + phone_no + "]";
	}

}
