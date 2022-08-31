import java.util.ArrayList;
import java.util.Scanner;

public class SystemTest {

  public static void main(String[] args) {

    ArrayList<Project> projectsCreated = new ArrayList<Project>();
    ArrayList<Activities> activitiesCreated = new ArrayList<Activities>();
    ArrayList<User> usersCreated = new ArrayList<User>();

    menu(projectsCreated, activitiesCreated, usersCreated);
  }

  public static void menu(ArrayList<Project> projectsCreated, ArrayList<Activities> activitiesCreated, ArrayList<User> usersCreated) {
    Scanner input = new Scanner(System.in);
    int option = 13;

    while (option != 0) {
      System.out.println("\nChoose an option: ");
      System.out.println("[0] Exit.");
      System.out.println("[1] Update a project.");
      System.out.println("[2] Update an activity.");
      System.out.println("[3] Add a new project.");
      System.out.println("[4] Add a new activity.");
      System.out.println("[5] Add a new user.");
      System.out.println("[6] Update an user.");
      System.out.println("[7] Confer an user information.");
      System.out.println("[8] Confer a project information.");
      System.out.println("[9] Confer an activity information.");

      option = input.nextInt();

      switch (option) {
        case 0:
          System.out.println("\nThank you, see you next time!");
          break;
        case 1:
          updateProject(projectsCreated);
          break;
        case 2:
          updateActivity(activitiesCreated);
          break;
        case 3:
          addNewProject(projectsCreated);
          break;
        case 4:
          addNewActivity(activitiesCreated);
          break;
        case 5:
          addNewUser(usersCreated);
          break;
        case 6:
          updateUser(usersCreated);
        case 7:
          userInformation(usersCreated);
          break;
        case 8:
          projectInformation(projectsCreated);
          break;
        case 9:
          activityInformation(activitiesCreated);
          break;
      }
    }
  }

  public static void userInformation(ArrayList<User> usersCreated) {
    Scanner input = new Scanner(System.in);

    String username;

    System.out.println("Enter the User Username you want to consult: ");

    username = input.nextLine();

    for (User user: usersCreated) {
      if (user.getUsername().equals(username)) {
        System.out.printf("Information available: %s %s%n", user.getFirstName(), user.getLastName());
      }
      else {
        System.out.println("Sorry, this user was not found.");
      }
    }
  }

  public static void projectInformation(ArrayList<Project> projectsCreated) {
    Scanner input = new Scanner(System.in);

    String id;

    System.out.println("Enter the Project Id you want to consult: ");

    id = input.nextLine();

    for (Project project : projectsCreated) {
      if (project.getId().equals(id)) {
        System.out.printf("Description: %s%nStarted At: %s%nEnds At: %s%nCoordinator: %s%nIntegrators: %s%nActivities: %s%nSchoolar Amount: %.2f%nDuration: %s%n",
        project.getDescription(), project.getStartAt(), project.getEndAt(), project.getCoordinator(), 
        project.getIntegrants(), project.getActivities(), project.getSchoolarAmount(), project.getDuringAt());
      }
      else {
        System.out.println("Sorry, this project was not found.");
      }
    }
  }

  public static void activityInformation(ArrayList<Activities> activitiesCreated) {
    Scanner input = new Scanner(System.in);

    String id;

    System.out.println("Enter the Activity Id you want to consult: ");

    id = input.nextLine();

    for (Activities activity : activitiesCreated) {
      if(activity.getId().equals(id)) {
        System.out.printf("Description: %s%nStarted At:%s%nEnds At: %s%nLeader: %s%nIntegrants: %s%nInstructions: %s%n", 
        activity.getDescription(), activity.getStartAt(), activity.getEndAt(), 
        activity.getLeader(), activity.getIntegrants(), activity.getInstructions());
      }
      else {
        System.out.println("Sorry, this activity was not found.");
      }
    }
  }

  public static void addNewUser(ArrayList<User> usersCreated) {
    Scanner input = new Scanner(System.in);

    String firstName, lastName, username, password;

    System.out.println("\nEnter your first name: ");
    firstName = input.nextLine();

    System.out.println("Enter your last name: ");
    lastName = input.nextLine();

    System.out.println("Enter an username: ");
    username = input.nextLine();

    System.out.println("Enter your password: ");
    password = input.nextLine();

    User user = new User(firstName, lastName, username, password);

    usersCreated.add(user);

    System.out.println("\nYou have been registered successfully!");
  }

