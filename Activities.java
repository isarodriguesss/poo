import java.util.ArrayList;

public class Activities {

  private String id;
  private String description;
  private String startAt;
  private String endAt;
  private String leader;
  private ArrayList<User> integrants;
  private String instructions;

  public Activities(String id, String description, String startAt, String endAt, String leader, ArrayList<User> integrants, String instructions) {
    this.id = id;
    this.description = description;
    this.startAt = startAt;
    this.endAt = endAt;
    this.leader = leader;
    this.integrants = integrants;
    this.instructions = instructions;
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

  public String getEndAt() {
    return endAt;
  }

  public String getLeader() {
    return leader;
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

  public String getInstructions() {
    return instructions;
  }

  public void setInstructions(String instructions) {
    this.instructions = instructions;
  }

  public void setLeader(String leader) {
    this.leader = leader;
  }

  public void setIntegrants(ArrayList<User> integrants) {
    this.integrants = integrants;
  }

  public void setEndAt(String endAt) {
    this.endAt = endAt;
  }

  public void setStartAt(String startAt) {
    this.startAt = startAt;
  }
}