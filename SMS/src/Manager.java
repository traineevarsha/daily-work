import java.util.ArrayList;

public class Manager {

	private ArrayList<Student> studentlist = new ArrayList<>();

	public void addStudent(int id, String name) {
		for (Student s : studentlist) {
			if (s.getId() == id) {
				System.out.println("id already exists");
			}
		}
		studentlist.add(new Student(id, name));
		System.out.println("Student added successfully");

	}

	public void display() {
		if (studentlist.isEmpty()) {
			System.out.println("No students enrolled");
			return;
		}
		for (Student s : studentlist) {
			System.out.println(s);
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
