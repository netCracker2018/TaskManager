import java.sql.*;

public class DataBase {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    int idUser = 0;

    public DataBase() { //Конструктор и соединение с бд
        connectionDB();
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

    public void addUser(String userName) throws SQLException { //Добавление пользователя
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT into 'user'('id_user','name_user')" + "VALUES (?,?)");
        preparedStatement.setObject(1,idUser);
        preparedStatement.setObject(2,userName);
        preparedStatement.execute(); //Выполнение запроса
        idUser++;
    }

    public void printTableUser() throws SQLException { //Вывод таблицы User
        resultSet = statement.executeQuery("SELECT * FROM user");
        while(resultSet.next()){
            int idUser = resultSet.getInt("id_user");
            String nameUser = resultSet.getString("name_user");
            System.out.println("    "+idUser+"  "+nameUser);
        }
        System.out.println("БД выведена");
    }

    public void deleteUser(int idUser) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE from 'user' where 'id_user' = ?");
        preparedStatement.setObject(1,idUser); //добавить цикл по всем записям в бд и поиском
        System.out.println("Пользователь удален");
    }

    //Создать новую бд в джаве, а ту удалить, просто удалить и там же создать новую
    //Создание бд
    //Удаление бд
    //Удаление записи почему то не удаляет
    //Удалание таблиц
    //Создание таблиц
}