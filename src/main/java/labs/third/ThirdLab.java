package labs.third;

import java.util.ArrayList;
import java.util.List;
import labs.third.controller.ShapeController;
import labs.third.model.Circle;
import labs.third.model.Rectangle;
import labs.third.model.Shape;
import labs.third.model.Triangle;
import labs.third.view.ShapeView;

public class ThirdLab {

  public static void run() {
    List<Shape> shapes = new ArrayList<>();

    shapes.add(new Rectangle("Red", 3, 4));
    shapes.add(new Triangle("Green", 3, 5));
    shapes.add(new Circle("Blue", 5));
    shapes.add(new Rectangle("Yellow", 2, 6));
    shapes.add(new Triangle("Red", 4, 7));
    shapes.add(new Circle("Green", 3));
    shapes.add(new Rectangle("Blue", 1, 8));
    shapes.add(new Triangle("Yellow", 2, 4));
    shapes.add(new Circle("Red", 4));
    shapes.add(new Rectangle("Green", 5, 9));

    ShapeController controller = new ShapeController(shapes);
    ShapeView view = new ShapeView(controller);

    System.out.println("Welcome to the Shape Management System\n");

    view.displayAllShapes();
    System.out.println();

    view.displayTotalArea();
    System.out.println();

    view.displayTotalAreaByType(Rectangle.class);
    view.displayTotalAreaByType(Triangle.class);
    view.displayTotalAreaByType(Circle.class);
    System.out.println();

    view.displaySortedShapesByArea();
    System.out.println();

    view.displaySortedShapesByColor();
  }
}
