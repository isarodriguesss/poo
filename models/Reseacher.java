package models;

public class Reseacher extends User{
  
  public Reseacher(String firstName, String lastName, String username, String password) {
    super(firstName, lastName, username, password);
  }

  @Override
  public String toString() {
    return "\nType of user: Reseacher" + super.toString();
  }
}