import java.util.ArrayList;
import java.util.List;

public class Publisher {
	private String name;
	private String address;
	private List<Book> publishedBooks;
	
	public Publisher(String name, String address) {
		this.name = name;
		this.address = address;
		this.publishedBooks = new ArrayList<Book>();
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public List<Book> getPublishedBooks() {
		return publishedBooks;
	}
}
