package labs.fourth.vehicles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;
import labs.fourth.human_beings.impl.Firefighter;
import labs.fourth.human_beings.impl.PoliceOfficer;
import labs.fourth.human_beings.impl.RegularPassenger;
import labs.fourth.vehicles.impl.Bus;
import labs.fourth.vehicles.impl.FireTruck;
import labs.fourth.vehicles.impl.Taxi;
import org.junit.jupiter.api.Test;

class VehicleTest {

  @Test
  void givenBus_whenAddingAnyPassenger_thenPassengerIsAdded() {
    Bus bus = new Bus("City Bus", 3);

    bus.addPassenger(new RegularPassenger("Alice"));
    bus.addPassenger(new Firefighter("Bob"));
    bus.addPassenger(new PoliceOfficer("Charlie"));

    assertEquals(3, bus.getOccupiedSeats());
    assertThrows(IllegalStateException.class, () -> bus.addPassenger(new RegularPassenger("Dave")));
  }

  @Test
  void givenFireTruck_whenAddingFirefighter_thenFirefighterIsAdded() {
    FireTruck fireTruck = new FireTruck("Fire Truck", 2);

    fireTruck.addPassenger(new Firefighter("Dan"));
    fireTruck.addPassenger(new Firefighter("Eve"));

    assertEquals(2, fireTruck.getOccupiedSeats());
    assertThrows(IllegalStateException.class,
        () -> fireTruck.addPassenger(new Firefighter("Frank")));
  }

  @Test
  void givenTaxi_whenAddingAnyPassenger_thenPassengerIsAdded() {
    Taxi taxi = new Taxi("Yellow Taxi", 1);

    taxi.addPassenger(new RegularPassenger("Alice"));

    assertEquals(1, taxi.getOccupiedSeats());
    assertThrows(IllegalStateException.class, () -> taxi.addPassenger(new RegularPassenger("Bob")));
  }

  @Test
  void givenVehicle_whenExceedingCapacity_thenExceptionIsThrown() {
    Bus bus = new Bus("City Bus", 1);

    bus.addPassenger(new RegularPassenger("Alice"));

    assertThrows(IllegalStateException.class, () -> bus.addPassenger(new RegularPassenger("Bob")));
  }

  @Test
  void givenBus_whenRemovingPassenger_thenPassengerIsRemoved() {
    Bus bus = new Bus("City Bus", 3);
    RegularPassenger passenger1 = new RegularPassenger("Alice");
    Firefighter passenger2 = new Firefighter("Bob");

    bus.addPassenger(passenger1);
    bus.addPassenger(passenger2);

    bus.removePassenger(passenger1);

    assertEquals(1, bus.getOccupiedSeats());
    assertThrows(NoSuchElementException.class,
        () -> bus.removePassenger(passenger1));
  }

  @Test
  void givenBus_whenGettingCapacity_thenCorrectCapacityIsReturned() {
    Bus bus = new Bus("City Bus", 3);

    assertEquals(3, bus.getCapacity());
  }

  @Test
  void givenBus_whenGettingOccupiedSeats_thenCorrectNumberOfOccupiedSeatsIsReturned() {
    Bus bus = new Bus("City Bus", 3);
    RegularPassenger passenger1 = new RegularPassenger("Alice");
    Firefighter passenger2 = new Firefighter("Bob");

    bus.addPassenger(passenger1);
    bus.addPassenger(passenger2);

    assertEquals(2, bus.getOccupiedSeats());
  }

  @Test
  void givenFireTruck_whenRemovingPassenger_thenPassengerIsRemoved() {
    FireTruck fireTruck = new FireTruck("Fire Truck", 2);

    Firefighter passenger1 = new Firefighter("Dan");
    Firefighter passenger2 = new Firefighter("Eve");

    fireTruck.addPassenger(passenger1);
    fireTruck.addPassenger(passenger2);

    fireTruck.removePassenger(passenger1);

    assertEquals(1, fireTruck.getOccupiedSeats());
    assertThrows(NoSuchElementException.class, () -> fireTruck.removePassenger(
        passenger1));
  }

  @Test
  void givenTaxi_whenGettingCapacity_thenCorrectCapacityIsReturned() {
    Taxi taxi = new Taxi("Yellow Taxi", 1);

    assertEquals(1, taxi.getCapacity());
  }

  @Test
  void givenTaxi_whenGettingOccupiedSeats_thenCorrectNumberOfOccupiedSeatsIsReturned() {
    Taxi taxi = new Taxi("Yellow Taxi", 1);
    RegularPassenger passenger1 = new RegularPassenger("Alice");

    taxi.addPassenger(passenger1);

    assertEquals(1, taxi.getOccupiedSeats());
  }
}

