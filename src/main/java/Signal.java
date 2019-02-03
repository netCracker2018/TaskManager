import java.sql.SQLException;
import java.util.List;

public class Signal {
    private List<Task> taskList; //Тут все задачи одного пользователя
    private User user;
    private DataBase dataBase;
    private TaskLog taskLog;
    private static ThreadForSignal threadForSignal;

    public Signal(DataBase dataBase,User user) throws SQLException {
        this.dataBase = dataBase;
        taskLog = new TaskLog(dataBase,user);
        this.user=user;
        taskList = taskLog.getTaskList();

        //Запуск не совсем так, нужно, чтобы каждую минуту он сам запускался, сама реализация класса тоже не факт, что верна, т.е. треда
        threadForSignal = new ThreadForSignal(taskList);
        threadForSignal.run();
    }

  /*  public void signalTaskUser(){
        Time time = user.getTaskList().get(1).getTimeTask(); //Взяли время
        time.getTime(); //Получает в милисекундах, как я понял
        time.valueOf("hh:mm:ss"); //Задает время строкой и преобразует - так и будем делать

        //Получение текущей даты
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
    }*/
}