import java.util.ArrayList;
import java.util.Scanner;

public class SystemTest {

  public static void main(String[] args) {

    Account account = new Account();

    menu(account);
  }

  public static void menu(Account account) {
    Scanner input = new Scanner(System.in);
    int option = 13;

    while (option != 0) {
      System.out.println("\nChoose an option: ");
      System.out.println("[0] Exit.");
      System.out.println("[1] Login.");
      System.out.println("[2] Register.");

      option = input.nextInt();

      switch (option) {
        case 0:
          System.out.println("\nThank you, see you next time!");
          break;
        case 1:
          login(account);
          break;
        case 2:
          addNewUser(account);
          break;
      }
    }
  }

  public static void system(Account account) {
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
          break;
        case 1:
          updateProject(account);
          break;
        case 2:
          updateActivity(account);
          break;
        case 3:
          addNewProject(account);
          break;
        case 4:
          addNewActivity(account);
          break;
        case 5:
          addNewUser(account);
          break;
        case 6:
          updateUser(account);
          break;
        case 7:
          userInformation(account);
          break;
        case 8:
          projectInformation(account);
          break;
        case 9:
          activityInformation(account);
          break;
      }
    }
  }

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
      if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
        currentUser = user;
        system(account);
      }
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
      else System.out.println("\nYour not registered.");
    }

    if (account.getUsers().isEmpty()) System.out.println("\nYour not registered.");
  }

  public static void resetPassword(User user) {
    Scanner input = new Scanner(System.in);
    
    System.out.println("Enter your new password: ");
    String password = input.nextLine();
    user.setPassword(password);
    System.out.println("\nYour password has been updated successfully.\n");
  }

  public static void userInformation(Account account) {
    Scanner input = new Scanner(System.in);

    String username;

    System.out.println("\nEnter the User Username you want to consult: ");

    username = input.nextLine();

    for (User user: account.getUsers()) {
      if (user.getUsername().equals(username)) {
        System.out.printf("%nInformation available: %s %s%n", user.getFirstName(), user.getLastName());
      }
      else {
        System.out.println("\nSorry, this user was not found.\n");
      }
    }
  }

  public static void projectInformation(Account account) {
    Scanner input = new Scanner(System.in);

    String id;

    System.out.println("Enter the Project Id you want to consult: ");

    id = input.nextLine();

    for (Project project : account.getProjects()) {
      if (project.getId().equals(id)) {
        System.out.printf("Description: %s%nStarted At: %s%nEnds At: %s%nCoordinator: %s%nMembers: %s%nActivities: %s%nSchoolar Amount: %.2f%nDuration: %s%n",
        project.getDescription(), project.getStartAt(), project.getEndAt(), project.getCoordinator(), 
        project.getIntegrants(), project.getActivities(), project.getSchoolarAmount(), project.getDuringAt());
      }
      else {
        System.out.println("\nSorry, this project was not found.\n");
      }
    }
  }

  public static void activityInformation(Account account) {
    Scanner input = new Scanner(System.in);

    String id;

    System.out.println("Enter the Activity Id you want to consult: ");

    id = input.nextLine();

    for (Activities activity : account.getActivities()) {
      if(activity.getId().equals(id)) {
        System.out.printf("Description: %s%nStarted At:%s%nEnds At: %s%nLeader: %s%nMembers: %s%nInstructions: %s%n", 
        activity.getDescription(), activity.getStartAt(), activity.getEndAt(), 
        activity.getLeader(), activity.getIntegrantsUsername(), activity.getInstructions());
      }
      else {
        System.out.println("\nSorry, this activity was not found.\n");
      }
    }
  }

  public static void addNewUser(Account account) {
    Scanner input = new Scanner(System.in);

    String firstName, lastName, username, password;
    ArrayList<User> users = new ArrayList<User>();

    System.out.println("\nEnter your first name: ");
    firstName = input.nextLine();

    System.out.println("Enter your last name: ");
    lastName = input.nextLine();

    System.out.println("Enter an username: ");
    username = input.nextLine();

    System.out.println("Enter your password: ");
    password = input.nextLine();

    User user = new User(firstName, lastName, username, password);

    users = account.getUsers();
    users.add(user);
    account.setUser(users);

    System.out.println("\nYou have been registered successfully!");
  }

  public static void updateUser(Account account) {
    Scanner input = new Scanner(System.in);

    String firstName, lastName, username, password;
    ArrayList<User> users = new ArrayList<User>();

    User currentUser = null;

    System.out.println("Enter your username: ");
    username = input.nextLine();

    System.out.println("Enter your password: ");
    password = input.nextLine();

    for (User user : account.getUsers()) {
      if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
        currentUser = user;

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

        System.out.println("\nYou account has been updated successfully!");
      }
      else {
        System.out.println("\nSorry, something is wrong. Please try again.");
      }
    }
  }

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
          User user = findUser(username, account);
          if (user != null) {
            members.add(user);
            System.out.println("User added successfully.");
          }
          else System.out.println("\nThis username was not found. Please enter a valid username.\n");
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
          User user = findUser(username, account);
          if (user != null) {
            members.add(user);
            System.out.println("User added successfully.");
          }
          else System.out.println("\nThis username was not found. Please enter a valid username.\n");
          break;
      }
    }
    currentActivity.setIntegrants(members);

    System.out.println("Enter the instructions: ");
    instructions = input.nextLine();
    currentActivity.setInstructions(instructions);

    System.out.printf("\nThe project with %s as Id has been updated successfully.", id);
  }

  public static void addNewProject(Account account) {
    Scanner input = new Scanner(System.in);

    String id, description, startAt, endAt, coordinator, duringAt, username, activityId;
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

    System.out.println("Enter the coordinators of the project: ");
    coordinator = input.nextLine();

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
          User user = findUser(username, account);
          if (user != null) {
            members.add(user);
            System.out.println("User added successfully.");
          }
          else System.out.println("\nThis username was not found. Please enter a valid username.\n");
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
          Activities activity = findActivity(activityId, account);
          if (activity != null) {
            activities.add(activity);
            System.out.println("Activity added successfully.");
          }
          else System.out.println("\nThis activity was not found. Please enter a valid Id.\n");
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

  public static User findUser(String username, Account account) {
    for (User user : account.getUsers()) 
      if (user.getUsername().equals(username)) return user;
    return null;
  }

  public static Activities findActivity(String activityId, Account account) {
    for (Activities activity : account.getActivities())
      if (activity.getId().equals(activityId)) return activity;
    return null;
  }

  public static void updateProject(Account account) {
    Scanner input = new Scanner(System.in);

    String id, description, startAt, endAt, coordinator, duringAt, username, activityId;
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

    System.out.println("Enter the coordinators of the project: ");
    coordinator = input.nextLine();
    currentProject.setCoordinator(coordinator);

    System.out.println("Enter the usernames to add integrants: ");
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
          User user = findUser(username, account);
          if (user != null) {
            members.add(user);
            System.out.println("User added successfully.");
          }
          else System.out.println("\nThis username was not found. Please enter a valid username.\n");
          break;
      }
    }
    currentProject.setIntegrants(members);

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
          Activities activity = findActivity(activityId, account);
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
}