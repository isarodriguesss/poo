import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Utils {

  public void menu(Account account) {
    Scanner input = new Scanner(System.in);
    int option = 13;
    try {
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
        default:
          System.out.println("\n\nInvalid option!!\n\n");
          break;
        }
      }
    }
    catch (InputMismatchException e) {
      System.out.println("\n\nInvalid option!!\n\n");
      menu(account);
    }
  }

  public void system(Account account, User user) {
    Scanner input = new Scanner(System.in);
    int option = 13;

    try{
      while (option != 0) {
        System.out.println("\nChoose an option: ");
        System.out.println("[0] Exit.");
        System.out.println("[1] Add a new project.");
        System.out.println("[2] Add a new activity.");
        System.out.println("[3] Add a new user.");
        System.out.println("[4] Update a project.");
        System.out.println("[5] Update an activity.");
        System.out.println("[6] Update an user.");
        System.out.println("[7] Remove a project.");
        System.out.println("[8] Remove an activity.");
        System.out.println("[9] Remove an user.");
        System.out.println("[10] Confer an user information.");
        System.out.println("[11] Confer a project information.");
        System.out.println("[12] Confer an activity information.");
        System.out.println("[13] Set the status of a project.");
        System.out.println("[14] Check a project status.");
        System.out.println("[15] Lauch a new Schoolarship payment.");
        System.out.println("[16] Show schoolarship payments.");
        System.out.println("[17] Projects and activities report.");

        option = input.nextInt();

        switch (option) {
          case 0:
            break;
          case 1:
            addNewProject(account);
            break;
          case 2:
            addNewActivity(account);
            break;
          case 3:
            addNewUser(account);
            break;
          case 4:
            updateProject(account);
            break;
          case 5:
            updateActivity(account);
            break;
          case 6:
            updateUser(account);
            break;
          case 7:
            removeProject(account);
            break;
          case 8:
            removeActivity(account);
            break;
          case 9:
            removeUser(account);
            break;
          case 10:
            userInformation(account);
            break;
          case 11:
            projectInformation(account);
            break;
          case 12:
            activityInformation(account);
            break;
          case 13:
            status(account, user);
            break;
          case 14:
            checkStatus(account);
            break;
          case 15:
            payment(account);
            break;
          case 16:
            showPayment(account);
            break;
          case 17:
            report(account);
            break;
          default:
            System.out.println("\n\nInvalid option!!\n\n");
            break;
        }
      }
    }
    catch (InputMismatchException e) {
      System.out.println("\n\nInvalid option!!\n\n");
      system(account, user);
    }
  }

  public void removeProject(Account account) {
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
      System.out.println("This project was found.");
    }
  }

  public void removeActivity(Account account) {
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
    catch (NullPointerException e) {
      System.out.println("This activity was found.");
    }
  }

  public void removeUser(Account account) {
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
    }
    
    else System.out.println("Sorry, something goes wrong.");
  }

  public void report(Account account) {
    System.out.println("\nProjects: ");
    for (Project project : account.getProjects())
      System.out.println(project.getAllInfo());
    System.out.println("\nActivities: ");
    for (Activities activity : account.getActivities())
      System.out.println(activity.getAllInfo());
  }

  public void showPayment(Account account) {
    Scanner input = new Scanner(System.in);
    String id;
    Project currentProject = null;

    System.out.println("Enter the project's Id you want to show payment: ");
    id = input.nextLine();
    try {
      for (Project project : account.getProjects()) 
        if (project.getId().equals(id)) currentProject = project;
      System.out.println(currentProject.getPayment());
    }
    catch(NullPointerException e) {
      System.out.println("\nNothing was found\n");
    }
    
  }

  public void payment(Account account) {
    Scanner input = new Scanner(System.in);
    String id, date;
    int option;
    Project currentProject = null;

    System.out.println("Enter the project's  Id you want to make a payment: ");
    id  = input.nextLine();

    try {
      for (Project project : account.getProjects()) 
        if (project.getId().equals(id)) currentProject = project;

      System.out.printf("The schoolarship amount of this project is %.2f. ", currentProject.getSchoolarAmount());
      System.out.printf("Do you want to register a payment? %n[1] Yes.%n[2] No.%n");
      option = input.nextInt();
      input.nextLine();
      try {
        switch(option) {
        case 1:
          System.out.println("Enter the date of the payment: ");
          date = input.nextLine();

          currentProject.makePayment(date);

          System.out.println("\nPayment registered successfully.");
          break;
        case 2:
          break;
        default:
            System.out.println("\n\nInvalid option!!\n\n");
            payment(account);
            break;
        }
      }
      catch(InputMismatchException e) {
        System.out.println("\n\nInvalid option!!\n\n");
        payment(account);
      }
    }
    catch(NullPointerException e) {
      System.out.println("\nNothing was found\n");
    }
    
    
    

  }

  public void checkStatus(Account account) {
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

  public void status(Account account, User user) {
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

  public void login(Account account) {
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
    if (currentUser != null) system(account, currentUser);
    else System.out.println("\nYour not registered.");
  }

  public void resetPassword(User user) {
    Scanner input = new Scanner(System.in);
    
    System.out.println("Enter your new password: ");
    String password = input.nextLine();
    user.setPassword(password);
    System.out.println("\nYour password has been updated successfully.\n");
  }

  public void userInformation(Account account) {
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

  public void projectInformation(Account account) {
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

  public void activityInformation(Account account) {
    Scanner input = new Scanner(System.in);

    String id;
    Activities wantedActivity = null;

    System.out.println("Enter the Activity Id you want to consult: ");
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

  public void addNewUser(Account account) {
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
          Project project = findProject(projectId, account);
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
          Activities activity = findActivity(activityId, account);
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

  public void updateUser(Account account) {
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
            Project project = findProject(projectId, account);
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
            Activities activity = findActivity(activityId, account);
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

  public void addNewActivity(Account account) {
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

  public void updateActivity(Account account) {
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

  public void addNewProject(Account account) {
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
        else System.out.println("This user is not allowed to be a coordinator of the project.");
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
          User user = findUser(username, account);
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
          Activities activity = findActivity(activityId, account);
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

  public Project findProject(String projectId, Account account) {
    for (Project project : account.getProjects())
      if (project.getId().equals(projectId)) return project;
    return null;
  }

  public User findUser(String username, Account account) {
    for (User user : account.getUsers()) 
      if (user.getUsername().equals(username)) return user;
    return null;
  }

  public Activities findActivity(String activityId, Account account) {
    for (Activities activity : account.getActivities())
      if (activity.getId().equals(activityId)) return activity;
    return null;
  }

  public void updateProject(Account account) {
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
          User user = findUser(username, account);
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