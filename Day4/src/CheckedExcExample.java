import java.io.FileNotFoundException;

import java.io.*;
public class CheckedExcExample {

	public static void main(String[] args) {
		try {
			FileReader file = new FileReader("data.txt");
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		}

	}

}
