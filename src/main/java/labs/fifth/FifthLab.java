package labs.fifth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class FifthLab {

  public static void run() {
    System.out.println("Welcome to the Fifth Lab!");

    // Task 1: Read the file and find the line with maximum number of words
    String filePath = "input.txt";  // Replace with actual file path
    String maxWordsLine = getMaxWordsLine(filePath);
    System.out.println("Line with maximum number of words: " + maxWordsLine);

    // Task 2: Caesar Cipher encryption and decryption
    String textToEncrypt = "Hello, World!";
    char keyChar = 'K';
    String encryptedText = CaesarCipher.encrypt(textToEncrypt, keyChar);
    System.out.println("Encrypted Text: " + encryptedText);
    String decryptedText = CaesarCipher.decrypt(encryptedText, keyChar);
    System.out.println("Decrypted Text: " + decryptedText);

    // Task 3: Count HTML tags from a URL
    String url = "https://www.example.com";
    TagCounter tagCounter = new TagCounter();
    tagCounter.countTags(url);
  }

  // Task 1: Get line with maximum number of words from the file
  public static String getMaxWordsLine(String filePath) {
    String maxWordsLine = "";
    int maxWords = 0;

    // Accessing file from resources folder
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(
        Objects.requireNonNull(FifthLab.class.getClassLoader().getResourceAsStream(filePath))))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] words = line.split("\\s+");
        if (words.length > maxWords) {
          maxWords = words.length;
          maxWordsLine = line;
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return maxWordsLine;
  }


}
