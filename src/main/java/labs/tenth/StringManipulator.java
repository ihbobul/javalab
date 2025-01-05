package labs.tenth;

import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class StringManipulator {

  public static void manipulateString() {
    try {
      // Create and display a literal string
      String literalString = "Original Literal";
      System.out.println("Before change (Literal): " + literalString);

      // Modify the literal string value using reflection
      changeStringValue(literalString, "Modified Literal");
      System.out.println("After change (Literal): " + literalString);

      // Get user input string
      Scanner scanner = new Scanner(System.in);
      System.out.print("Enter a string to initialize: ");
      String userInputString = scanner.nextLine();
      System.out.println("Before change (User input): " + userInputString);

      // Get new value from user input for modification
      System.out.print("Enter a new value for the string: ");
      String newUserInputValue = scanner.nextLine();
      changeStringValue(userInputString, newUserInputValue);
      System.out.println("After change (User input): " + userInputString);

      scanner.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static void changeStringValue(String target, String newValue) throws Exception {
    // Access the "value" field in the String class
    Field valueField = String.class.getDeclaredField("value");
    valueField.setAccessible(true);

    // Check if the "value" field is of type byte[] or char[] and set accordingly
    if (valueField.getType() == byte[].class) {
      // Convert the new value to byte[] using the default charset
      byte[] newValueBytes = newValue.getBytes(StandardCharsets.UTF_8);
      valueField.set(target, newValueBytes);
    } else if (valueField.getType() == char[].class) {
      // Convert the new value to char[] (for older Java versions)
      char[] newValueChars = newValue.toCharArray();
      valueField.set(target, newValueChars);
    }
  }
}
