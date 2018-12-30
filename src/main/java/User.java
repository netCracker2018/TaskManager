import java.sql.SQLException;
import java.util.List;

public class User {
    private DataBase dataBase;
    private int idUser;
    private String userName;
    private List<Task> taskList;
    private TaskLog taskLog;

    public User(int idUser,String userName,DataBase dataBase) throws SQLException {
        this.idUser=idUser;
        this.userName=userName;
        this.dataBase = dataBase;
        this.taskLog = new TaskLog(dataBase,idUser);
        this.taskList = taskLog.getListTaskUser(idUser);
    }

    public DataBase getDataBase() {
        return dataBase;
    }

    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public int getIdUser() {
        return idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void updateNameUser(String userNameNew) throws SQLException {
        if(dataBase.getEqualsUserName(userNameNew)){
            System.out.println("Такой пользователь уже есть");
        }else{
            dataBase.updateUser(this.idUser,userNameNew);
            this.userName = userNameNew;
        }
    }

    public List<Task> getTaskList() {
        return taskList;
    }
}