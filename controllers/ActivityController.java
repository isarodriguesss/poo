package controllers;

import java.util.Scanner;
import java.util.ArrayList;

import models.Account;
import models.Project;
import models.User;
import models.Activities;
import controllers.UserController;

public class ActivityController {

  public static void addNewActivity(Account account) {
    Scanner input = new Scanner(System.in);

    String id, description, startAt, endAt, leader, instructions, username;
    ArrayList<User> members = new ArrayList<User>();
    ArrayList<Activities> activities = new ArrayList<Activities>();

    System.out.println("\nEnter an Id for the activity: ");
    id = input.nextLine();

    System.out.println("Enter the activity description: ");
    description = input.nextLine();

    System.out.println("Enter the date and time that the activity starts: ");
    startAt = input.nextLine();

    System.out.println("Enter the date and time the activity ends: ");
    endAt = input.nextLine();

    System.out.println("Enter the leader(responsable) of the activity: ");
    leader = input.nextLine();

    System.out.println("Enter the usernames to add members: ");
    int option = 12;
    while(option!=0) {
      System.out.println("[0] Exit.");
      System.out.println("[1] Add an username.");
      option = input.nextInt();
      input.nextLine();

      switch(option) {
        case 0:
          break;
        case 1:
          System.out.println("Username: ");
          username = input.nextLine();
          User user = UserController.findUser(username, account);
          if (user != null) {
            members.add(user);
            System.out.println("User added successfully.");
          }
          else System.out.println("\nThis username was not found. Please enter a valid username.\n");
          break;
        default:
          System.out.println("\n\nInvalid option!!\n\n");
          break;
      }
    }

    System.out.println("Enter the instructions: ");
    instructions = input.nextLine();

    Activities activity = new Activities(id, description, startAt, endAt, leader, members, instructions);

    activities = account.getActivities();
    activities.add(activity);
    account.setActivities(activities);

    System.out.printf("%nCongratulations, the activity has been created successfully!%n");
  }

  public static void updateActivity(Account account) {
    Scanner input = new Scanner(System.in);

    String id, description, startAt, endAt, leader, instructions, username;
    ArrayList<User> members = new ArrayList<User>();

    System.out.println("\nEnter activity's Id you want to update: ");
    id = input.nextLine();

    Activities currentActivity = null;

    for (Activities activity : account.getActivities()) {
      if (activity.getId().equals(id)) {
        currentActivity = activity;
      }
    }

    System.out.println("Enter an Id for the activity: ");
    id = input.nextLine();
    currentActivity.setId(id);

    System.out.println("Enter the activity description: ");
    description = input.nextLine();
    currentActivity.setDescription(description);

    System.out.println("Enter the date and time that the activity starts: ");
    startAt = input.nextLine();
    currentActivity.setStartAt(startAt);

    System.out.println("Enter the date and time the activity ends: ");
    endAt = input.nextLine();
    currentActivity.setEndAt(endAt);

    System.out.println("Enter the leader(responsable) of the activity: ");
    leader = input.nextLine();
    currentActivity.setLeader(leader);

    System.out.println("Enter the usernames to add members: ");
    int option = 12;
    while(option!=0) {
      System.out.println("[0] Exit.");
      System.out.println("[1] Add an username.");
      option = input.nextInt();
      input.nextLine();

      switch(option) {
        case 0:
          break;
        case 1:
          System.out.println("Username: ");
          username = input.nextLine();
          User user = UserController.findUser(username, account);
          if (user != null) {
            members.add(user);
            System.out.println("User added successfully.");
          }
          else System.out.println("\nThis username was not found. Please enter a valid username.\n");
          break;
        default:
          System.out.println("\n\nInvalid option!!\n\n");
          break;
      }
    }
    currentActivity.setMembers(members);

    System.out.println("Enter the instructions: ");
    instructions = input.nextLine();
    currentActivity.setInstructions(instructions);

    System.out.printf("\nThe project with %s as Id has been updated successfully.", id);
  }

  public static Activities findActivity(String activityId, Account account) {
    for (Activities activity : account.getActivities())
      if (activity.getId().equals(activityId)) return activity;
    return null;
  }

  public static void removeActivity(Account account) {
    Scanner input = new Scanner(System.in);

    String id;
    Activities wantedActivity = null;

    System.out.println("Enter activity's Id you want to remove: ");
    id = input.nextLine();

    try {
      for (Activities activity : account.getActivities())
        if (activity.getId().equals(id)) wantedActivity = activity;
      account.getActivities().remove(wantedActivity);
      System.out.println("\nActivity removed successfully!\n");
    }
    catch(NullPointerException e) {
      System.out.println("This activity was found.");
    }
  }

  public static void activityInformation(Account account) {
    Scanner input = new Scanner(System.in);

    String id;
    Activities wantedActivity = null;

    System.out.println("Enter the Activity's Id you want to consult: ");
    id = input.nextLine();

    try {
      for (Activities activity : account.getActivities()) 
        if(activity.getId().equals(id)) wantedActivity = activity;
      System.out.println(wantedActivity.getAllInfo());
    }
    catch(NullPointerException e) {
      System.out.println("\nSorry, this activity was not found.\n");
    }
  }
}