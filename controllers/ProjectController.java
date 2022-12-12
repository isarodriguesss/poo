package controllers;

import java.util.Scanner;
import java.util.ArrayList;

import models.Account;
import models.Project;
import models.User;
import models.Activities;
import models.Reseacher;
import models.Professor;

public class ProjectController {

  public static void addNewProject(Account account) {
    Scanner input = new Scanner(System.in);

    String id, description, startAt, endAt, coordinatorUsername, duringAt, username, activityId;
    User coordinator = null;
    double schoolarAmount;
    ArrayList<User> members = new ArrayList<User>();
    ArrayList<Project> projects = new ArrayList<Project>();
    ArrayList<Activities> activities = new ArrayList<Activities>();

    System.out.println("\nEnter an Id for the project: ");
    id = input.nextLine();

    System.out.println("Enter the project description: ");
    description = input.nextLine();

    System.out.println("Enter the date and time that the project starts: ");
    startAt = input.nextLine();

    System.out.println("Enter the date and time the project ends: ");
    endAt = input.nextLine();

    System.out.println("Enter the username of the coordinator of the project: ");
    coordinatorUsername = input.nextLine();
    for (User user : account.getUsers()) {
      if (user.getUsername().equals(coordinatorUsername)) {
        coordinator = user;
        if (user instanceof Professor | user instanceof Reseacher) coordinator = user;
        else {
          System.out.println("\nThis user is not allowed to be a coordinator of the project.");
          addNewProject(account);
        }
      }
    }

    if (coordinator == null) {
      System.out.println("Username not found.");
      addNewProject(account);
    }
    

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

    System.out.println("Enter the Id's to add activities: ");
    int option2 = 12;
    while(option2!=0) {
      System.out.println("[0] Exit.");
      System.out.println("[1] Add an activity.");
      option2 = input.nextInt();
      input.nextLine();

      switch(option2) {
        case 0:
          break;
        case 1:
          System.out.println("Activity's Id: ");
          activityId = input.nextLine();
          Activities activity = ActivityController.findActivity(activityId, account);
          if (activity != null) {
            activities.add(activity);
            System.out.println("Activity added successfully.");
          }
          else System.out.println("\nThis activity was not found. Please enter a valid Id.\n");
          break;
        default:
          System.out.println("\n\nInvalid option!!\n\n");
          break;
      }
    }

    System.out.println("Enter the shcoolar amount of the project: ");
    schoolarAmount = input.nextDouble();
    input.nextLine();

    System.out.println("Enter the duration of the project: ");
    duringAt = input.nextLine();

    Project project = new Project(id, description, startAt, endAt, coordinator, members, activities, schoolarAmount, duringAt);

    projects = account.getProjects();
    projects.add(project);
    account.setProject(projects);
    
    System.out.printf("%nCongratulations, the project has been created successfully!%n");
  }

  public static void projectInformation(Account account) {
    Scanner input = new Scanner(System.in);

    String id;
    Project wantedProject = null;

    System.out.println("Enter the Project Id you want to consult: ");
    id = input.nextLine();

    try {
      for (Project project : account.getProjects())
        if (project.getId().equals(id)) wantedProject = project;
      
      System.out.println(wantedProject.getAllInfo());
    }
    catch(NullPointerException e) {
      System.out.println("\nNothing was found\n");
    }
  }

