import java.util.ArrayList;
import java.util.List;

class Book {
	String title;
	boolean available;
	double price;

	Book(String title) {
		this.title = title;
		this.available = true;
		this.price = price;

	}
}

class Library {

	List<Book> books = new ArrayList<>();

	void addBook(String title) {
		books.add(new Book(title));
	}

	void borrowBook(String title) {
		for (Book b : books) {
			if (b.title.equals(title) && b.available) {
				b.available = false;
				System.out.println("Borrowed: " + title);
				return;
			}
		}
		System.out.println("Book not available");
	}

	void displayBooks() {
		for (Book b : books)
			if (b.available)
				System.out.println(b.title);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
