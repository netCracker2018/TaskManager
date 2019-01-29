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
      /*  Visualization visualization =  new Visualization(dataBase);
        visualization.mainMenu();*/









        //Тут время бралось нормально, нынешнее

     /*   java.util.Date dateUtil = new java.util.Date();
       // java.sql.Timestamp timeStamp = new java.sql.Timestamp(dateUtil.getTime());

        java.sql.Date dateSql = new java.sql.Date(dateUtil.getTime());

      //  System.out.println(today.getHours()+':'+today.getMinutes()+':'+today.getSeconds());

        Time time = new Time(12,12,12);
        time.setTime(1212112);
        time.setMinutes(12);
        time.setSeconds(12);

        dataBase.addTask(1,"TaskUser1","other111", dateSql, time);

*/

        //Тут дата берется нормально, нынешняя, но только число
       /* java.util.Date dateUtil = new java.util.Date();
       // System.out.println(dateUtil.toString());
        java.sql.Date dateSql = new java.sql.Date(dateUtil.getTime());
        System.out.println(dateSql.toString());*/

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(0);
        //Например 2019.01.27 10:30
        calendar.set(2019,02,27,10,30);
        long dateCalendar = calendar.getTimeInMillis();

        java.sql.Date dateSqlCalendar = new java.sql.Date(dateCalendar);
        java.sql.Time timeSqlCalendar = new java.sql.Time(dateCalendar);

        dataBase.addTask(1,"TaskUser16","other111", dateSqlCalendar, timeSqlCalendar);

        dataBase.printTasksUser(1);



















     /*   dataBase.deleteTask(17);
        dataBase.deleteTask(16);
        dataBase.deleteTask(15);
        dataBase.deleteTask(14);
        dataBase.deleteTask(13);
        dataBase.deleteTask(12);
        dataBase.deleteTask(11);
        dataBase.deleteTask(10);
        dataBase.deleteTask(9);
        dataBase.deleteTask(8);
        dataBase.deleteTask(7);
        dataBase.deleteTask(6);
        dataBase.deleteTask(5);*/
    }
}