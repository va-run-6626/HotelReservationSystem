package Initialization;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
    private static final String url = "jdbc:mysql://localhost:3306/hotelDB";
    private static final String username = "root";
    private static final String password = "varun";

    private Connection connection;
    private Statement statement;
    public void initalizeDatabase() throws SQLException, ClassNotFoundException {
        setConnection();
        setStatement();
    }
    private void setStatement()throws SQLException {
        try{
            this.statement = this.connection.createStatement();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    private void setConnection() throws SQLException, ClassNotFoundException{
        try{
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
            }catch (ClassNotFoundException e){
                System.out.println(e.getMessage());
            }
            this.connection = DriverManager.getConnection(url,username,password);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public Statement getStatement(){
        return this.statement;
    }
    public void closeDatabase(){
        try{
            this.statement.close();
            this.connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
