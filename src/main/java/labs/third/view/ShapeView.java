package labs.third.view;

import java.util.logging.Level;
import java.util.logging.Logger;
import labs.third.controller.ShapeController;
import labs.third.localization.LocalizationManager;
import labs.third.logger.LabLogger;
import labs.third.model.Shape;

public class ShapeView {

  private static final Logger logger = LabLogger.getLogger();
  private final ShapeController shapeController;

  public ShapeView(ShapeController shapeController) {
    this.shapeController = shapeController;
    logger.log(Level.INFO, "ShapeView initialized");
  }

  public void displayAllShapes() {
    shapeController.displayShapes();
  }

  public void displayTotalArea() {
    double totalArea = shapeController.calculateTotalArea();
    System.out.println(LocalizationManager.getMessage("totalArea") + " " + totalArea);
    if (totalArea == 0) {
      logger.log(Level.WARNING,
          "Missing total area for all shapes");
    }
  }

  public void displayTotalAreaByType(Class<? extends Shape> shapeType) {
    double totalArea = shapeController.calculateTotalAreaByType(shapeType);

    String localizedShapeType = LocalizationManager.getMessage(
        shapeType.getSimpleName().toLowerCase());

    String formattedArea = String.format("%.2f", totalArea);

    System.out.println(
        LocalizationManager.getMessage("totalAreaByType", localizedShapeType, formattedArea));

    if (totalArea == 0) {
      logger.log(Level.WARNING, "Missing total area for " + shapeType.getSimpleName());
    }
  }


  public void displaySortedShapesByArea() {
    shapeController.sortShapesByArea();
    shapeController.displayShapes();
  }

  public void displaySortedShapesByColor() {
    shapeController.sortShapesByColor();
    shapeController.displayShapes();
  }
}
