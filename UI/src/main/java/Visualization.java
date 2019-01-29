import java.io.IOException;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Scanner;

public class Visualization {
    private DataBase dataBase;
    private Scanner scanner;
    private User user;

    public Visualization(DataBase dataBase) {
        this.dataBase = dataBase;
        this.scanner = new Scanner(System.in);
    }

    public DataBase getDataBase() {
        return dataBase;
    }

    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public void mainMenu() throws SQLException, IOException {
        System.out.println("Добро пожаловать в Планировщик задач");
        System.out.print("Введите имя пользователя: ");
        System.out.println();
        System.out.println("Для выхода введите 1");
        String name = scanner.next();
        if(name.equals("1")){
            System.exit(0);
        }else{
            if(dataBase.getEqualsUserName(name)){
                user = new User(dataBase.getIdUserInName(name),name,dataBase);
                clearConsole();
                System.out.println("Вход в систему выполнен");
                menuTaskUser();
            }else{
                clearConsole();
                System.out.println("Такого пользователя не существует!");
                mainMenu();
            }
        }
    }

    //меню пользователя
    private void menuTaskUser() throws SQLException, IOException {
        dataBase.printTasksUser(user.getIdUser());
        System.out.println();
        System.out.println("Чтобы добавить задачу, нажмите 1");
        System.out.println("Чтобы удалить задачу, нажмите 2");
        System.out.println("Чтобы редактировать задачу, нажмите 3");
        System.out.println("Чтобы вернуться назад, нажмите 4");
        System.out.println("Чтобы выйти, нажмите 0");
        int button = scanner.nextInt();
        switch(button){
            case 0: //выход
                System.exit(0);
                break;
            case 1: //добавление задачи
                clearConsole();
                addTask();
                break;
            case 2: //удаление задачи
                clearConsole();
                dellTask();
                break;
            case 3: //редактирование задачи
                clearConsole();
                setTask();
                break;
            case 4: //назад
                user = null;
                clearConsole();
                mainMenu();
                break;
        }
    }

    //Добаление задачи
    private void addTask() throws SQLException, IOException { //Разобраться как работает дата и время с sql и как добавить
        System.out.println("Введите название задачи");
        String nameTask = scanner.next();

        //System.out.println("Input Time task в формате hh:mm:ss");

        //for date and time
        java.util.Date today = new java.util.Date();
        java.sql.Timestamp timeStamp = new java.sql.Timestamp(today.getTime());

        java.sql.Date date = new java.sql.Date(today.getDate());

        Time time = new Time(12,12,12);
        time.setTime(1212112);
        time.setMinutes(12);
        time.setSeconds(12);

        System.out.println("Введите описание задачи: ");
        String descriptionTask = scanner.next();

        dataBase.addTask(user.getIdUser(),nameTask,descriptionTask, date, time);
        System.out.println("Задача добавлена.");
        clearConsole();
        menuTaskUser();
    }

    //Удаление задачи
    private void dellTask() throws SQLException, IOException {
        dataBase.printTasksUser(user.getIdUser());
        System.out.println("Введите номер задачи, которую вы хотите удалить: ");
        int idTask = scanner.nextInt();
        if(dataBase.getEqualdTask(idTask)){
            dataBase.deleteTask(idTask);
            System.out.println("Задача удалена");
            clearConsole();
            menuTaskUser();
        }else{
            System.out.println("Такой задачи нет");
            clearConsole();
            dellTask();
        }
    }

    //Изменение задачи
    private void setTask() throws SQLException, IOException {
        dataBase.printTasksUser(user.getIdUser());
        System.out.println("Введите номер задачи, которую вы хотите изменить: ");
        int idTask = scanner.nextInt();
        if (dataBase.getEqualdTask(idTask)) {
            System.out.println("Введите название задачи");
            String nameTask = scanner.next();

            //System.out.println("Input Time task в формате hh:mm:ss");

            //for date and time
            java.util.Date today = new java.util.Date();
            java.sql.Timestamp timeStamp = new java.sql.Timestamp(today.getTime());

            java.sql.Date date = new java.sql.Date(today.getDate());

            Time time = new Time(12,12,12);
            time.setTime(1212112);
            time.setMinutes(12);
            time.setSeconds(12);

            System.out.println("Введите описание задачи: ");
            String descriptionTask = scanner.next();

            dataBase.updateTask(user.getIdUser(), idTask, nameTask, descriptionTask,date,time);
            System.out.println("Задача изменена");
            clearConsole();
            menuTaskUser();
        } else {
            System.out.println("Такой задачи нет");
            clearConsole();
            setTask();
        }
    }

    //Ощищение консоли
    private void clearConsole() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }
}
