public class Task {
    private String nameTask;
    //data
    private String descriptionTask;
    private int id_User;

    public Task(String nameTask,int id_User){ //data
        this.nameTask=nameTask;
        this.id_User=id_User;
        descriptionTask = null;
    }

    public Task(String nameTask,int id_User,String descriptionTask){ //data
        this.nameTask=nameTask;
        this.id_User=id_User;
        this.descriptionTask=descriptionTask;
    }

    public Task(int id_User){ //data
        this.id_User=id_User;
        nameTask=null;
        descriptionTask = null;
    }

    public String getNameTask() {
        return nameTask;
    }

    public void setNameTask(String nameTask) {
        this.nameTask = nameTask;
    }

    public String getDescriptionTask() {
        return descriptionTask;
    }

    public void setDescriptionTask(String descriptionTask) {
        this.descriptionTask = descriptionTask;
    }

    public int getId_User() {
        return id_User;
    }

    public void setId_User(int id_User) {
        this.id_User = id_User;
    }
}
