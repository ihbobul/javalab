package labs.fourth.vehicles.impl;

import labs.fourth.human_beings.impl.Firefighter;
import labs.fourth.vehicles.Car;

public final class FireTruck extends Car<Firefighter> {

  public FireTruck(String name, int capacity) {
    super(name, capacity);
  }
}
