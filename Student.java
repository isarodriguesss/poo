public class Student extends User{

  private String course;
  
  public Student(String firstName, String lastName, String username, String password, String course) {
    super(firstName, lastName, username, password);
    this.course = course;
  }

  public String getCourse() {
    return course;
  }

  public void setcourse(String course) {
    this.course = course;
  }

  @Override
  public String toString() {
    return "Type of user: Student, Major degree: " + getCourse() + super.toString();
  }
}