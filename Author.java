package jdbc;

public class Author {
	
	private int auth_id;
	private String auth_name;
	private String nationality;
	private Publisher pub_id;
	
	
	public Author(int auth_id, String auth_name, String nationality, Publisher pub_id) {
		super();
		this.auth_id = auth_id;
		this.auth_name = auth_name;
		this.nationality = nationality;
		this.pub_id = pub_id;
	}

	public Author(int auth_id, String auth_name, String nationality) {
		super();
		this.auth_id = auth_id;
		this.auth_name = auth_name;
		this.nationality = nationality;
	
	}

	public int getAuth_id() {
		return auth_id;
	}


	public void setAuth_id(int auth_id) {
		this.auth_id = auth_id;
	}


	public String getAuth_name() {
		return auth_name;
	}


	public void setAuth_name(String auth_name) {
		this.auth_name = auth_name;
	}


	public String getNationality() {
		return nationality;
	}


	public void setNationality(String nationality) {
		this.nationality = nationality;
	}


	public Publisher getPub_id() {
		return pub_id;
	}


	public void setPub_id(Publisher pub_id) {
		this.pub_id = pub_id;
	}


	@Override
	public String toString() {
		return "Author [auth_id=" + auth_id + ", auth_name=" + auth_name + ", nationality=" + nationality + ", pub_id="
				+ pub_id + "]";
	}

	
}
