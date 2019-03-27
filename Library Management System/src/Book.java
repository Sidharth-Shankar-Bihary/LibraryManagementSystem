import java.util.List;
import java.util.ArrayList;

public class Book {
	private String bookName;
	private List<Author> authors;
	private Publisher publisher;
	private Subject subject;
	private int price;
	private List<BookItem> bookItems;
	
	public Book(String bookName, List<Author> authors, Publisher publisher, Subject subject, int price) {
		this.bookName = bookName;
		this.authors = new ArrayList<Author>();
		this.authors.addAll(authors);
		this.publisher = publisher;
		this.subject = subject;
		this.price = price;
		this.bookItems = new ArrayList<BookItem>();
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getBookName() {
		return bookName;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public Subject getSubject() {
		return subject;
	}

	public List<BookItem> getBookItems() {
		return bookItems;
	}
	
	public void addBookItem(BookItem bookItem) {
		bookItems.add(bookItem);
	}
	
	public int getNumberOfBookItems() {
		return bookItems.size();
	}
}
