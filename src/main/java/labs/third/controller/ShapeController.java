package labs.third.controller;

import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import labs.third.localization.LocalizationManager;
import labs.third.logger.LabLogger;
import labs.third.model.Shape;

public class ShapeController {

  private static final Logger logger = LabLogger.getLogger();
  private final List<Shape> shapes;

  public ShapeController(List<Shape> shapes) {
    this.shapes = shapes;
    logger.log(Level.INFO, "ShapeController initialized with " + shapes.size() + " shapes");
  }

  public void displayShapes() {
    if (shapes.isEmpty()) {
      logger.log(Level.WARNING, "Attempted to display shapes, but the list is empty.");
    } else {
      logger.log(Level.INFO, "Displaying all shapes");
      shapes.forEach(System.out::println);
    }
  }

  public double calculateTotalArea() {
    double totalArea = shapes.stream().mapToDouble(Shape::calcArea).sum();
    logger.log(Level.INFO, "Total area calculated: " + totalArea);
    return totalArea;
  }

  public double calculateTotalAreaByType(Class<? extends Shape> shapeType) {
    double totalArea = shapes.stream()
        .filter(shapeType::isInstance)
        .mapToDouble(Shape::calcArea)
        .sum();

    String localizedShapeType = LocalizationManager.getMessage(
        shapeType.getSimpleName().toLowerCase());
    String formattedArea = String.format("%.2f", totalArea);

    if (totalArea == 0) {
      logger.log(Level.WARNING, "Missing total area for " + shapeType.getSimpleName());
    } else {
      String message = "Total area for " + shapeType.getSimpleName() + ": " + formattedArea;
      logger.log(Level.INFO, message);
    }

    return totalArea;
  }


  public void sortShapesByArea() {
    if (shapes.isEmpty()) {
      logger.log(Level.WARNING, "Attempted to sort shapes by area, but the list is empty.");
    } else {
      shapes.sort(Comparator.comparingDouble(Shape::calcArea));
      logger.log(Level.INFO, "Shapes sorted by area");
    }
  }

  public void sortShapesByColor() {
    if (shapes.isEmpty()) {
      logger.log(Level.WARNING, "Attempted to sort shapes by color, but the list is empty.");
    } else {
      shapes.sort(Comparator.comparing(Shape::getShapeColor));
      logger.log(Level.INFO, "Shapes sorted by color");
    }
  }
}
