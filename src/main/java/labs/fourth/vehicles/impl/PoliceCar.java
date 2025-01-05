package labs.fourth.vehicles.impl;

import labs.fourth.human_beings.impl.PoliceOfficer;
import labs.fourth.vehicles.Car;

public final class PoliceCar extends Car<PoliceOfficer> {

  public PoliceCar(String name, int capacity) {
    super(name, capacity);
  }
}
