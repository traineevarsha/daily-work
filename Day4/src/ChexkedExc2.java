
	import java.io.FileNotFoundException;
	import java.io.*;
	public class ChexkedExc2 {
		public static void main(String[] args) {
			try {
				readFile();
			} catch (FileNotFoundException e) {
				System.out.println("File Not Found");
			}

		}

		private static void readFile() throws FileNotFoundException {
			FileReader file = new FileReader("data.txt");
		}

	}
