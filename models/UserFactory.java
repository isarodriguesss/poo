package models;

public class UserFactory {
  public static User getUsuario(String tipo, String firstname, String lastname, String username, String password){
    switch (tipo){
      case "Doctor":
        return new Doctor(firstname, lastname, username, password);
      case "Graduating":
        return new Graduating(firstname, lastname, username, password);
      case "Master":
        return new Master(firstname, lastname, username, password);
      case "Researcher":
        return new Reseacher(firstname, lastname, username, password);
      case "Professor":
        return new Professor(firstname, lastname, username, password);
      case "Profissional":
        return new Profissional(firstname, lastname, username, password);
      case "Technician":
        return new Technician(firstname, lastname, username, password);
      default:
        System.out.println("Tipo de usuário inválido!");
    }
    return null;
  }
}
