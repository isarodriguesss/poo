public class Professor extends User{

  private String subject;
  
  public Professor(String firstName, String lastName, String username, String password, String subject) {
    super(firstName, lastName, username, password);
    this.subject = subject;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  @Override
  public String toString() {
    return "\nName: " + getFirstName() + " " + getLastName() + ", Projects Envolved: " + getProjectsEnvolved() + ", Activities Envolved: " + getActivitiesEnvolved() +
    ", Type of user: Professor, Subject: " + getSubject();
  }
}