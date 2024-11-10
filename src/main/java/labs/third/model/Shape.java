package labs.third.model;

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
    return getClass().getSimpleName() + " of color " + shapeColor + " with area: " + calcArea();
  }
}
