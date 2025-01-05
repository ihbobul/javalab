package labs.third.logger;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LabLogger {

  private static final Logger logger = Logger.getLogger(LabLogger.class.getName());

  static {
    try {
      ConsoleHandler consoleHandler = new ConsoleHandler();
      consoleHandler.setLevel(Level.WARNING);
      logger.addHandler(consoleHandler);

      FileHandler fileHandler = new FileHandler("third_lab.log", true);
      fileHandler.setLevel(Level.ALL);
      fileHandler.setFormatter(new SimpleFormatter());
      logger.addHandler(fileHandler);

      logger.setUseParentHandlers(false);

    } catch (IOException e) {
      logger.log(Level.SEVERE, "Error initializing logger", e);
    }
  }

  public static Logger getLogger() {
    return logger;
  }
}
