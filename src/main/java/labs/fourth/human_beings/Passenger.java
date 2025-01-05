package labs.fourth.human_beings;

import java.io.Serializable;

public abstract class Passenger implements Serializable {

  private String name;

  public Passenger(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}