  public static void updateProject(Account account) {
    Scanner input = new Scanner(System.in);

    String id, description, startAt, endAt, coordinatorUsername, duringAt, username, activityId;
    User coordinator = null;
    double schoolarAmount;
    ArrayList<User> members = new ArrayList<User>();
    ArrayList<Activities> activities = new ArrayList<Activities>();

    System.out.println("Enter project's Id you want to update: ");
    id = input.nextLine();

    Project currentProject = null;

    for (Project project : account.getProjects()) {
      if (project.getId().equals(id)) {
        currentProject = project;
      }
    }

    System.out.println("Enter an Id for the project: ");
    id = input.nextLine();
    currentProject.setId(id);

    System.out.println("Enter the project description: ");
    description = input.nextLine();
    currentProject.setDescription(description);

    System.out.println("Enter the date and time that the project starts: ");
    startAt = input.nextLine();
    currentProject.setStartAt(startAt);

    System.out.println("Enter the date and time the project ends: ");
    endAt = input.nextLine();
    currentProject.setEndAt(endAt);

    System.out.println("Enter the username of the coordinator of the project: ");
    coordinatorUsername = input.nextLine();
    for (User user : account.getUsers()) {
      if (user.getUsername().equals(coordinatorUsername)) {
        coordinator = user;
        if (user instanceof Professor | user instanceof Reseacher) coordinator = user;
        else System.out.println("This user is not allowed to be a coordinator of the project.");
      }
    }

    if (coordinator == null) {
      System.out.println("Username not found.");
      updateProject(account);
    } 
    currentProject.setCoordinator(coordinator);

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
    currentProject.setMembers(members);

    System.out.println("Enter the Id's to add activities: ");
    int option2 = 12;
    while(option2!=0) {
      System.out.println("[0] Exit.");
      System.out.println("[1] Add an activity.");
      option2 = input.nextInt();
      input.nextLine();

      switch(option2) {
        case 0:
          break;
        case 1:
          System.out.println("Activity's Id: ");
          activityId = input.nextLine();
          Activities activity = ActivityController.findActivity(activityId, account);
          if (activity != null) {
            activities.add(activity);
            System.out.println("Activity added successfully.");
          }
          else System.out.println("\nThis activity was not found. Please enter a valid Id.\n");
          break;
      }
    }
    currentProject.setActivities(activities);

    System.out.println("Enter the shcoolar amount of the project: ");
    schoolarAmount = input.nextDouble();
    input.nextLine();
    currentProject.setSchoolarAmount(schoolarAmount);

    System.out.println("Enter the duration of the project: ");
    duringAt = input.nextLine();
    currentProject.setDuringAt(duringAt);

    System.out.printf("\nThe project with %s as Id has been updated successfully.\n", id);

  }

  public static void removeProject(Account account) {
    Scanner input = new Scanner(System.in);
    String id;
    Project wantedProject = null;

    System.out.println("Enter project's Id you want to remove: ");
    id = input.nextLine();

    try {
      for (Project project : account.getProjects())
        if (project.getId().equals(id)) wantedProject = project;

      account.getProjects().remove(wantedProject);
      System.out.println("\nProject removed successfully!\n");
    }
    catch(NullPointerException e) {
      System.out.println("This project was not found.");
    }
  }

  public static Project findProject(String projectId, Account account) {
    for (Project project : account.getProjects())
      if (project.getId().equals(projectId)) return project;
    return null;
  }

  public static void checkStatus(Account account) {
    Scanner input = new Scanner(System.in);
    String id;
    String projectStatus = null;

    System.out.println("Enter the project's Id you want to check status: ");
    id = input.nextLine();

    try {
      for (Project project : account.getProjects()) 
        if (project.getId().equals(id)) projectStatus = project.getStatus();
    
      System.out.printf("%nStatus: %s%n", projectStatus);
    }
    catch(NullPointerException e) {
      System.out.println("\nNothing was found\n");
    }
    
  }

  public static void status(Account account, User user) {
    Scanner input = new Scanner(System.in);
    String id;
    int option;

    System.out.println("Enter project's Id you want to set the status: ");
    id = input.nextLine();
    for (Project project : account.getProjects()) {
      {
        if (project.getId().equals(id)) {
          if (project.getCoordinator() == user) {
            System.out.println("Choose a status: \n[1] Iniciado.\n[2] Em andamento.\n[3] Concluido");
            option = input.nextInt();
            input.nextLine();

            switch (option) {
              case 1:
                if(project.checkNull()) System.out.println("\nSorry, the project must have all basics informations.");
                else {
                  project.setStatus("Iniciado");
                  System.out.println("\nNew project status: 'Iniciado'.");
                }
                break;
              case 2:
                if (project.getStatus() == "Iniciado") {
                  project.setStatus("Em andamento");
                  System.out.println("\nNew project status: 'Em andamento'.");
                }
                else System.out.println("\nSorry, the project has not been not started yet.");
                break;
              case 3:
                if (project.getStatus() == "Em andamento") {
                  for (Activities activity : project.getActivities()) {
                    if (activity.getDescription() == "") System.out.println("\nSorry, activities must have a description.");
                    else {
                      project.setStatus("Concluido");
                      System.out.println("\nNew project status: 'Concluido'.");
                    }
                  }
                }
                else System.out.println("\nSorry, the project is not in progress.");
                break;
              default:
                System.out.println("\n\nInvalid option!!\n\n");
                break;
            }
          }
          else System.out.println("\nSorry, you are not the project coordinator.");
        }
        else System.out.println("\nThis project Id was not found.");
      }
    }
  }
}