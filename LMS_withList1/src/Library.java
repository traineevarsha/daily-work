import java.util.ArrayList;
import java.util.List;

public class Library {
	List<Book> books = new ArrayList<>();

	void add(int id, String title, float price, String author) {
		Book book = new Book(id, title, price, author);
		books.add(book);
		System.out.println("Book added: " + title);
	}

	void reserve(String title) throws BookNotAvailableException {
		if (title == null || title.trim().isEmpty()) {
			throw new IllegalArgumentException("Title cannot be null or empty");
		}

		for (Book b : books) {
			if (b.getTitle().equalsIgnoreCase(title) && b.getStatus() == STATUS.AVAILABLE) {
				b.setStatus(STATUS.BOOKED);
				System.out.println("Book reserved: " + title);
				return;
			}
		}

		throw new BookNotAvailableException("Book is not available.");
	}

	List<Book> find(String title) {
		List<Book> foundBooks = new ArrayList<>();

		if (title == null || title.trim().isEmpty()) {
			throw new IllegalArgumentException("Title cannot be null or empty");
		}

		for (Book book : books) {
			if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
				foundBooks.add(book);
			}
		}

		return foundBooks;
	}

	Book remove(int id) throws Exception {
		if (id <= 0) {
			throw new IllegalArgumentException("Id must be positive");
		}

		for (int i = 0; i < books.size(); i++) {
			Book book = books.get(i);

			if (book.getId() == id) {
				books.remove(i);
				System.out.println("Removed book: " + book.getTitle());
				return book;
			}
		}

		throw new Exception("No book available for the id: " + id);
	}

	void displayBooks() {
		System.out.println("\nBOOKS AVAILABLE");

		boolean found = false;

		for (Book book : books) {
			if (book.getStatus() == STATUS.AVAILABLE) {
				System.out.println(book);

				found = true;
			}
		}

		if (!found) {
			System.out.println("No available books.");
		}
	}
}