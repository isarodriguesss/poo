package controllers;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

import models.Account;
import models.Project;
import models.User;
import models.Activities;
import models.Reseacher;
import models.Professor;
import models.Student;
import models.Profissional;
import controllers.ActivityController;
import controllers.ProjectController;
import controllers.SystemController;
import utils.Menu;

public class UserController {

  public static void login(Account account) {
    Scanner input = new Scanner(System.in);

    String firstName, lastName, username, password;
    ArrayList<User> users = new ArrayList<User>();

    User currentUser = null;

    System.out.println("\nEnter your username: ");
    username = input.nextLine();

    System.out.println("Enter your password: ");
    password = input.nextLine();

    for (User user : account.getUsers()) {
      if (user.getUsername().equals(username) && user.getPassword().equals(password)) currentUser = user;
      else if (user.getUsername().equals(username)) {
        int option;
        System.out.println("\nYour password is wrong, you want to create a new one?");
        System.out.println("[1] Yes.");
        System.out.println("[2] No.");
        option = input.nextInt();

        switch(option) {
          case 1:
            resetPassword(user);
            break;
          case 2:
            break;
        }
      }
    }
    if (currentUser != null) SystemController.system(account, currentUser);
    else System.out.println("\nYour not registered.");
  }

  public static void addNewUser(Account account) {
    Scanner input = new Scanner(System.in);

    String firstName, lastName, username, password, projectId, activityId;
    ArrayList<User> users = new ArrayList<User>();
    ArrayList<Project> projectsEnvolved = new ArrayList<Project>();
    ArrayList<Activities> activitiesEnvolved = new ArrayList<Activities>();
    User user = null;

    System.out.println("\nEnter your first name: ");
    firstName = input.nextLine();

    System.out.println("Enter your last name: ");
    lastName = input.nextLine();

    System.out.println("Enter an username: ");
    username = input.nextLine();

    System.out.println("Enter your password: ");
    password = input.nextLine();

    System.out.println("Enter what type of user fits you: ");
    System.out.println("[1] Student.\n[2] Professor.\n[3] Reseacher\n[4] Profissional: ");
    int optionUserType = input.nextInt();
    input.nextLine();

    try {
      switch (optionUserType) {
      case 1:
        String degree = null;
        int degreeOption;
        System.out.println("Select your degree level:\n[1] Undergraduate Degree.\n[2] Master Degree.\n[3] PhD.");
        degreeOption = input.nextInt();
        try {
          switch(degreeOption) {
            case 1:
              degree = "Undergraduate Degree";
              break;
            case 2:
              degree = "Master Degree";
              break;
            case 3:
              degree = "PhD";
              break;
            default:
              System.out.println("\n\nInvalid option!!\n\n");
              addNewUser(account);
              break;
          }
        }
        catch (InputMismatchException e) {
          System.out.println("\n\nInvalid option!!\n\n");
          addNewUser(account);
        }
        user = new Student(firstName, lastName, username, password, degree);
        break;
      case 2:
        System.out.println("Enter subject you lesson: ");
        String subject = input.nextLine();
        user = new Professor(firstName, lastName, username, password, subject);
        break;
      case 3:
        System.out.println("Enter the subject of you reseach: ");
        String subjectR = input.nextLine();
        user = new Reseacher(firstName, lastName, username, password, subjectR);
        break;
      case 4:
        int typeOption;
        String type = null;
        System.out.println("Enter the type of profissional you are:\n[1] Developer.\n[2] Tester.\n[3] Analyst.");
        typeOption = input.nextInt();
        try {
          switch(typeOption) {
            case 1:
              type = "Developer";
              break;
            case 2:
              type = "Tester";
              break;
            case 3:
              type = "Analyst";
              break;
            default:
              System.out.println("\n\nInvalid option!!\n\n");
              addNewUser(account);
              break;
          }
        user = new Profissional(firstName, lastName, username, password, type);
        break;
        }
        catch (InputMismatchException e) {
          System.out.println("\n\nInvalid option!!\n\n");
          addNewUser(account);
        }
      default:
        System.out.println("\n\nInvalid option!!\n\n");
        addNewUser(account);
        break;
      }
    }
    catch (InputMismatchException e) {
      System.out.println("\n\nInvalid option!!\n\n");
      addNewUser(account);
    }

    System.out.println("Enter projects you are envolved: ");
    int option = 12;

    while(option!=0) {
      System.out.println("[0] Exit.\n[1] Add a project.");
      option = input.nextInt();
      input.nextLine();

      switch(option) {
        case 0:
          break;
        case 1:
          System.out.println("Project's Id: ");
          projectId = input.nextLine();
          Project project = ProjectController.findProject(projectId, account);
          if (project != null) {
            projectsEnvolved.add(project);
            System.out.println("\nProject added successfully.\n");
          }
          else System.out.println("\nThis Id was not found. Please enter a valid Id.\n");
          break;
        default:
          System.out.println("\n\nInvalid option!!\n\n");
          break;
      }
    }
    user.setProjectsEnvolved(projectsEnvolved);

    System.out.println("Enter activities you are envolved: ");
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
            activitiesEnvolved.add(activity);
            System.out.println("\nActivity added successfully.\n");
          }
          else System.out.println("\nThis Id was not found. Please enter a valid Id.\n");
          break;
        default:
          System.out.println("\n\nInvalid option!!\n\n");
          break;
      }
    }
    user.setActivitiesEnvolved(activitiesEnvolved);
    users = account.getUsers();
    users.add(user);
    account.setUser(users);

    System.out.println("\nYou have been registered successfully!");
  }

  public static void resetPassword(User user) {
    Scanner input = new Scanner(System.in);
    
    System.out.println("Enter your new password: ");
    String password = input.nextLine();
    user.setPassword(password);
    System.out.println("\nYour password has been updated successfully.\n");
  }

  public static User findUser(String username, Account account) {
    for (User user : account.getUsers()) 
      if (user.getUsername().equals(username)) return user;
    return null;
  }

  public static void updateUser(Account account) {
    Scanner input = new Scanner(System.in);

    String firstName, lastName, username, password, projectId, activityId;
    ArrayList<User> users = new ArrayList<User>();
    ArrayList<Project> projectsEnvolved = new ArrayList<Project>();
    ArrayList<Activities> activitiesEnvolved = new ArrayList<Activities>();

    User currentUser = null;

    System.out.println("Enter your username: ");
    username = input.nextLine();

    System.out.println("Enter your password: ");
    password = input.nextLine();

    for (User user : account.getUsers())
      if (user.getUsername().equals(username) && user.getPassword().equals(password)) currentUser = user;

    if (currentUser != null) {
      System.out.println("\nEnter your first name: ");
      firstName = input.nextLine();
      currentUser.setFirstName(firstName);

      System.out.println("Enter your last name: ");
      lastName = input.nextLine();
      currentUser.setLastName(lastName);

      System.out.println("Enter an username: ");
      username = input.nextLine();
      currentUser.setUsername(username);

      System.out.println("Enter your password: ");
      password = input.nextLine();
      currentUser.setPassword(password);

      System.out.println("Enter projects you are envolved: ");
      int option = 12;
      while(option!=0) {
        System.out.println("[0] Exit.");
        System.out.println("[1] Add a project.");
        option = input.nextInt();
        input.nextLine();

        switch(option) {
          case 0:
            break;
          case 1:
            System.out.println("Project's Id: ");
            projectId = input.nextLine();
            Project project = ProjectController.findProject(projectId, account);
            if (project != null) {
              projectsEnvolved.add(project);
              System.out.println("\nProject added successfully.\n");
            }
            else System.out.println("\nThis Id was not found. Please enter a valid Id.\n");
            break;
          default:
            System.out.println("\n\nInvalid option!!\n\n");
            break;
        }
      }
      currentUser.setProjectsEnvolved(projectsEnvolved);

      System.out.println("Enter activities you are envolved: ");
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
              activitiesEnvolved.add(activity);
              System.out.println("\nActivity added successfully.\n");
            }
            else System.out.println("\nThis Id was not found. Please enter a valid Id.\n");
            break;
          default:
            System.out.println("\n\nInvalid option!!\n\n");
            break;
        }
      }
      currentUser.setActivitiesEnvolved(activitiesEnvolved);

      System.out.println("\nYou account has been updated successfully!");
    }

    else System.out.println("\nSorry, something is wrong. Please try again.");
  }

  public static void removeUser(Account account) {
    Scanner input = new Scanner(System.in);
    String username, password;
    User wantedUser = null;

    System.out.println("Enter your username: ");
    username = input.nextLine();

    System.out.println("Enter your password: ");
    password = input.nextLine();

    for (User user : account.getUsers())
      if (user.getUsername().equals(username) && user.getPassword().equals(password)) wantedUser = user;
    
    if (wantedUser != null) {
      account.getUsers().remove(wantedUser);
      System.out.println("\nUser removed successfully!\n");
      Menu.menu(account);
    }
    
    else System.out.println("Sorry, something goes wrong.");
  }

  public static void userInformation(Account account) {
    Scanner input = new Scanner(System.in);

    String username;
    User wantedUser = null;

    System.out.println("\nEnter the User Username you want to consult: ");
    username = input.nextLine();
    
    for (User user: account.getUsers())
      if (user.getUsername().equals(username)) wantedUser = user;
    
    if (wantedUser != null) System.out.printf("%nInformations available: %s%n", wantedUser);
    else System.out.println("\nSorry, this user was not found.\n");
  }
}