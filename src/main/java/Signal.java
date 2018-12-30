import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Signal {
    private List<Task> taskList; //Тут все задачи, можно выбрать, сигнал только для задач одного пользователя по id или для всех, с указанием владельца задачи
    private User user;
    private DataBase dataBase;
    private TaskLog taskLog;

    public Signal(DataBase dataBase,int idUser) throws SQLException {
        this.dataBase = dataBase;
        taskLog = new TaskLog(dataBase,idUser);
        user = taskLog.getUser();
        taskList = taskLog.getTaskList();
    }

    public void signalTaskUser(){
        Time time = user.getTaskList().get(1).getTimeTask(); //Взяли время
        time.getTime(); //Получает в милисекундах, как я понял
        time.valueOf("hh:mm:ss"); //Задает время строкой и преобразует - так и будем делать

        //Получение текущей даты
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
    }
}