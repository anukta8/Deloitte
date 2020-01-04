package jdbc;

//import jdbcexam.Author;
//import jdbcexam.Publisher;

public class Books {
	
	private int isbn;
	private String title;
	private int pages;
	private int pub_year;
	private String type;
	private Publisher pub;
	private Author auth;
	
	public Books(int isbn, String title, int pages, int pub_year,String type, Publisher pub, Author auth) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.pages = pages;
		this.pub_year = pub_year;
		this.type = type;
		this.pub = pub;
		this.auth = auth;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getPub_year() {
		return pub_year;
	}

	public void setPub_year(int pub_year) {
		this.pub_year = pub_year;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Publisher getPub() {
		return pub;
	}

	public void setPub(Publisher pub) {
		this.pub = pub;
	}

	public Author getAuth() {
		return auth;
	}

	public void setAuth(Author auth) {
		this.auth = auth;
	}

	@Override
	public String toString() {
		return "Books [isbn=" + isbn + ", title=" + title + ", pages=" + pages + ", pub_year=" + pub_year + ", type="
				+ type + ", pub=" + pub + ", auth=" + auth + "]";
	}

}
