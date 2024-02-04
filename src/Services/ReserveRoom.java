package Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ReserveRoom {
    private final Connection connection;
    private final Scanner scanner;
    public ReserveRoom(Connection connection, Scanner scanner){
            this.connection = connection;
            this.scanner = scanner;
    }
    public void allotRoom() throws SQLException{
        System.out.print("Enter Guest Name :");
        String name = this.scanner.next();
        //this.scanner.nextLine();
        System.out.print("Enter Room Number: ");
        int roomNumber = scanner.nextInt();
        System.out.print("Enter Contact Number: ");
        String contactNumber = scanner.next();

        String query = "INSERT INTO reservations (guestName, roomNo, contactNumber) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1,name);
        preparedStatement.setInt(2,roomNumber);
        preparedStatement.setString(3,contactNumber);

        int affectedRows = preparedStatement.executeUpdate();
        if(affectedRows > 0){
            System.out.println("Reservation Successful!!");
        }else{
            System.out.println("Reservation Failed!");
        }
        System.out.println();
    }
}
