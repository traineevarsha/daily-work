import java.util.*;
public class Library {
	List <books> booklist = new ArrayList<>();
	
	 void addbook(books book) {
		 booklist.add(book);
		 System.out.println("Book added");
	 }
	 void removebook(int id) {
		 for (books b: booklist) {
			 if(b.id == id) {
				 booklist.remove(b);
				 System.out.println("book removed");
				 return;
			 }
		 }
		 System.out.println("Book not found");
		 
	 }
	 
	 void reservebook(int id) {
		 for(books b :booklist) {
			 if(b.id == id) {
				 if(!b.reserved) {
					 b.reserved = true;
					 System.out.println("Book reserved");
				 }else {
					 System.out.println("Already reserved");
				 }
				 return;
			 }
		 }
		 System.out.println("Book not found");
	 }
	

}
