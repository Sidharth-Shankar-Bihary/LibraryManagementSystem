import java.util.List;
import java.util.ArrayList;

public class Student {
	private int rollNo;
	private String name;
	private List<BookItem> booksIssued;
	private int fine;
	
	public Student(int rollNo, String name) {
		this.rollNo = rollNo;
		this.name = name;
		this.booksIssued = new ArrayList<BookItem>();
		this.fine = 0;
	}

	public int getFine() {
		return fine;
	}

	public void setFine(int fine) {
		this.fine = fine;
	}

	public int getRollNo() {
		return rollNo;
	}

	public String getName() {
		return name;
	}

	public List<BookItem> getBooksIssued() {
		return booksIssued;
	}
	
}
