import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Library {

    List<books> booklist = new ArrayList<>();

    void addBook(int id, String title, String author, float price) {

        books book = new books(id, title, author, price);
        booklist.add(book);

        try {
            FileWriter writer = new FileWriter("books.txt", true);
            writer.write(id + "," + title + "," + author + "," + price + "\n");
            writer.close();

            System.out.println("Book added to file successfully");

        } catch (IOException e) {
            System.out.println("Error writing to file");
        }
    }

    void removebook(int id) {

        for (int i = 0; i < booklist.size(); i++) {

            if (booklist.get(i).id == id) {

                books removedBook = booklist.get(i);
                booklist.remove(i);

                System.out.println("Book removed: " + removedBook.title);
                return;
            }
        }

        System.out.println("Book not found");
    }

    void reservebook(int id) {

        for (books b : booklist) {

            if (b.id == id) {

                if (!b.reserved) {
                    b.reserved = true;
                    System.out.println("Book reserved: " + b.title);
                } else {
                    System.out.println("Book already reserved");
                }

                return;
            }
        }

        System.out.println("Book not found");
    }

    void displaybooks() {
    	try {
    		readFile();
		} catch (IOException e) {
			e.printStackTrace();
	
        }
    }

	private void readFile()throws IOException {
		   BufferedReader reader = new BufferedReader(new FileReader("books.txt"));

	        String line;

	        System.out.println("\nBooks in Library:");

	        while ((line = reader.readLine()) != null) {
	            System.out.println(line);
	        }

	        reader.close();
	}
}