package labs.sixth.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Dictionary {

  private final Map<String, String> dictionary;

  public Dictionary() {
    this.dictionary = new HashMap<>();
  }

  public void addWordPair(String englishWord, String ukrainianWord) {
    if (englishWord == null || englishWord.isEmpty() || ukrainianWord == null
        || ukrainianWord.isEmpty()) {
      throw new IllegalArgumentException("Words cannot be null or empty.");
    }
    dictionary.put(englishWord, ukrainianWord);
  }

  public String translate(String phrase) {
    String[] words = phrase.split("\\s+");
    StringBuilder translatedPhrase = new StringBuilder();

    for (String word : words) {
      String translatedWord = dictionary.get(word.toLowerCase());
      translatedPhrase.append(Objects.requireNonNullElse(translatedWord, word)).append(" ");
    }
    return translatedPhrase.toString().trim();
  }

  public Map<String, String> getDictionary() {
    return dictionary;
  }
}
