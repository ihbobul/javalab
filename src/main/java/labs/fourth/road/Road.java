package labs.fourth.road;

import java.util.ArrayList;
import java.util.List;
import labs.fourth.vehicles.Vehicle;

public final class Road {

  private List<Vehicle<?>> carsOnRoad = new ArrayList<>();

  public void addCarToRoad(Vehicle<?> vehicle) {
    carsOnRoad.add(vehicle);
  }

  public int getCountOfHumans() {
    return carsOnRoad.stream()
        .mapToInt(vehicle -> vehicle.getOccupiedSeats())
        .sum();
  }
}