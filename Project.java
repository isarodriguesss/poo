import java.util.ArrayList;

public class Project {

  private String id;
  private String description;
  private String startAt;
  private String endAt;
  private String coordinator;
  private ArrayList<User> integrants;
  private ArrayList<Activities> activities;
  private double schoolarAmount;
  private String duringAt;

  public Project(String id, String description, String startAt, String endAt, String coordinator, 
  ArrayList<User> integrants, ArrayList<Activities> activities, double schoolarAmount, String duringAt) {
    this.id = id;
    this.description = description;
    this.startAt = startAt;
    this.endAt = endAt;
    this.coordinator = coordinator;
    this.integrants = integrants;
    this.activities = activities;
    this.schoolarAmount = schoolarAmount;
    this.duringAt = duringAt;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getStartAt() {
    return startAt;
  }

  public void setStartAt(String startAt) {
    this.startAt =startAt;
  }

  public String getEndAt() {
    return endAt;
  }

  public void setEndAt(String endAt) {
    this.endAt = endAt;
  }

  public String getCoordinator() {
    return coordinator;
  }

  public void setCoordinator(String coordinator) {
    this.coordinator = coordinator;
  }

  public ArrayList<User> getIntegrants() {
    return integrants;
  }

  public String getIntegrantsUsername() {
    for (User user : integrants) {
      return user.getUsername();
    }
    return null;
  }

  public void setIntegrants(ArrayList<User> integrants) {
    this.integrants = integrants;
  }

  public ArrayList<Activities> getActivities() {
    return activities;
  }

  public void setActivities(ArrayList<Activities> activities) {
    this.activities = activities;
  }

  public double getSchoolarAmount() {
    return schoolarAmount;
  }

  public void setSchoolarAmount(double schoolarAmount) {
    this.schoolarAmount = schoolarAmount;
  }

  public String getDuringAt() {
    return duringAt;
  }

  public void setDuringAt(String duringAt) {
    this.duringAt = duringAt;
  }

}
