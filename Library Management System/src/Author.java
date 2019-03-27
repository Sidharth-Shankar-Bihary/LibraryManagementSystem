import java.util.List;
import java.util.ArrayList;

public class Author {
	private String authorName;
	private List<Book> booksPublished;
	
	public Author(String authorName) {
		this.authorName = authorName;
		this.booksPublished = new ArrayList<Book>();
	}

	public String getAuthorName() {
		return authorName;
	}

	public List<Book> getBooksPublished() {
		return booksPublished;
	}
}
