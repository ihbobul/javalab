package labs.third.model;

import labs.third.localization.LocalizationManager;

public class Circle extends Shape {

  private final double radius;

  public Circle(String shapeColor, double radius) {
    super(shapeColor);
    this.radius = radius;
  }

  @Override
  public double calcArea() {
    return Math.PI * radius * radius;
  }

  @Override
  public void draw() {
    System.out.println(LocalizationManager.getMessage("drawingCircle"));
  }
}
