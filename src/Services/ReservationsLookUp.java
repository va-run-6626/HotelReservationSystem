package Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ReservationsLookUp {
    private final Statement statement;
    private final Scanner sc;
    public ReservationsLookUp (Statement statement,Scanner sc){
        this.statement = statement;
        this.sc = sc;
    }
    public void lookUp() throws SQLException{
        String query = "SELECT reservationID, guestName, roomNo, contactNumber, reservationDate FROM reservations";
            ResultSet resultSet = this.statement.executeQuery(query);
            System.out.println("Current Reservations: ");
            System.out.println("+----------------+-----------------+---------------+----------------------+------------------------+");
            System.out.println("| reservationID  |    guestName    |    roomNo     |     contactNumber    |     reservationDate    |");
            System.out.println("+----------------+-----------------+---------------+----------------------+------------------------+");
            while (resultSet.next()){
                int reservationID = resultSet.getInt("reservationID");
                String name = resultSet.getString("guestName");
                int roomNo = resultSet.getInt("roomNo");
                String contactNumber = resultSet.getString("contactNumber");
                String reservationDate = resultSet.getTimestamp("reservationDate").toString();

                System.out.printf("| %-14d | %-15s | %-13d | %-20s | %-19s  |\n",reservationID,name,roomNo,contactNumber,reservationDate);
            }
            System.out.println("+----------------+-----------------+---------------+----------------------+------------------------+");
    }
    public void getRoomNumber() throws SQLException{
        System.out.print("Enter Reservation ID: ");
        int reservationId = this.sc.nextInt();
        System.out.print("Enter guest name: ");
        String name = this.sc.next();

        String query = "SELECT roomNo FROM reservations WHERE reservationID = "+reservationId+" AND guestName = '"+ name + "';";
        ResultSet resultSet = this.statement.executeQuery(query);
        if(resultSet.next()){
            int roomNo = resultSet.getInt("roomNo");
            System.out.println("Room number for Reservation ID : " + reservationId +" and Guest : "+ name + " is --> " + roomNo);
        }else{
            System.out.println("NOT FOUND !!!");
        }
        System.out.println();
    }
}
