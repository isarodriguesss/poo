package models;

import java.util.ArrayList;
import java.lang.reflect.Field;
import models.services.PaymentData;

public class Project {

  private String id;
  private String description;
  private String startAt;
  private String endAt;
  private User coordinator;
  private ArrayList<User> members;
  private ArrayList<Activities> activities;
  private double schoolarAmount;
  private String duringAt;
  private String status;
  private ArrayList<PaymentData> payment;
  private ArrayList<User> usuarios;

  public Project(String id, String description, String startAt, String endAt, User coordinator, 
  ArrayList<User> members, ArrayList<Activities> activities, double schoolarAmount, String duringAt) {
    this.id = id;
    this.description = description;
    this.startAt = startAt;
    this.endAt = endAt;
    this.coordinator = coordinator;
    this.members = members;
    this.activities = activities;
    this.schoolarAmount = schoolarAmount;
    this.duringAt = duringAt;
    this.status = "Em processo de criacao";
    this.payment = new ArrayList<PaymentData>();
    this.usuarios = new ArrayList<User>();
  }

  public void notificarUsuarios() {
    for (User user : this.usuarios){
      user.recebeNotificao(this.status);
    }
  }

  public void setPayment(ArrayList<PaymentData> payment) {
    this.payment = payment;
  }

  public ArrayList<PaymentData> getPayment() {
    return payment;
  }

  public void makePayment(String date) {
    PaymentData payment = new PaymentData(this.getSchoolarAmount(), date);

    this.getPayment().add(payment);
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
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

  public User getCoordinator() {
    return coordinator;
  }

  public void setCoordinator(User coordinator) {
    this.coordinator = coordinator;
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

  public void setMembers(ArrayList<User> members) {
    this.members = members;
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

  public boolean checkNull() {
    for (Field f : getClass().getDeclaredFields()) 
      if (f == null) return true;

    return false;
  }

  public String toString() {
    return "Id: " + this.getId() + "Description: " + this.getDescription();
  }

  public String getAllInfo() {
    return "\nId: " + this.getId() + "\nDescription: " + this.getDescription() + "\nStarted At: " + this.getStartAt() + "\nEnded At: " +
    this.getEndAt() + "\nCoordinator: " + this.getCoordinator() + "\nMembers: " + this.getMembers() + "\nActivities: " + 
    this.getActivities() + "\nSchoolar Amount: " + this.getSchoolarAmount() + "\nDuration: " + this.getDuringAt();
  }

}
