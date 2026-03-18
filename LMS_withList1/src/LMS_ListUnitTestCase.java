import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LMS_ListUnitTestCase {
	Library library;

	@BeforeEach
	void setup() {
		library = new Library();
	}

	@Test
	void testSuccessfulReservation() throws BookNotAvailableException {
		Book book = new Book(1, "Learn Java", 100.1f, "auth1");
		library.books.add(book);
		library.reserve("Learn Java");
		assertEquals(STATUS.BOOKED, book.getStatus());
	}

	@Test
	void testSuccessfulRAddition() {
		library.add(1, "Java", 100f, "Author");
		assertEquals(1, library.books.size());
	}

	@Test
	void testReserveWithNullTitle() {
		Book book = new Book(2, "Learn Python", 111.2f, "auth2");
		library.books.add(book);
		assertThrows(IllegalArgumentException.class, () -> {
			library.reserve(null);
		});
	}

	@Test
	void testReserveWithEmptyTitle() {
		assertThrows(IllegalArgumentException.class, () -> {
			library.reserve("");
		});
	}

	@Test
	void testReserveWithWhitespaceTitle() {
		assertThrows(IllegalArgumentException.class, () -> {
			library.reserve("    ");
		});
	}

}
