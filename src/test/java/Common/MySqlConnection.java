package Common;

import java.io.IOException;
import java.sql.*;

public class MySqlConnection {
    public static Connection connection;
    public static Statement statement;
    public static ResultSet resultSet;

    public static Connection getConnection(String url, String userName, String password){
        {
            try {
                if(connection == null || connection.isClosed()){
                    connection = DriverManager.getConnection(url, userName, password);
                }
                return connection;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public static ResultSet getResultQuery(String query){
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public static void closeConnection(){
        try{
            if(resultSet != null && !resultSet.isClosed()){
                resultSet.close();
            }
            if(statement != null && !statement.isClosed()){
                statement.close();
            }
            if(connection != null && !connection.isClosed()){
                connection.close();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
