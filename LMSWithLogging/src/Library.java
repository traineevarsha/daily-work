import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Library {

    private static final Logger logger = Logger.getLogger(Library.class.getName());
    List<books> booklist = new ArrayList<>();

    void addbook(books book) {
        booklist.add(book);
        logger.info("Book added: " + book.title);
    }

    void removebook(int id) {
        for (int i = 0; i < booklist.size(); i++) {
            if (booklist.get(i).id == id) {
                books removedBook = booklist.get(i);
                booklist.remove(i);
                logger.info("Book removed: " + removedBook.title);
                return;
            }
        }
        logger.warning("Book not found for removal. Id: " + id);
        throw new BookNotAvailableException("Book not found");
    }

    void reservebook(int id) {
        for (books b : booklist) {
            if (b.id == id) {
                if (!b.reserved) {
                    b.reserved = true;
                    logger.info("Book reserved: " + b.title);
                    return;
                } else {
                    logger.warning("Book already reserved: " + b.title);
                    throw new BookNotAvailableException("Book already reserved");
                }
            }
        }
        logger.warning("Book not found for reservation. Id: " + id);
        throw new BookNotAvailableException("Book not available for reservation");
    }

    void displaybooks() {
        if (booklist.isEmpty()) {
            System.out.println("No books in library");
            logger.info("Display requested but library is empty");
            return;
        }

        System.out.println("\nBooks in Library:");
        for (books b : booklist) {
            System.out.println(b);
        }
        logger.info("Displayed all books");
    }
}