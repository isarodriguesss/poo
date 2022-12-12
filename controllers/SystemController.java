package controllers;

import java.util.Scanner;
import java.util.InputMismatchException;

import models.Account;
import models.Project;
import models.User;
import models.Activities;

public class SystemController {

  public static void system(Account account, User user) {
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
            ProjectController.addNewProject(account);
            break;
          case 2:
            ActivityController.addNewActivity(account);
            break;
          case 3:
            UserController.addNewUser(account);
            break;
          case 4:
            ProjectController.updateProject(account);
            break;
          case 5:
            ActivityController.updateActivity(account);
            break;
          case 6:
            UserController.updateUser(account);
            break;
          case 7:
            ProjectController.removeProject(account);
            break;
          case 8:
            ActivityController.removeActivity(account);
            break;
          case 9:
            UserController.removeUser(account);
            break;
          case 10:
            UserController.userInformation(account);
            break;
          case 11:
            ProjectController.projectInformation(account);
            break;
          case 12:
            ActivityController.activityInformation(account);
            break;
          case 13:
            ProjectController.status(account, user);
            break;
          case 14:
            ProjectController.checkStatus(account);
            break;
          case 15:
            PaymentController.payment(account);
            break;
          case 16:
            PaymentController.showPayment(account);
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

  public static void report(Account account) {
    System.out.println("\nProjects: ");
    for (Project project : account.getProjects())
      System.out.println(project.getAllInfo());
    System.out.println("\nActivities: ");
    for (Activities activity : account.getActivities())
      System.out.println(activity.getAllInfo());
  }
}