package Initialization;

import java.sql.*;

public class DataBase {
    private static final String url = "jdbc:mysql://localhost:3306/hotelDB";
    private static final String username = "root";
    private static final String password = "varun";

    private Connection connection;
    public void initalizeDatabase() throws SQLException, ClassNotFoundException {
        setConnection();
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
    public Connection getConnection(){
        return this.connection;
    }
    public void closeDatabase(){
        try{
            this.connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
