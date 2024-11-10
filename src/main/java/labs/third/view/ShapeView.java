package labs.third.view;

import labs.third.controller.ShapeController;
import labs.third.model.Shape;

public class ShapeView {

  private final ShapeController shapeController;

  public ShapeView(ShapeController shapeController) {
    this.shapeController = shapeController;
  }

  public void displayAllShapes() {
    System.out.println("Displaying all shapes:");
    shapeController.displayShapes();
  }

  public void displayTotalArea() {
    System.out.println("Total area of all shapes: " + shapeController.calculateTotalArea());
  }

  public void displayTotalAreaByType(Class<? extends Shape> shapeType) {
    System.out.println("Total area of " + shapeType.getSimpleName() + ": " +
        shapeController.calculateTotalAreaByType(shapeType));
  }

  public void displaySortedShapesByArea() {
    System.out.println("Shapes sorted by area:");
    shapeController.sortShapesByArea();
    shapeController.displayShapes();
  }

  public void displaySortedShapesByColor() {
    System.out.println("Shapes sorted by color:");
    shapeController.sortShapesByColor();
    shapeController.displayShapes();
  }
}
