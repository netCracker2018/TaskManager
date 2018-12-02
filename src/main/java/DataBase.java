import javax.xml.crypto.Data;
import java.sql.*;

public class DataBase {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;

    public DataBase() throws SQLException { //Конструктор и соединение с бд
        connectionDB();
//        createDB();
    }

    private void connectionDB() { //connection DB
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("JDBC:sqlite:F:\\SQlite\\Windows\\TaskManager.db");
            statement = connection.createStatement(); //Для sql запросов
            System.out.println("Connection DataBase");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void createDB() throws SQLException {
        statement.execute("CREATE TABLE 'User' (id_user INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\tname_user VARCHAR(50) NOT NULL);");

        statement.execute("CREATE TABLE 'Task' (id_task INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\tname_task VARCHAR(50) NOT NULL,\n" +
                "\tDescriptionTask VARCHAR(150),\n" +
                "\tdateTask DATE,\n" +
                "\ttimeTask TIME,\n" +
                "\tid_user INTEGER NOT NULL,\n" +
                "\tFOREIGN KEY (id_user) REFERENCES User(id_user));");

        System.out.println("Table created");
    }

    public void closeDB() throws SQLException { //Close DB
        connection.close();
        statement.close();
        resultSet.close();
        preparedStatement.close();
    }

    public void deleteDB(String nameDB) throws SQLException { //delete DB
        nameDB.toLowerCase();
        if (nameDB.equals("user")) {
            statement.execute("drop TABLE 'User'");
        } else {
            if (nameDB.equals("Task")) {
                statement.execute("drop TABLE 'Task'");
            } else {
                System.out.println("Такой базы дынных не существует");
            }
        }
    }

    public void addUser(int idUser, String nameUser) throws SQLException { //Добавление пользователя
        preparedStatement = connection.prepareStatement("INSERT into 'user'('id_user','name_user')" + "VALUES (?,?)");
        preparedStatement.setInt(1, idUser);
        preparedStatement.setString(2, nameUser);
        preparedStatement.execute(); //Выполнение запроса
    }

    public void updateUser(int idUser, String nameUser) throws SQLException { //Изменение имени пользователя
        preparedStatement = connection.prepareStatement("UPDATE 'User' set 'name_user' = ? where 'id_user'=?");
        preparedStatement.setString(1, nameUser);
        preparedStatement.setInt(2, idUser);
        preparedStatement.execute();
    }

    public void deleteUser(int idUser) throws SQLException { //Удаление пользователя ????????????//Не очень работает
        preparedStatement = connection.prepareStatement("DELETE from 'user' where 'id_user' = ?");
        preparedStatement.setInt(1, idUser);
        preparedStatement.execute(); //Выполнение запроса
        System.out.println("Пользователь удален");
    }

    public User getUserInDB(int idUser) throws SQLException { //Получение User
        User user = null;
        preparedStatement = connection.prepareStatement("SELECT 'name_user' FROM 'User' where 'id_user'= ? ");
        preparedStatement.setInt(1, idUser);
        resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            user = new User(idUser,resultSet.getString("name_user"));
        }
        return user;
    }

    public void printTableUser() throws SQLException { //Вывод таблицы User
        resultSet = statement.executeQuery("SELECT * FROM 'User'");
        System.out.println("    " + "idUser" + "  " + "nameUser");
        while (resultSet.next()) {
            int idUser = resultSet.getInt("id_user");
            String nameUser = resultSet.getString("name_user");
            System.out.println("    " + idUser + "  " + nameUser);
        }
        System.out.println("БД выведена");
    }

    //Добавление задачи
    public void addTask(int idUser, int idTask, String nameTask, String descriptionTask) throws SQLException { //data and time добавить
        preparedStatement = connection.prepareStatement("INSERT into 'Task'('id_task','name_task','DescriptionTask','dateTask','timeTask','id_user')"+"values (?,?,?,?,?,?)");
        preparedStatement.setInt(1, idTask);
        preparedStatement.setString(2, nameTask);
        preparedStatement.setString(3, descriptionTask);
        preparedStatement.setDate(4, null); //not null
        preparedStatement.setTime(5, null); //not null
        preparedStatement.setInt(6, idUser);
        preparedStatement.execute(); //Выполнение запроса
    }

    //Обновление задачи
    public void updateTask(int idUser, int idTask, String nameTask, String descriptionTask) throws SQLException { //data and time
        preparedStatement = connection.prepareStatement("UPDATE 'Task' set 'name_task' = ?,'DescriptionTask'=?,'dateTask'=?,'timeTask'=? where 'id_user'=? and 'id_task'=?");
        preparedStatement.setString(1, nameTask);
        preparedStatement.setString(2, descriptionTask);
        preparedStatement.setDate(3, null);
        preparedStatement.setTime(4,null );
        preparedStatement.setInt(5, idUser);
        preparedStatement.setInt(6,idTask );
        preparedStatement.execute();
    }

    //Удаление задачи
    public void daleteTask(int idTask) throws SQLException {
        preparedStatement = connection.prepareStatement("DELETE from 'Task' where 'id_task' = ?");
        preparedStatement.setInt(1, idTask);
        preparedStatement.execute(); //Выполнение запроса
        System.out.println("Задача удалена");
    }

    //Вывод таблицы task
    public void printTableTask() throws SQLException {
        resultSet = statement.executeQuery("SELECT * FROM 'Task'");
        System.out.println("    " + "idTask" + "  " + "nameTask"+"  "+"DescriptionTask"+"   "+"Data"+"  "+"Time"+"  "+"idUsr");
        while (resultSet.next()) {
            int idTask = resultSet.getInt("id_task");
            String nameTask = resultSet.getString("name_task");
            String description = resultSet.getString("DescriptionTask");
            Data data = (Data) resultSet.getDate("dateTask");
            Time time = resultSet.getTime("timeTask");
            int idUser = resultSet.getInt("id_user");
            System.out.println("    " + idTask + "  " + nameTask+ "  " +description+"   "+data+"  "+time+"  "+idUser);
        }
        System.out.println("БД выведена");
    }

    //Выводзаписей пользователя
    public void printTasksUser(){

    }

    //Получение из бд листа записей/записи
    //Вывод всех записей для пользователя
}