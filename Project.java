import java.util.ArrayList;

public class Project {

  private String id;
  private String description;
  private String startAt;
  private String endAt;
  private String coordinator;
  private String integrants;
  private String activities;
  private double schoolarAmount;
  private String duringAt;

  public Project(String id, String description, String startAt, String endAt, String coordinator, 
  String integrants, String activities, double schoolarAmount, String duringAt) {
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

  public String getIntegrants() {
    return integrants;
  }

  public void setIntegrants(String integrants) {
    this.integrants = integrants;
  }

  public String getActivities() {
    return activities;
  }

  public void setActivities(String activities) {
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
