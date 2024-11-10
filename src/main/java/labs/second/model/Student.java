package labs.second.model;

import java.util.Objects;

public class Student {

  private final String firstName;
  private final String lastName;
  private final String birthDate;
  private final String phone;
  private final String address;

  public Student(String firstName, String lastName, String birthDate, String phone,
      String address) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthDate = birthDate;
    this.phone = phone;
    this.address = address;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Student student = (Student) o;
    return firstName.equals(student.firstName) &&
        lastName.equals(student.lastName) &&
        birthDate.equals(student.birthDate) &&
        phone.equals(student.phone) &&
        address.equals(student.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName, birthDate, phone, address);
  }

  @Override
  public String toString() {
    return "Student: " + firstName + " " + lastName + ", Born: " + birthDate +
        ", Phone: " + phone + ", Address: " + address;
  }
}
