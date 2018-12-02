import java.util.List;

public class TaskLog {
    private List<Task> taskList;

    public TaskLog(){

    }

    public TaskLog(List<Task> taskList){
        this.taskList=taskList;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }
}
