import java.sql.SQLException;

public class main {
    public static void main(String [] args) throws SQLException {
        DataBase dataBase = new DataBase();
      //  dataBase.deleteUser(0);
/*        dataBase.addUser("qwerty1");
        dataBase.addUser("qwerty2");*/
        dataBase.printTableUser();
    }
}