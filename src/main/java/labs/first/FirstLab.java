package labs.first;

import java.util.ArrayList;
import java.util.List;

public class FirstLab {

  public static String[] filterStrings(String[] strings, boolean isGreater) {
    var totalLength = 0;
    for (var string : strings) {
      totalLength += string.length();
    }
    var averageLength = totalLength / strings.length;
    List<String> filteredStrings = new ArrayList<>();

    for (var string : strings) {
      if (isGreater) {
        if (string.length() > averageLength) {
          filteredStrings.add(string);
        }
      } else {
        if (string.length() < averageLength) {
          filteredStrings.add(string);
        }
      }
    }

    return filteredStrings.toArray(String[]::new);
  }

  public static void run() {
    var strings = new String[]{"Hello", "World", "Java", "Programming"};

    var filteredStrings = filterStrings(strings, true);

    System.out.println("Strings with length greater than average:");

    for (var string : filteredStrings) {
      System.out.println(string);
    }

    System.out.println("Strings with length less than average:");

    filteredStrings = filterStrings(strings, false);

    for (var string : filteredStrings) {
      System.out.println(string);
    }

  }
}
