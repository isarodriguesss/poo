public class Profissional extends User{

  private String type;
  
  public Profissional(String firstName, String lastName, String username, String password, String type) {
    super(firstName, lastName, username, password);
    this.type = type;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return "\nName: " + getFirstName() + " " + getLastName() + ", Projects Envolved: " + getProjectsEnvolved() + ", Activities Envolved: " + getActivitiesEnvolved() +
    ", Type of user: Profissional (" + getType() + ")";
  }
}