  public static void updateUser(ArrayList<User> usersCreated) {
    Scanner input = new Scanner(System.in);

    String firstName, lastName, username, password;

    User currentUser = null;

    System.out.println("Enter your username: ");
    username = input.nextLine();

    System.out.println("Enter your password: ");
    password = input.nextLine();

    for (User user : usersCreated) {
      if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
        currentUser = user;

        System.out.println("\nEnter your first name: ");
        firstName = input.nextLine();

        System.out.println("Enter your last name: ");
        lastName = input.nextLine();

        System.out.println("Enter an username: ");
        username = input.nextLine();

        System.out.println("Enter your password: ");
        password = input.nextLine();

        System.out.println("\nYou account has been updated successfully!");
      }
      else {
        System.out.println("\nSorry, something is wrong. Please try again");
      }
    }
  }

  public static void addNewActivity(ArrayList<Activities> activitiesCreated) {
    Scanner input = new Scanner(System.in);

    String id, description, startAt, endAt, leader, integrants, instructions;

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

    System.out.println("Enter the integrants: ");
    integrants = input.nextLine();

    System.out.println("Enter the instructions: ");
    instructions = input.nextLine();

    Activities activity = new Activities(id, description, startAt, endAt, leader, integrants, instructions);

    activitiesCreated.add(activity);

    System.out.printf("%nCongratulations, the activity has been created successfully!%n");
  }

  public static void updateActivity(ArrayList<Activities> activitiesCreated) {
    Scanner input = new Scanner(System.in);

    String id, description, startAt, endAt, leader, integrants, instructions;

    System.out.println("\nEnter activity's Id you want to update: ");
    id = input.nextLine();

    Activities currentActivity = null;

    for (Activities activity : activitiesCreated) {
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

    System.out.println("Enter the integrants: ");
    integrants = input.nextLine();
    currentActivity.setIntegrants(integrants);

    System.out.println("Enter the instructions: ");
    instructions = input.nextLine();
    currentActivity.setInstructions(instructions);

    System.out.printf("\nThe project with %s as Id has been updated successfully.", id);
  }

  public static void addNewProject(ArrayList<Project> projectsCreated) {
    Scanner input = new Scanner(System.in);

    String id, description, startAt, endAt, coordinator, duringAt, integrants, activities;
    double schoolarAmount;

    System.out.println("\nEnter an Id for the project: ");
    id = input.nextLine();

    System.out.println("Enter the project description: ");
    description = input.nextLine();

    System.out.println("Enter the date and time that the project starts: ");
    startAt = input.nextLine();

    System.out.println("Enter the date and time the project ends: ");
    endAt = input.nextLine();

    System.out.println("Enter the coordinators of the project: ");
    coordinator = input.nextLine();

    System.out.println("Enter the integrants: ");
    integrants = input.nextLine();

    System.out.println("Enter the activities: ");
    activities = input.nextLine();

    System.out.println("Enter the shcoolar amount of the project: ");
    schoolarAmount = input.nextDouble();
    input.nextLine();

    System.out.println("Enter the duration of the project: ");
    duringAt = input.nextLine();

    Project project = new Project(id, description, startAt, endAt, coordinator, integrants, activities, schoolarAmount, duringAt);

    projectsCreated.add(project);
    
    System.out.printf("%nCongratulations, the project has been created successfully!%n");
  }

  public static void updateProject(ArrayList<Project> projectsCreated) {
    Scanner input = new Scanner(System.in);

    String id, description, startAt, endAt, coordinator, duringAt, integrants, activities;
    double schoolarAmount;

    System.out.println("Enter project's Id you want to update: ");
    id = input.nextLine();

    Project currentProject = null;

    for (Project project : projectsCreated) {
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

    System.out.println("Enter the coordinators of the project: ");
    coordinator = input.nextLine();
    currentProject.setCoordinator(coordinator);

    System.out.println("Enter the integrants: ");
    integrants = input.nextLine();
    currentProject.setIntegrants(integrants);

    System.out.println("Enter the activities: ");
    activities = input.nextLine();
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

  /* public static Project findProject(String id, ArrayList<Project> projectsCreated){
    for (Project project : projectsCreated) {
      if (project.getId().equals(id)) {
        return project;
      }
    }
  } */
}