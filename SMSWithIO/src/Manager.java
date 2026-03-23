import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Manager {

	private ArrayList<Student> studentlist = new ArrayList<>();

	public void addStudent(int id, String name) {
		for (Student s : studentlist) {
			if (s.getId() == id) {
				System.out.println("Id already exists");
				return;
			}
		}
		try {
			FileWriter writer = new FileWriter("students.txt", true);
			writer.write(id + " , " + name + "\n");
			writer.close();
			System.out.println("Added student to file successfully");
		} catch (IOException e) {
			System.out.println("File not found");
		}
		studentlist.add(new Student(id, name));
		System.out.println("Student added successfully");

	}

	public void display() {
		try {
			readFile();
		} catch (IOException ex) {
			System.out.println("File not found");
		}
		for (Student s : studentlist) {
			System.out.println(s);
		}
	}

	private void readFile() throws IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader("students.txt"))) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException exc) {
			System.out.println(exc.getMessage());
		}

	}

	public void searchStudent(int id) {
		for (Student s : studentlist) {
			if (s.getId() == id) {
				System.out.println("Student found )" + s);
				return;
			}
		}
		System.out.println("Student not found");
	}

	public void removeStudent(int id) {
		boolean removed = studentlist.removeIf(s -> s.getId() == id);
		if (removed) {
			System.out.println("Successfully removed");
		} else {
			System.out.println("Student not found");
		}
	}

}
