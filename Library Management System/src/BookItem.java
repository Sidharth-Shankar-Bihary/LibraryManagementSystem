import java.util.Date;

public class BookItem {
	private int slNo;
	private Book book;
	private boolean isAvailable;
	private String location;
	private Student issuedBy;
	private Date issuedDate;
	private Date dueDate;
	private int fine;
	
	public BookItem(Book book, int slNo) {
		this.slNo = slNo;
		this.book = book;
		this.isAvailable = true;
		this.location = null;
		this.issuedBy = null;
		this.issuedDate = null;
		this.dueDate = null;
		this.fine = 0;
		book.addBookItem(this);
	}
	
	public int getSlNo() {
		return slNo;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Student getIssuedBy() {
		return issuedBy;
	}
	public void setIssuedBy(Student issuedBy) {
		this.issuedBy = issuedBy;
	}
	public Date getIssuedDate() {
		return issuedDate;
	}
	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date date) {
		this.dueDate = date;
		System.out.println("The due date is set to: "+date);
	}
	public int getFine() {
		return fine;
	}
	public void setFine(int fine) {
		this.fine = fine;
	}
	public int calculateFine() {
		Date today = new Date();
		int dateDifference = (int) ((today.getTime() - dueDate.getTime())/1000*60*60*24);
		if(dateDifference > 0) {
			this.fine = dateDifference*10;
		}
		return fine;
	}
}
