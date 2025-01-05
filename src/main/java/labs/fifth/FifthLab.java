package labs.fifth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class FifthLab {

  public static void run() {
    System.out.println("Welcome to the Fifth Lab!");

    String filePath = "input.txt";
    String maxWordsLine = getMaxWordsLine(filePath);
    System.out.println("Line with maximum number of words: " + maxWordsLine);

    String textToEncrypt = "Hello, World!";
    char keyChar = 'K';
    String encryptedText = CaesarCipher.encrypt(textToEncrypt, keyChar);
    System.out.println("Encrypted Text: " + encryptedText);
    String decryptedText = CaesarCipher.decrypt(encryptedText, keyChar);
    System.out.println("Decrypted Text: " + decryptedText);

    String url = "https://www.example.com";
    TagCounter tagCounter = new TagCounter();
    tagCounter.countTags(url);
  }

  public static String getMaxWordsLine(String filePath) {
    String maxWordsLine = "";
    int maxWords = 0;

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
