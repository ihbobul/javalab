package labs.fourth.vehicles;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import labs.fourth.human_beings.Passenger;

public abstract class Vehicle<T extends Passenger> implements Serializable {

  private String name;
  private int capacity;
  private List<T> passengers = new ArrayList<>();

  public Vehicle(String name, int capacity) {
    this.name = name;
    this.capacity = capacity;
  }

  public String getName() {
    return name;
  }

  public int getCapacity() {
    return capacity;
  }

  public int getOccupiedSeats() {
    return passengers.size();
  }

  public void addPassenger(T passenger) {
    if (passengers.size() >= capacity) {
      throw new IllegalStateException("All seats are occupied in " + name);
    }
    passengers.add(passenger);
  }

  public void removePassenger(T passenger) {
    if (!passengers.remove(passenger)) {
      throw new NoSuchElementException("Passenger not found in " + name);
    }
  }

  public List<T> getPassengers() {
    return new ArrayList<>(passengers); // Defensive copy
  }
}
