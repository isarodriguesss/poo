package views;

import java.util.Scanner;
import java.util.InputMismatchException;

import controllers.UserController;

import models.Account;

public class Menu {

  public static void menu(Account account) {
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
          UserController.login(account);
          break;
        case 2:
          UserController.addNewUser(account);
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
}