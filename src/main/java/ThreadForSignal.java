import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class ThreadForSignal extends Thread{
    private List<Task> taskList;
    private int n;
 //   private Scanner scanner;

    public ThreadForSignal(List<Task> taskList, int n){
        this.taskList = taskList;
        this.n=n;
    }

    public void run(){
        while(n==0){
            try {
                sleep(20000); //Приостановка на 20 секунд
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("----------------------------------------------------------------------------------");
            for(int i=0;i<taskList.size();i++){
                Task task = taskList.get(i);
                java.sql.Date dateTask = task.getDateTask();
                java.sql.Time timeTask = task.getTimeTask();

                Calendar calendar = Calendar.getInstance();
                long dateCalendar = calendar.getTimeInMillis();
                java.sql.Date dateNow = new java.sql.Date(dateCalendar);
                java.sql.Time timeNow = new java.sql.Time(dateCalendar);

                if((dateTask.getTime()<=dateNow.getTime())&&(timeTask.getTime()<=timeNow.getTime())){
                    System.out.println("+++++++++++++++++++++++++++");
                    System.out.println("Пришло время выполнения задачи "+task.getIdTask()+" "+task.getNameTask());
                    System.out.println("Date Task "+task.getDateTask()+" Time Task "+task.getTimeTask());
                }
            }

          /*  System.out.println("");
            for(int i=0;i<taskList.size();i++) {
                Task task = taskList.get(i);
                System.out.println("Что вы хотите сделать с "+task.getIdTask()+" задачей?");
                System.out.println("Удалить - 1");
                System.out.println("Изменить - 2");
                System.out.println("Отложить - 3");
                int actForTask = scanner.nextInt();
                action(actForTask,task);
                System.out.println("");
            }*/
        }
    }

  /*  private void action(int actForTask, Task task){
        switch (actForTask){
            case 1: //Удалить

                break;

            case 2: //Изменить
                break;

            case 3: //Отложить
                //на сколько
                break;
        }
    }*/
}