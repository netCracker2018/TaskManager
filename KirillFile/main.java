import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Date;

public class main {
    public static void main(String [] args) throws SQLException, IOException {
      /* Parent parent = FXMLLoader.load(getResource("input.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.show();*/
        DataBase dataBase = new DataBase();
        
       // dataBase.printTableUser();
     //  dataBase.deleteUser(0);
      //  dataBase.addUser(1,"userTest");
     //   dataBase.printTableUser();
     //     dataBase.deleteUser(1);
     //   dataBase.addUser("userTest");
       //  dataBase.printTableUser();
      // dataBase.addUser(3,"userTest");

       /* System.out.println();
        dataBase.printTableUser();*/

        Visualization visualization =  new Visualization(dataBase);
        visualization.mainMenu();




   //Добавление задачи
   //Нормально, но не очень
        /*
        java.util.Date today = new java.util.Date();
        java.sql.Timestamp timeStamp = new java.sql.Timestamp(today.getTime());

        java.sql.Date date = new java.sql.Date(today.getDate());

      //  System.out.println(today.getHours()+':'+today.getMinutes()+':'+today.getSeconds());

        Time time = new Time(12,12,12);
        time.setTime(1212112);
        time.setMinutes(12);
        time.setSeconds(12);

     dataBase.addTask(1,"TaskUser1","other111", date, time);

     //   java.util.Date today = new java.util.Date();
     //   System.out.println(today.toString());

        */
    }
}