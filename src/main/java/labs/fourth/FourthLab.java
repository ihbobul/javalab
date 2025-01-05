package labs.fourth;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import labs.fourth.human_beings.Passenger;
import labs.fourth.human_beings.impl.Firefighter;
import labs.fourth.human_beings.impl.PoliceOfficer;
import labs.fourth.human_beings.impl.RegularPassenger;
import labs.fourth.road.Road;
import labs.fourth.vehicles.impl.Bus;
import labs.fourth.vehicles.impl.FireTruck;
import labs.fourth.vehicles.impl.PoliceCar;
import labs.fourth.vehicles.impl.Taxi;

public class FourthLab {

  public static void run() {
    Road road = new Road();

    Bus bus = new Bus("City Bus", 50);
    Taxi taxi = new Taxi("Yellow Taxi", 4);
    FireTruck fireTruck = new FireTruck("Fire Truck", 5);
    PoliceCar policeCar = new PoliceCar("Police Cruiser", 3);

    bus.addPassenger(new RegularPassenger("Alice"));
    bus.addPassenger(new Firefighter("Bob"));
    taxi.addPassenger(new PoliceOfficer("Charlie"));
    fireTruck.addPassenger(new Firefighter("Dan"));
    policeCar.addPassenger(new PoliceOfficer("Eve"));

    road.addCarToRoad(bus);
    road.addCarToRoad(taxi);
    road.addCarToRoad(fireTruck);
    road.addCarToRoad(policeCar);

    System.out.println("Total passengers on the road: " + road.getCountOfHumans());

    try {
      savePassengersToFile(bus.getPassengers());
      List<Passenger> loadedPassengers = loadPassengersFromFile();

      System.out.println("Loaded passengers from file:");
      loadedPassengers.forEach(p -> System.out.println(p.getName()));

    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  private static void savePassengersToFile(List<? extends Passenger> passengers)
      throws IOException {
    try (ObjectOutputStream oos = new ObjectOutputStream(
        new FileOutputStream("busPassengers.dat"))) {
      oos.writeObject(passengers);
    }
  }

  @SuppressWarnings("unchecked")
  private static List<Passenger> loadPassengersFromFile()
      throws IOException, ClassNotFoundException {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("busPassengers.dat"))) {
      return (List<Passenger>) ois.readObject();
    }
  }
}