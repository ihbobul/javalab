package labs.sixth;

import labs.sixth.model.Dictionary;
import labs.sixth.translator.Translator;

public class SixthLab {

  public static void run() {
    System.out.println("Welcome to the English to Ukrainian Translator!");

    Dictionary dictionary = new Dictionary();

    Translator controller = new Translator(dictionary);

    controller.run();
  }
}
