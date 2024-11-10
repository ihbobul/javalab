package labs.seventh;

import java.util.Arrays;
import labs.seventh.filter.StringLengthFilter;

public class SeventhLab {

  public static void run() {
    System.out.println("Welcome to Seventh Lab!");

    String[] inputStrings = {"apple", "banana", "kiwi", "grape", "blueberry", "peach"};

    String[] shorterStrings = StringLengthFilter.filterStringsByLength(inputStrings, true);
    System.out.println("Strings shorter than average length: " + Arrays.toString(shorterStrings));

    String[] longerStrings = StringLengthFilter.filterStringsByLength(inputStrings, false);
    System.out.println("Strings longer than average length: " + Arrays.toString(longerStrings));
  }
}
