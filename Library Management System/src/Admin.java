import java.util.ArrayList;
import java.util.List;

public class Admin {
	public static void main(String[] args) {
		Library library = new Library(" ");
		Publisher bharatiBhawan = new Publisher("Bharti bhawan", "New Delhi");
		Author hcVerma = new Author("H C Verma");
		List<Author> list_hcVerma = new ArrayList<Author>();
		list_hcVerma.add(hcVerma);
		Book conceptOfPhysics = new Book("Concepts of Physics", list_hcVerma , bharatiBhawan, Subject.Physics, 150);
		Publisher mirPublishers = new Publisher("Mir Publishers", "Russia");
		Author ieIrodov = new Author("I E Irodov");
		List<Author> list_ieIrodov = new ArrayList<Author>();
		list_ieIrodov.add(ieIrodov);
		Book problemsInGeneralPhysics = new Book("Problems in General Physics", list_ieIrodov , mirPublishers, Subject.Physics, 250);
		library.addBook(conceptOfPhysics);
		library.addBookItems(conceptOfPhysics, 25);
		library.addBook(problemsInGeneralPhysics);
		library.addBookItems(problemsInGeneralPhysics,50);
		library.printAvailableBooks();
		
		Student avi = new Student(1, "Avinash");
		Student sid = new Student(2, "Sidharth");
		library.issueBookItem(conceptOfPhysics, avi);
		library.issueBookItem(conceptOfPhysics, avi);
		library.issueBookItem(conceptOfPhysics, avi);
		library.issueBookItem(problemsInGeneralPhysics, avi);
		library.issueBookItem(problemsInGeneralPhysics, avi);
		library.issueBookItem(problemsInGeneralPhysics, avi);
		library.issueBookItem(conceptOfPhysics, sid);
		
		library.printAvailableBooks();
//		library.addBookItems(conceptOfPhysics, 2);
		
//		library.printAvailableBooks();
		
		library.printBooksIssuedByStudent(avi);
		
		library.returnBookItem(avi, conceptOfPhysics);
		
		library.printBooksIssuedByStudent(avi);
		
		library.printAvailableBooks();
		
		library.searchBookByAuthor(hcVerma);
		library.searchBookByAuthor(ieIrodov);
		
		library.searchBookByPublisher(bharatiBhawan);
		library.searchBookByPublisher(mirPublishers);
		
		library.searchBookBySubject(Subject.Physics);
		
	}
}
