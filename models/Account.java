package models;

import java.util.ArrayList;

public class Account {

  private ArrayList<User> users;
  private ArrayList<Project> projects;
  private ArrayList<Activities> activities;

  public Account() {
    this.users = new ArrayList<User>();
    this.projects = new ArrayList<Project>();
    this.activities = new ArrayList<Activities>();
  }

  public ArrayList<User> getUsers() {
    return users;
  }

  public ArrayList<Project> getProjects() {
    return projects;
  }

  public ArrayList<Activities> getActivities() {
    return activities;
  }

  public void setUser(ArrayList<User> users) {
    this.users = users;
  }

  public void setProject(ArrayList<Project> projects) {
    this.projects = projects;
  }

  public void setActivities(ArrayList<Activities> activities) {
    this.activities = activities;
  }

} 