package labs.fourth.vehicles;

import labs.fourth.human_beings.Passenger;

public abstract class Car<T extends Passenger> extends Vehicle<T> {

  public Car(String name, int capacity) {
    super(name, capacity);
  }
}
