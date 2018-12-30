import java.io.IOException;
import java.sql.SQLException;
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
        System.out.println("Для выода введите 1");
        String name = scanner.next();
        if(name.equals("1")){
            System.exit(0);
        }else{
            if(dataBase.getEqualsUserName(name)){
                user = new User(dataBase.getIdUserInName(name),name,dataBase);
                clearConsole();
                System.out.println("Вход в систему выполнен");
            }else{
                clearConsole();
                System.out.println("Такого пользователя не существует!");
                mainMenu();
            }
        }
    }

    public static void clearConsole() throws IOException {
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
