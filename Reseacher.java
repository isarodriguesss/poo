public class Reseacher extends User{

  private String subject;
  
  public Reseacher(String firstName, String lastName, String username, String password, String subject) {
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
    return "Type of user: Reseacher, Subject: " + getSubject() + super.toString();
  }
}