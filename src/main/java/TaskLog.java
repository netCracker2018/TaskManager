import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;

public class TaskLog {
    private List<Task> taskList;
    private User user;
    private DataBase dataBase;

    public TaskLog(DataBase dataBase, int idUser) throws SQLException {
        this.dataBase = dataBase;
        this.taskList = dataBase.getListTasks(dataBase);
        this.user = dataBase.getUserInDB(idUser, dataBase);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public Task getTaskdUser(int idTask) throws SQLException {
        Task task = null;
        if (dataBase.getEqualdTaskUser(idTask, user.getIdUser())) {
            task = dataBase.getTaskUser(this.user.getIdUser(), idTask, dataBase);
        }
        return task;
    }

    public void setTaskUser(Task task) throws SQLException {
        dataBase.updateTask(user.getIdUser(), task.getIdTask(), task.getNameTask(), task.getDescriptionTask(), task.getDateTask(), task.getTimeTask());
        this.taskList = dataBase.getListTasks(dataBase);
    }

    //Возвращает лист задач для пользователя
    public List<Task> getListTaskUser(int idUser) throws SQLException {
        return dataBase.getTasksUser(idUser, dataBase);
    }

    public void addTaskUser(String nameTask, String descriptionTask, Date date, Time time) throws SQLException {
        int idTask = dataBase.countTask() + 1;
        dataBase.addTask(user.getIdUser(), idTask, nameTask, descriptionTask, date, time);
        this.taskList = dataBase.getListTasks(dataBase); //Обновление листа задач в этом классе
    }

    public void deleteTask(int idTask) throws SQLException {
        dataBase.deleteTask(idTask);
        this.taskList = dataBase.getListTasks(dataBase);
    }

    public void daleteAllTaskUser() throws SQLException {
        dataBase.deleteAllTaskUser(user.getIdUser());
        this.taskList = dataBase.getListTasks(dataBase);
    }
}