package models;

public class Profissional extends User{

  public Profissional(String firstName, String lastName, String username, String password) {
    super(firstName, lastName, username, password);
  }

  @Override
  public String toString() {
    return "\nType of user: Profissional " + super.toString();
  }
}