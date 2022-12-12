package models;

public class Professor extends User{

  public Professor(String firstName, String lastName, String username, String password) {
    super(firstName, lastName, username, password);
  }


  @Override
  public String toString() {
    return "\nType of user: Professor " + super.toString();
  }
}