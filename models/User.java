package models;

import java.util.ArrayList;
import models.Project;
import models.Activities;

public class User {

  private String firstName;
  private String lastName;
  private String username;
  private String password;
  private ArrayList<Project> projectsEnvolved;
  private ArrayList<Activities> activitiesEnvolved;

  public User(String firstName, String lastName, String username, String password) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.username = username;
    this.password = password;
    this.projectsEnvolved = new ArrayList<Project>();
    this.activitiesEnvolved = new ArrayList<Activities>();
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setProjectsEnvolved(ArrayList<Project> projectsEnvolved) {
    this.projectsEnvolved = projectsEnvolved;
  }

  public ArrayList<Project> getProjectsEnvolved() {
    return projectsEnvolved;
  }

  public void setActivitiesEnvolved(ArrayList<Activities> activitiesEnvolved) {
    this.activitiesEnvolved = activitiesEnvolved;
  }

  public ArrayList<Activities> getActivitiesEnvolved() {
    return activitiesEnvolved;
  }

  public String toString() {
    return "Name: " + this.getFirstName() + " " + this.getLastName() + ", Projects Envolved: " + getProjectsEnvolved() + ", Activities Envolved: " + getActivitiesEnvolved();
  }
}