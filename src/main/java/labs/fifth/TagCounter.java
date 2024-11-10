package labs.fifth;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class TagCounter {

  public void countTags(String url) {
    try {
      Document doc = Jsoup.connect(url).get();
      Elements elements = doc.select("*");

      Map<String, Integer> tagCountMap = new HashMap<>();

      for (org.jsoup.nodes.Element element : elements) {
        String tagName = element.tagName();
        tagCountMap.put(tagName, tagCountMap.getOrDefault(tagName, 0) + 1);
      }

      System.out.println("Tags sorted lexicographically:");
      tagCountMap.keySet().stream()
          .sorted()
          .forEach(tag -> System.out.println(tag + ": " + tagCountMap.get(tag)));

      System.out.println("\nTags sorted by frequency:");
      tagCountMap.entrySet().stream()
          .sorted(Entry.comparingByValue())
          .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
