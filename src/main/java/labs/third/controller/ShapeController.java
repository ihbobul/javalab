package labs.third.controller;

import java.util.Comparator;
import java.util.List;
import labs.third.model.Shape;

public class ShapeController {

  private final List<Shape> shapes;

  public ShapeController(List<Shape> shapes) {
    this.shapes = shapes;
  }

  public void displayShapes() {
    shapes.forEach(System.out::println);
  }

  public double calculateTotalArea() {
    return shapes.stream().mapToDouble(Shape::calcArea).sum();
  }

  public double calculateTotalAreaByType(Class<? extends Shape> shapeType) {
    return shapes.stream()
        .filter(shapeType::isInstance)
        .mapToDouble(Shape::calcArea)
        .sum();
  }

  public void sortShapesByArea() {
    shapes.sort(Comparator.comparingDouble(Shape::calcArea));
  }

  public void sortShapesByColor() {
    shapes.sort(Comparator.comparing(Shape::getShapeColor));
  }
}
