package jdbc;

//

public class Publisher {
	
	private int pub_id;
	private String pub_name;
	private String city;
	private Author auth_id;
	
	public Publisher(int pub_id, String pub_name, String city, Author auth_id) {
		super();
		this.pub_id = pub_id;
		this.pub_name = pub_name;
		this.city = city;
		this.auth_id = auth_id;
	}

	
	public Publisher(int pub_id, String pub_name, String city) {
		super();
		this.pub_id = pub_id;
		this.pub_name = pub_name;
		this.city = city;
	}
	public int getPub_id() {
		return pub_id;
	}

	public void setPub_id(int pub_id) {
		this.pub_id = pub_id;
	}

	public String getPub_name() {
		return pub_name;
	}

	public void setPub_name(String pub_name) {
		this.pub_name = pub_name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Author getAuth_id() {
		return auth_id;
	}

	public void setAuth_id(Author auth_id) {
		this.auth_id = auth_id;
	}

	@Override
	public String toString() {
		return "Publisher [pub_id=" + pub_id + ", pub_name=" + pub_name + ", city=" + city + ", auth_id=" + auth_id
				+ "]";
	}
	
}
