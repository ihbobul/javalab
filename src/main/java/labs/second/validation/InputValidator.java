package labs.second.validation;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputValidator {

  public static String getValidDate(Scanner scanner) {
    String birthDate;
    while (true) {
      System.out.println("Enter student's birth date (YYYY-MM-DD):");
      birthDate = scanner.nextLine();
      if (Pattern.matches("\\d{4}-\\d{2}-\\d{2}", birthDate)) {
        return birthDate;
      } else {
        System.out.println("Invalid birth date format. Please try again.");
      }
    }
  }

  public static String getValidPhone(Scanner scanner) {
    String phone;
    while (true) {
      System.out.println("Enter student's phone number (e.g., +380XXXXXXXXX):");
      phone = scanner.nextLine();
      if (Pattern.matches("\\+380\\d{9}", phone)) {
        return phone;
      } else {
        System.out.println("Invalid phone number format. Please try again.");
      }
    }
  }
}
