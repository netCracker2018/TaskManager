import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

public class Task {
    private DataBase dataBase;
    private int idTask;
    private String nameTask;
    private String descriptionTask;
    private int id_User;
    private Date dateTask; //dateTask
    private Time timeTask; //timeTask
    private User user;

    public Task(int idTask, int id_User, String nameTask, String descriptionTask, Date dateTask, Time timeTask, DataBase dataBase) throws SQLException {
        if(dataBase.getEqualsUserId(id_User)){
            this.idTask=idTask;
            this.id_User=id_User;
            this.nameTask=nameTask;
            this.descriptionTask =descriptionTask;
            this.dateTask = dateTask;
            this.timeTask = timeTask;
            this.dataBase=dataBase;
            this.user = dataBase.getUserInDB(id_User,dataBase);
        }else {
            System.out.println("Такого user-a нет в системе");
        }
    }

    public User getUser() {
        return user;
    }

    public DataBase getDataBase() {
        return dataBase;
    }

    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public int getIdTask() {
        return idTask;
    }

    public String getNameTask() {
        return nameTask;
    }

    public void setNameTask(String nameTask) throws SQLException {
        dataBase.updateTask(this.id_User,this.idTask,nameTask,this.descriptionTask,this.dateTask,this.timeTask);
        this.nameTask = nameTask;
    }

    public String getDescriptionTask() {
        return descriptionTask;
    }

    public void setDescriptionTask(String descriptionTask) throws SQLException {
        dataBase.updateTask(this.id_User,this.idTask,this.nameTask,descriptionTask,this.dateTask,this.timeTask);
        this.descriptionTask = descriptionTask;
    }

    public int getId_User() {
        return id_User;
    }

    public Date getDateTask() {
        return dateTask;
    }

    public void setDateTask(Date dateTask) throws SQLException {
        dataBase.updateTask(this.id_User,this.idTask,this.nameTask,this.descriptionTask,dateTask,this.timeTask);
        this.dateTask = dateTask;
    }

    public Time getTimeTask() {
        return timeTask;
    }

    public void setTimeTask(Time timeTask) throws SQLException {
        dataBase.updateTask(this.id_User,this.idTask,this.nameTask,this.descriptionTask,this.dateTask,timeTask);
        this.timeTask = timeTask;
    }
}
