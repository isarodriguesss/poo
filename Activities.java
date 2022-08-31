public class Activities {

  private String id;
  private String description;
  private String startAt;
  private String endAt;
  private String leader;
  private String integrants;
  private String instructions;

  public Activities(String id, String description, String startAt, String endAt, String leader, String integrants, String instructions) {
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

  public String getIntegrants() {
    return integrants;
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

  public void setIntegrants(String integrants) {
    this.integrants = integrants;
  }

  public void setEndAt(String endAt) {
    this.endAt = endAt;
  }

  public void setStartAt(String startAt) {
    this.startAt = startAt;
  }
}