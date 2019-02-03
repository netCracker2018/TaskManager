import java.util.Calendar;
import java.util.List;

public class ThreadForSignal extends Thread{
    private List<Task> taskList;

    public ThreadForSignal(List<Task> taskList){
        this.taskList = taskList;
    }

    public void run(){
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i=0;i<taskList.size();i++){
            Task task = taskList.get(i);
            java.sql.Date dateTask = task.getDateTask();
            java.sql.Time timeTask = task.getTimeTask();

            Calendar calendar = Calendar.getInstance();
            long dateCalendar = calendar.getTimeInMillis();
            java.sql.Date dateNow = new java.sql.Date(dateCalendar);
            java.sql.Time timeNow = new java.sql.Time(dateCalendar);

            if((dateTask.getTime()>=dateNow.getTime())&&(timeTask.getTime()>=timeNow.getTime())){
                System.out.println();
                System.out.println("Пришло время выполнения задачи "+task.getIdTask()+" "+task.getNameTask());
                System.out.println("Date Task "+task.getDateTask()+" Time Task "+task.getTimeTask());
                System.out.println("Предложение что с ней сделать"); //Доделать то, что с ней сдеать и не в конце консоли писать, а сбоку от основного текста
            }
        }
    }
}