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

        //Запуск потока с уведомлениями
        threadForSignal = new ThreadForSignal(taskList,0);
        threadForSignal.start();
    }
}