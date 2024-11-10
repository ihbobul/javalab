package labs.sixth.translator;

import java.util.Scanner;
import labs.sixth.model.Dictionary;

public class Translator {

  private final Dictionary dictionary;

  public Translator(Dictionary dictionary) {
    this.dictionary = dictionary;
  }

  public void addWordPair(String english, String ukrainian) {
    dictionary.addWordPair(english, ukrainian);
  }

  public String translatePhrase(String phrase) {
    return dictionary.translate(phrase);
  }

  public void prefillDictionary() {
    addWordPair("hello", "привіт");
    addWordPair("world", "світ");
    addWordPair("good", "добре");
    addWordPair("morning", "ранок");
    addWordPair("thank", "дякую");
    addWordPair("goodbye", "до побачення");
  }

  public void run() {
    Scanner scanner = new Scanner(System.in);

    prefillDictionary();
    System.out.println("Dictionary has been pre-filled with some words.");

    System.out.println("\nCurrent Dictionary:");
    dictionary.getDictionary().forEach((english, ukrainian) ->
        System.out.println(english + " -> " + ukrainian));

    System.out.println("\nNow, you can add more words to the dictionary.");

    while (true) {
      System.out.print("Enter English word (or type 'exit' to stop): ");
      String englishWord = scanner.nextLine();
      if (englishWord.equalsIgnoreCase("exit")) {
        break;
      }

      System.out.print("Enter Ukrainian translation: ");
      String ukrainianWord = scanner.nextLine();
      addWordPair(englishWord, ukrainianWord);
    }

    System.out.println("\nEnter a phrase in English to translate:");
    String phraseToTranslate = scanner.nextLine();
    String translatedPhrase = translatePhrase(phraseToTranslate);
    System.out.println("Translated Phrase: " + translatedPhrase);
  }
}
