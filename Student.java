public class Student extends User{

  private String degree;
  
  public Student(String firstName, String lastName, String username, String password, String degree) {
    super(firstName, lastName, username, password);
    this.degree = degree;
  }

  public String getDegree() {
    return degree;
  }

  public void setDegree(String degree) {
    this.degree = degree;
  }

  @Override
  public String toString() {
    return "\nName: " + getFirstName() + " " + getLastName() + ", Projects Envolved: " + getProjectsEnvolved() + ", Activities Envolved: " + getActivitiesEnvolved() +
    ", Type of user: Student, Degree: " + getDegree();
  }
}