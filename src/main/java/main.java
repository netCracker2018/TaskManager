import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class main {
    public static void main(String [] args) throws SQLException, IOException {
        DataBase dataBase = new DataBase();
       // dataBase.printTableUser();
     //  dataBase.deleteUser(0);
      //  dataBase.addUser(1,"userTest");
     //   dataBase.printTableUser();
     //     dataBase.deleteUser(1);
        //dataBase.addUser(2,"userTest");
       //  dataBase.printTableUser();
      // dataBase.addUser(3,"userTest");

        dataBase.deleteUser(1);
        dataBase.deleteUser(2);
        dataBase.deleteUser(3);

        System.out.println();
        dataBase.printTableUser();

      /*  Visualization visualization =  new Visualization(dataBase);
        visualization.mainMenu();*/
    }
}