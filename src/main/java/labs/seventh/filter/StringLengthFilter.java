package labs.seventh.filter;

import java.util.Arrays;

public class StringLengthFilter {

  public static String[] filterStringsByLength(String[] strings, boolean shorterThanAverage) {
    double averageLength = Arrays.stream(strings)
        .mapToInt(String::length)
        .average()
        .orElse(0);

    return Arrays.stream(strings)
        .filter(s -> (shorterThanAverage ? s.length() < averageLength : s.length() > averageLength))
        .toArray(String[]::new);
  }
}
