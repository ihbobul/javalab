package labs.third.model;

import labs.third.localization.LocalizationManager;

public class Rectangle extends Shape {

  private final double width;
  private final double height;

  public Rectangle(String shapeColor, double width, double height) {
    super(shapeColor);
    this.width = width;
    this.height = height;
  }

  @Override
  public double calcArea() {
    return width * height;
  }

  @Override
  public void draw() {
    System.out.println(LocalizationManager.getMessage("drawingRectangle"));
  }
}
