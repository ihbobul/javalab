package labs.fourth.vehicles.impl;

import labs.fourth.human_beings.Passenger;
import labs.fourth.vehicles.Car;

public final class Taxi extends Car<Passenger> {

  public Taxi(String name, int capacity) {
    super(name, capacity);
  }
}
