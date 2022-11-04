package controllers;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

import models.Account;
import models.Project;
import models.User;
import models.Activities;
import controllers.UserController;

public class PaymentController {

  public static void showPayment(Account account) {
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

  public static void payment(Account account) {
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
}