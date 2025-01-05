package labs.third.model;

import labs.third.localization.LocalizationManager;

public abstract class Shape implements Drawable {

  private String shapeColor;

  public Shape(String shapeColor) {
    this.shapeColor = shapeColor;
  }

  public String getShapeColor() {
    return shapeColor;
  }

  public abstract double calcArea();

  @Override
  public String toString() {
    String area = String.format("%.2f", calcArea());

    String localizedShape = LocalizationManager.getMessage(
        getClass().getSimpleName().toLowerCase());

    String localizedColor = LocalizationManager.getMessage(shapeColor.toLowerCase());

    return LocalizationManager.getMessage("shapeInfo", localizedShape, localizedColor, area);
  }
}
