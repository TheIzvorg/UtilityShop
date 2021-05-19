package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConect extends DBConf { // надо уноследовать класс в котором указаны конфигураторы базы
    // (не путать с классом в котором константы таблицы)

    Connection DBConnection; // подключаем сонстанты конктретных таблиц (позволит правильно распределить)

    //метод подключения
    public Connection getDBConnection() // это имя будет использоваться в классе для подключения
    // (например в авторизации, так как мы создали только таблицу user)
            throws ClassNotFoundException, SQLException {
        String commectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName; // переменные инициализации бд,
        // для подключения

        Class.forName("com.mysql.jdbc.Driver");

        DBConnection = DriverManager.getConnection(commectionString, dbUser, dbPassword); // те переменные, которые будет вводить пользователь
        // и будут тригениться на подключение

        return DBConnection;
    }

    //метод записи в таблицу

    public void singUser (String login, String password,
                          String lname, String fname,
                          String email, String gender) throws SQLException, ClassNotFoundException{
        String insert = "INSERT INTO" + DBConstant.USER_TABLE + "(" +
                DBConstant.USER_LOGIN + DBConstant.USER_PASSWORD +
                DBConstant.USER_LNAME + DBConstant.USER_FNAME +
                DBConstant.USER_EMAIL + DBConstant.USER_GENDER +
                ")" + "VALUES (?,?,?,?,?,?)";

        PreparedStatement preparedStatement = getDBConnection().prepareStatement(insert);
        preparedStatement.setString(1,login);
        preparedStatement.setString(2,password);
        preparedStatement.setString(3,lname);
        preparedStatement.setString(4,fname);
        preparedStatement.setString(5,email);
        preparedStatement.setString(6,gender);

        preparedStatement.executeUpdate();
    }

    //метод считывания

}
