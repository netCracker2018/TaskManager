import java.util.List;

public class User {
    private String userName;
    private List<Task> taskList;
    private int idUser;

    public User(int idUser,String userName){
        this.idUser=idUser;
        this.userName=userName;
        //Добавить лист задач, его брать из бд по айди пользователя
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
