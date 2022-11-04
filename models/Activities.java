package models;

import java.util.ArrayList;

public class Activities {

  private String id;
  private String description;
  private String startAt;
  private String endAt;
  private String leader;
  private ArrayList<User> members;
  private String instructions;

  public Activities(String id, String description, String startAt, String endAt, String leader, ArrayList<User> members, String instructions) {
    this.id = id;
    this.description = description;
    this.startAt = startAt;
    this.endAt = endAt;
    this.leader = leader;
    this.members = members;
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

  public ArrayList<User> getMembers() {
    return members;
  }

  public String getMembersUsername() {
    for (User user : members) {
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

  public void setMembers(ArrayList<User> members) {
    this.members = members;
  }

  public void setEndAt(String endAt) {
    this.endAt = endAt;
  }

  public void setStartAt(String startAt) {
    this.startAt = startAt;
  }

  public String toString() {
    return "Id: " + this.getId() + ", Description: " + this.getDescription();
  }

  public String getAllInfo() {
    return "\nId: " + this.getId() + "\nStarted At: " + this.getStartAt() + "\nEnd At: " + this.getEndAt() + "\nLeader: " + this.getLeader() + 
    "\nMembers: " + this.getMembers() + "\nInstructions: " + this.getInstructions();
  }
}