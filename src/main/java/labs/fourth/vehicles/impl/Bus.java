package labs.fourth.vehicles.impl;

import labs.fourth.human_beings.Passenger;
import labs.fourth.vehicles.Vehicle;

public class Bus extends Vehicle<Passenger> {

  public Bus(String name, int capacity) {
    super(name, capacity);
  }
}
