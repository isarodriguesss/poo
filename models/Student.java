package models;

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
    return "\nType of user: Student, Degree: " + getDegree() + ", " + super.toString();
  }
}