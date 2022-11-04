import models.Account;
import utils.Menu;

public class App {

  public static void main(String[] args){

    Account account = new Account();
    Menu menu = new Menu();

    Menu.menu(account);
  }
}