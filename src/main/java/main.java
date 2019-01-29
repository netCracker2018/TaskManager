import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

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


        //Для запуска
        Visualization visualization =  new Visualization(dataBase);
        visualization.mainMenu();


    //Работает нормальное добавление нынешней даты и времени

   /*     Calendar calendar = Calendar.getInstance();
        long dateCalendar = calendar.getTimeInMillis();
        java.sql.Date dateSqlCalendar = new java.sql.Date(dateCalendar);
        java.sql.Time timeSqlCalendar = new java.sql.Time(dateCalendar);

        dataBase.addTask(1,"TaskUser8","other123", dateSqlCalendar, timeSqlCalendar);

        dataBase.printTasksUser(1);*/
    }
}