package labs.third.localization;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Scanner;

public class LocalizationManager {

  private static ResourceBundle messages;

  public static void initialize() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Select language: 1 for English, 2 for Ukrainian");
    int choice = scanner.nextInt();

    Locale locale = new Locale.Builder()
        .setLanguage(choice == 1 ? "en" : "uk")
        .setRegion(choice == 1 ? "US" : "UA")
        .build();

    try {
      messages = ResourceBundle.getBundle("location.MessagesBundle", locale);
    } catch (MissingResourceException e) {
      System.out.println("Error loading resource bundle for locale: " + locale);
    }
  }

  public static String getMessage(String key, Object... args) {
    String message = messages.getString(key);
    return String.format(message, args);
  }
}
