package labs.fifth;

public class CaesarCipher {

  public static String encrypt(String text, char keyChar) {
    int key = (int) keyChar;
    StringBuilder encryptedText = new StringBuilder();

    for (char c : text.toCharArray()) {
      char encryptedChar = (char) (c + key);
      encryptedText.append(encryptedChar);
    }

    return encryptedText.toString();
  }

  public static String decrypt(String encryptedText, char keyChar) {
    int key = (int) keyChar;
    StringBuilder decryptedText = new StringBuilder();

    for (char c : encryptedText.toCharArray()) {
      char decryptedChar = (char) (c - key);
      decryptedText.append(decryptedChar);
    }

    return decryptedText.toString();
  }
}
