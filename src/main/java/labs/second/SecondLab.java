package labs.second;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import labs.second.model.Student;
import labs.second.util.JsonUtility;
import labs.second.validation.InputValidator;

public class SecondLab {

  private static final List<Student> students = new ArrayList<>();
  private static final Scanner scanner = new Scanner(System.in);

  public static void run() {
    System.out.println("Welcome to the Curator's Journal System!");
    while (true) {
      System.out.println(
          "\nChoose an option:\n1. Add new student\n2. View all entries\n3. Test JSON serialization\n4. Exit");
      String choice = scanner.nextLine();

      switch (choice) {
        case "1" -> addStudent();
        case "2" -> displayEntries();
        case "3" -> testJsonSerialization();
        case "4" -> {
          System.out.println("Exiting the program. Goodbye!");
          return;
        }
        default -> System.out.println("Invalid choice. Please try again.");
      }
    }
  }

  private static void addStudent() {
    System.out.println("Enter student's first name:");
    String firstName = scanner.nextLine();

    System.out.println("Enter student's last name:");
    String lastName = scanner.nextLine();

    String birthDate = InputValidator.getValidDate(scanner);
    String phone = InputValidator.getValidPhone(scanner);

    System.out.println("Enter student's home address (street, house, apartment):");
    String address = scanner.nextLine();

    students.add(new Student(lastName, firstName, birthDate, phone, address));
    System.out.println("Student added successfully!");
  }

  private static void displayEntries() {
    if (students.isEmpty()) {
      System.out.println("No entries in the journal.");
    } else {
      System.out.println("\nCurator's Journal Entries:");
      students.forEach(System.out::println);
    }
  }

  private static void testJsonSerialization() {
    if (students.isEmpty()) {
      System.out.println("No entries available to test serialization.");
      return;
    }

    Student originalStudent = students.getFirst();
    String json = JsonUtility.toJson(originalStudent);
    System.out.println("\nSerialized JSON: " + json);

    Student deserializedStudent = JsonUtility.fromJson(json, Student.class);

    if (originalStudent.equals(deserializedStudent)) {
      System.out.println("The original and deserialized Student objects are equal.");
    } else {
      System.out.println("The original and deserialized Student objects are not equal.");
    }
  }
}
