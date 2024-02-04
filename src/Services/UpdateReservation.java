package Services;

import java.sql.*;
import java.util.Collection;
import java.util.Scanner;

public class UpdateReservation extends ReservationExists{
    private final Connection connection;
    private final Scanner scanner;
    public UpdateReservation(Connection connection, Scanner scanner){
        super(connection);
        this.connection = connection;
        this.scanner = scanner;
    }
    public void update()throws SQLException{
        System.out.println("Enter Reservation ID to update: ");
        int reservationID = this.scanner.nextInt();
        this.scanner.nextLine();
        if(!reservationExists(reservationID)){
            System.out.println("No such Reservation ID exists !!!");
            return;
        }
        System.out.print("Enter new Guest Name : ");
        String name = this.scanner.nextLine();
        System.out.print("Enter new Room Number: ");
        int roomNo = this.scanner.nextInt();
        System.out.print("Enter new Contact Number :");
        String contactNumber = this.scanner.next();

        String query = "UPDATE reservations SET guestName = ?, roomNo = ?, contactNumber = ? WHERE reservationID = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1,name);
        preparedStatement.setInt(2,roomNo);
        preparedStatement.setString(3,contactNumber);
        preparedStatement.setInt(4,reservationID);

        int affectedRows = preparedStatement.executeUpdate();
        if(affectedRows > 0){
            System.out.println("Reservation Updates Successfully !!!");
        }else{
            System.out.println("Reservation update Failed!!");
        }
    }
}
