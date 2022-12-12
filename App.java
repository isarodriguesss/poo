import models.Account;
import views.Menu;

public class App {

  public static void main(String[] args){

    Account account = new Account();

    Menu.menu(account);
  }
}