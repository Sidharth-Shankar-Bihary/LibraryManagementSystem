import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class Library {
	private String address;
	private List<Book> books;
	private int numberofBookItems = 0;
	
	public Library(String address) {
		this.address = address;
		this.books = new ArrayList<Book>();
	}


	public List<Book> getBooks() {
		return books;
	}
	
	public void addBook(Book book) {
		books.add(book);
		book.getPublisher().getPublishedBooks().add(book);
		for(Author a : book.getAuthors()) {
			a.getBooksPublished().add(book);
		}
	}
	
	public void addBookItems(Book book, int numberOfBookItems) {
		for(int i = 0;i<numberOfBookItems;i++) {
			BookItem bI = new BookItem(book,++numberofBookItems);
		}
	}
	
	public void printAvailableBooks() {
		System.out.println("All the books available in library are as follows:");
		for(Book book : books) {
			if(book.getNumberOfBookItems() > 0) {
				System.out.print("Name: "+book.getBookName()+", Authors: ");
				for(Author a: book.getAuthors()) {
					System.out.print(a.getAuthorName()+ ", ");
				}
				System.out.println("Publisher: "+ book.getPublisher().getName() +", No. of books available: "+book.getNumberOfBookItems());
			}	
		}
	}
	
	public void issueBookItem(Book book, Student student) {
		if(student.getBooksIssued().size() < 5) {
			
			for(BookItem bI : student.getBooksIssued()) {
				if(bI.getBook().equals(book)) {
					System.out.println("Sorry, "+student.getName()+" has already issued "+book.getBookName());
					return;
				}
			}
			
			for(Book b : books) {
				if(b.equals(book)) {
					if(b.getNumberOfBookItems() == 0) {
						System.out.println("Sorry, the book "+b.getBookName()+" is not available.");
						break;
					}else {
						for(BookItem bI : b.getBookItems()) {
							if(bI.isAvailable()) {
								student.getBooksIssued().add(bI);
								bI.setIssuedBy(student);
								bI.setIssuedDate(new Date());
								bI.setDueDate(new Date(new Date().getTime()+10*24*60*60*1000));
								bI.setAvailable(false);
								b.getBookItems().remove(bI);
							}
							System.out.println("The book "+b.getBookName()+" is issued to "+student.getName());
							break;
						}					
					}
				}
			}
		}else {
			System.out.println("Sorry, "+student.getName()+" has exceeded the maximum limit of 5 books.");
		}
		
	}
	
	public void returnBookItem(Student student, Book book) {
		for(BookItem bI : student.getBooksIssued()) {
			if(bI.getBook().equals(book)) {
				int fineCollected = bI.calculateFine();
				if(fineCollected > 0) {
					System.out.println("Rs."+fineCollected+" has been collected from "+student.getName());
				}
				student.getBooksIssued().remove(bI);
				bI.setAvailable(true);
				bI.setDueDate(null);
				bI.setFine(0);
				bI.setIssuedBy(null);
				bI.setIssuedDate(null);
				bI.getBook().getBookItems().add(bI);
				System.out.println(student.getName()+" has submitted "+book.getBookName()+" and it has been added back to the library.");
			}
		}
		
	}
	
	public void printBooksIssuedByStudent(Student student) {
		System.out.println("The books issued by "+student.getName()+" are: ");
		for(BookItem bk : student.getBooksIssued()) {
			System.out.println(bk.getBook().getBookName()+", Due date: "+bk.getDueDate());
		}
		
	}
	
	public void searchBookByAuthor(Author author) {
		System.out.println("");
		System.out.println("The books published by "+author.getAuthorName()+" are: ");
		for(Book b :author.getBooksPublished()) {
			System.out.print(b.getBookName()+", ");
		}
		
	}
	
	public void searchBookByPublisher(Publisher publisher) {
		System.out.println("");
		System.out.println("The books published by "+publisher.getName()+" are: ");
		for(Book b : publisher.getPublishedBooks()) {
			System.out.print(b.getBookName()+", ");
		}
	}
	
	public void searchBookBySubject(Subject sub) {
		System.out.println("");
		System.out.println("The books in "+sub+" are: ");
		for(Book b : getBooks()) {
			if(b.getSubject().equals(sub)) {
				System.out.print(b.getBookName()+", ");
			}
		}
		
	}
	
}
